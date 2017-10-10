package com.yoo.hon.board1;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service("board1Svc")
public class Board1Svc {
    
    @Autowired
    Board1DAO board1DAO;
    
    public List<?> selectBoardList() {
        return board1DAO.selectBoardList();
    }
    
    public void insertBoard1(@ModelAttribute Board1DTO boardInfo) {
        board1DAO.insertBoard1(boardInfo);
    }
    
    public Board1DTO selectBoardOne(String brdno) {
        return board1DAO.selectBoardOne(brdno);
    }
    
    public void deleteBoard1(String brdno) {
        board1DAO.deleteBoard1(brdno);
    }
    
    public void updateBoard1(Board1DTO param) {
        board1DAO.updateBoard1(param);
    }
}
