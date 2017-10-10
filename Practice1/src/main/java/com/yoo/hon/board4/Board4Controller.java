package com.yoo.hon.board4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yoo.hon.common.FileUtil;
import com.yoo.hon.common.FileVO;
import com.yoo.hon.common.SearchVO;

@Controller
public class Board4Controller {
   
    @Autowired
    Board4Svc board4Svc;
    
    @RequestMapping(value = "/board4List")
    public String board4List(SearchVO searchVO, ModelMap modelMap) throws Exception {
        
        searchVO.pageCalculate( board4Svc.selectBoard4Count(searchVO) ); // startRow, endRow

        List<?> listview   = board4Svc.selectBoard4List(searchVO);
        
        modelMap.addAttribute("listview", listview);
        modelMap.addAttribute("searchVO", searchVO);
        
        return "board4/board4List";
    }
    
    @RequestMapping(value = "/board4Form")
    public String boardForm(HttpServletRequest request, ModelMap modelMap) throws Exception {
        String brdno = request.getParameter("brdno");
        if (brdno!=null) {
            Board4DTO boardInfo = board4Svc.selectBoard4One(brdno);
            List<?> listview = board4Svc.selectBoard4FileList(brdno);

            modelMap.addAttribute("boardInfo", boardInfo);
            modelMap.addAttribute("listview", listview);

        }
        return "board4/board4Form";
    }

    @RequestMapping(value = "/board4Save")
    public String boardSave(HttpServletRequest request,  Board4DTO boardInfo) throws Exception {
        String[] fileno = request.getParameterValues("fileno");

        FileUtil fu = new FileUtil();
        
        List<FileVO> fileList = fu.saveAllFiles(boardInfo.getUploadfile()); 
                
        board4Svc.insertBoard4(boardInfo, fileList, fileno);

        return "redirect:/board4List";
    }
    
    @RequestMapping(value = "/board4Read")
    public String boardRead(HttpServletRequest request, ModelMap modelMap) {
            
            String brdno = request.getParameter("brdno");
            
            Board4DTO boardInfo = board4Svc.selectBoard4One(brdno);
            board4Svc.updateBoard4Read(brdno);
            List<?> listview = board4Svc.selectBoard4FileList(brdno);
            List<?> replylist = board4Svc.selectBoard4ReplyList(brdno);
            
            modelMap.addAttribute("replylist", replylist);
            
            modelMap.addAttribute("boardInfo", boardInfo);
            modelMap.addAttribute("listview", listview);
            
            return "board4/board4Content";
    }
    
    @RequestMapping(value = "/board4Delete")
    public String boardDelete(HttpServletRequest request, ModelMap modelMap) {
            
            String brdno = request.getParameter("brdno");
            
            board4Svc.deleteBoard4(brdno);
            
            return "redirect:/board4List";
    }
    
    /**
     * 댓글 저장.
     */
    @RequestMapping(value = "/board4ReplySave")
    public String board5ReplySave(HttpServletRequest request, BoardReplyVO boardReplyInfo) {
        
        board4Svc.insertBoardReply(boardReplyInfo);

        return "redirect:/board4Read?brdno=" + boardReplyInfo.getBrdno();
    }

    @RequestMapping(value = "/board4ReplyDelete")
    public String board4ReplyDelete(HttpServletRequest request, BoardReplyVO boardReplyInfo) {
        
        board4Svc.deleteBoard4Reply(boardReplyInfo.getReno());

        return "redirect:/board4Read?brdno=" + boardReplyInfo.getBrdno();
    }

   
}
