package com.yoo.hon.board2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.yoo.hon.common.PageVO;
import com.yoo.hon.common.SearchVO;

@Service("board2Svc")
public class Board2Svc {
    
    @Autowired
    Board2DAO board2DAO;
    
    public Integer selectBoard2Count(SearchVO param) {
        return board2DAO.selectBoard2Count(param);
    }
    
    public List<?> selectBoard2List(PageVO param) {
        return board2DAO.selectBoard2List(param);
    }
    
    public void insertBoard2(@ModelAttribute Board2DTO boardInfo) {
        board2DAO.insertBoard2(boardInfo);
    }
    
    public Board2DTO selectBoard2One(String brdno) {
        return board2DAO.selectBoard2One(brdno);
    }
    
    public void deleteBoard2(String brdno) {
        board2DAO.deleteBoard2(brdno);
    }
    
    public void updateBoard2(Board2DTO param) {
        board2DAO.updateBoard2(param);
    }    
    public void updateBoard2Read(String brdno) {
        board2DAO.updateBoard2Read(brdno);
    }
}
