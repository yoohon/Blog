package com.yoo.hon.board4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.yoo.hon.common.FileVO;
import com.yoo.hon.common.PageVO;
import com.yoo.hon.common.SearchVO;

@Service("board4Svc")
public class Board4Svc {
    
    @Autowired
    Board4DAO board4DAO;
    
    public Integer selectBoard4Count(SearchVO param) {
        return board4DAO.selectBoard4Count(param);
    }
    
    public List<?> selectBoard4List(PageVO param) {
        return board4DAO.selectBoard4List(param);
    }
    
    public void insertBoard4(@ModelAttribute Board4DTO boardInfo, List<FileVO> fileList, String[] fileno) throws Exception {
        board4DAO.insertBoard4(boardInfo, fileList, fileno);
    }
    public List<?> selectBoard4FileList(String brdno) {
        return board4DAO.selectBoard4FileList(brdno);
    }
    
    public Board4DTO selectBoard4One(String brdno) {
        return board4DAO.selectBoard4One(brdno);
    }
    
    public void deleteBoard4(String brdno) {
        board4DAO.deleteBoard4(brdno);
    }
    
    public void updateBoard4(Board4DTO param) {
        board4DAO.updateBoard4(param);
    }    
    public void updateBoard4Read(String brdno) {
        board4DAO.updateBoard4Read(brdno);
    }
    public void insertBoardReply(BoardReplyVO param) {
        board4DAO.insertBoardReply(param);
    }
    public List<?> selectBoard4ReplyList(String param) {
        return board4DAO.selectBoard4ReplyList(param);
    }
    public void deleteBoard4Reply(String param) {
        board4DAO.deleteBoard4Reply(param);
    }    
    
}
