package com.yoo.hon.board3;

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
public class Board3Controller {
   
    @Autowired
    Board3Svc board3Svc;
    
    @RequestMapping(value = "/board3List")
    public String board3List(SearchVO searchVO, ModelMap modelMap) throws Exception {
        
        searchVO.pageCalculate( board3Svc.selectBoard3Count(searchVO) ); // startRow, endRow

        List<?> listview   = board3Svc.selectBoard3List(searchVO);
        
        modelMap.addAttribute("listview", listview);
        modelMap.addAttribute("searchVO", searchVO);
        
        return "board3/board3List";
    }
    
    @RequestMapping(value = "/board3Form")
    public String boardForm(HttpServletRequest request, ModelMap modelMap) throws Exception {
        String brdno = request.getParameter("brdno");
        if (brdno!=null) {
            Board3DTO boardInfo = board3Svc.selectBoard3One(brdno);
            List<?> listview = board3Svc.selectBoard3FileList(brdno);

            modelMap.addAttribute("boardInfo", boardInfo);
            modelMap.addAttribute("listview", listview);

        }
        return "board3/board3Form";
    }

    @RequestMapping(value = "/board3Save")
    public String boardSave(HttpServletRequest request,  Board3DTO boardInfo) throws Exception {
        String[] fileno = request.getParameterValues("fileno");

        FileUtil fu = new FileUtil();
        
        List<FileVO> fileList = fu.saveAllFiles(boardInfo.getUploadfile()); 
                
        board3Svc.insertBoard3(boardInfo, fileList, fileno);

        return "redirect:/board3List";
    }
    
    @RequestMapping(value = "/board3Read")
    public String boardRead(HttpServletRequest request, ModelMap modelMap) {
            
            String brdno = request.getParameter("brdno");
            
            Board3DTO boardInfo = board3Svc.selectBoard3One(brdno);
            board3Svc.updateBoard3Read(brdno);
            List<?> listview = board3Svc.selectBoard3FileList(brdno);
            
            modelMap.addAttribute("boardInfo", boardInfo);
            modelMap.addAttribute("listview", listview);
            
            return "board3/board3Content";
    }
    
    @RequestMapping(value = "/board3Delete")
    public String boardDelete(HttpServletRequest request, ModelMap modelMap) {
            
            String brdno = request.getParameter("brdno");
            
            board3Svc.deleteBoard3(brdno);
            
            return "redirect:/board3List";
    }
    
   
}
