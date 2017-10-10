package com.yoo.hon.board1;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Board1Controller {
   
    @Autowired
    Board1Svc board1Svc;
    
    @RequestMapping(value = "/board1List")
    public String board1List(ModelMap modelMap) throws Exception {
        List<?> listview = board1Svc.selectBoardList();
        
        modelMap.addAttribute("listview",listview);
        
        return "board1/board1List";
    }
    
    @RequestMapping(value = "/board1Form")
    public String board1Form() throws Exception {
            return "board1/board1Form";
    }
    
    @RequestMapping(value = "/board1Save")
    public String boardSave(@ModelAttribute Board1DTO boardInfo) {
        
            board1Svc.insertBoard1(boardInfo);
                
            return "redirect:/board1List";
    }
    
    @RequestMapping(value = "/board1Read")
    public String boardRead(HttpServletRequest request, ModelMap modelMap) {
            
            String brdno = request.getParameter("brdno");
            
            Board1DTO boardInfo = board1Svc.selectBoardOne(brdno);
            
            modelMap.addAttribute("boardInfo", boardInfo);
            
            return "board1/board1Content";
    }
    
    @RequestMapping(value = "/board1Delete")
    public String boardDelete(HttpServletRequest request, ModelMap modelMap) {
            
            String brdno = request.getParameter("brdno");
            
            board1Svc.deleteBoard1(brdno);
            
            return "redirect:/board1List";
    }
    @RequestMapping(value = "/board1Update")
    public String boardUpdate(HttpServletRequest request, ModelMap modelMap) throws Exception {
            
            String brdno = request.getParameter("brdno");
            
            Board1DTO boardInfo = board1Svc.selectBoardOne(brdno);
            
            modelMap.addAttribute("boardInfo", boardInfo);
            
            return "board1/board1Update";
    }
    
    @RequestMapping(value = "/board1UpdateSave")
    public String board1UpdateSave(@ModelAttribute Board1DTO boardInfo) throws Exception {
        
            board1Svc.updateBoard1(boardInfo);
            
            return "redirect:/board1List";
    }
}
