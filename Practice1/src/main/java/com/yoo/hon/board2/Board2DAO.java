package com.yoo.hon.board2;

import java.util.List;

import com.yoo.hon.common.PageVO;
import com.yoo.hon.common.SearchVO;

public interface Board2DAO {
    public Integer selectBoard2Count(SearchVO param);
    public List<?> selectBoard2List(PageVO param);
    public void insertBoard2(Board2DTO param);
    public Board2DTO selectBoard2One(String brdno);
    public void deleteBoard2(String brdno);
    public void updateBoard2(Board2DTO param);
    public void updateBoard2Read(String brdno);
}
