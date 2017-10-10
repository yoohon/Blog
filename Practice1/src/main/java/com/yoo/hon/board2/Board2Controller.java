package com.yoo.hon.board2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yoo.hon.common.SearchVO;

@Controller
public class Board2Controller {
   
    @Autowired
    Board2Svc board2Svc;
    
    @RequestMapping(value = "/board2List")
    public String board2List(SearchVO searchVO, ModelMap modelMap) throws Exception {
        
        searchVO.pageCalculate( board2Svc.selectBoard2Count(searchVO) ); // startRow, endRow

        List<?> listview   = board2Svc.selectBoard2List(searchVO);
        
        modelMap.addAttribute("listview", listview);
        modelMap.addAttribute("searchVO", searchVO);
        
        return "board2/board2List";
    }
    
    @RequestMapping(value = "/board2Form")
    public String boardForm(HttpServletRequest request, ModelMap modelMap) throws Exception {
        String brdno = request.getParameter("brdno");
        if (brdno!=null) {
            Board2DTO boardInfo = board2Svc.selectBoard2One(brdno);
            modelMap.addAttribute("boardInfo", boardInfo);
        }
        return "board2/board2Form";
    }

    @RequestMapping(value = "/board2Save")
    public String boardSave(@ModelAttribute Board2DTO boardInfo) {
        
        if (boardInfo.getBrdno()==null || boardInfo.getBrdno().equals(""))
            board2Svc.insertBoard2(boardInfo);
        else board2Svc.updateBoard2(boardInfo);
                
            return "redirect:/board2List";
    }
    
    @RequestMapping(value = "/board2Read")
    public String boardRead(HttpServletRequest request, ModelMap modelMap) {
            
            String brdno = request.getParameter("brdno");
            
            Board2DTO boardInfo = board2Svc.selectBoard2One(brdno);
            board2Svc.updateBoard2Read(brdno);
            modelMap.addAttribute("boardInfo", boardInfo);
            
            return "board2/board2Content";
    }
    
    @RequestMapping(value = "/board2Delete")
    public String boardDelete(HttpServletRequest request, ModelMap modelMap) {
            
            String brdno = request.getParameter("brdno");
            
            board2Svc.deleteBoard2(brdno);
            
            return "redirect:/board2List";
    }

}
