package com.yoo.hon.board3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.yoo.hon.common.FileVO;
import com.yoo.hon.common.PageVO;
import com.yoo.hon.common.SearchVO;

@Service("board3Svc")
public class Board3Svc {
    
    @Autowired
    Board3DAO board3DAO;
    
    public Integer selectBoard3Count(SearchVO param) {
        return board3DAO.selectBoard3Count(param);
    }
    
    public List<?> selectBoard3List(PageVO param) {
        return board3DAO.selectBoard3List(param);
    }
    
    public void insertBoard3(@ModelAttribute Board3DTO boardInfo, List<FileVO> fileList, String[] fileno) throws Exception {
        board3DAO.insertBoard3(boardInfo, fileList, fileno);
    }
    public List<?> selectBoard3FileList(String brdno) {
        return board3DAO.selectBoard3FileList(brdno);
    }
    
    public Board3DTO selectBoard3One(String brdno) {
        return board3DAO.selectBoard3One(brdno);
    }
    
    public void deleteBoard3(String brdno) {
        board3DAO.deleteBoard3(brdno);
    }
    
    public void updateBoard3(Board3DTO param) {
        board3DAO.updateBoard3(param);
    }    
    public void updateBoard3Read(String brdno) {
        board3DAO.updateBoard3Read(brdno);
    }
}
