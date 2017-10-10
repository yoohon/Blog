package com.yoo.hon.board4;

import java.util.List;

import com.yoo.hon.common.FileVO;
import com.yoo.hon.common.PageVO;
import com.yoo.hon.common.SearchVO;

public interface Board4DAO {
    public Integer selectBoard4Count(SearchVO param);
    public List<?> selectBoard4List(PageVO param);
    public void insertBoard4(Board4DTO param, List<FileVO> fileList, String[] fileno) throws Exception;
    public Board4DTO selectBoard4One(String brdno);
    public void deleteBoard4(String brdno);
    public void updateBoard4(Board4DTO param);
    public void updateBoard4Read(String brdno);
    public List<?> selectBoard4FileList(String brdno);
    public void insertBoardReply(BoardReplyVO param);
    public List<?> selectBoard4ReplyList(String param);
    public void deleteBoard4Reply(String param);
}
