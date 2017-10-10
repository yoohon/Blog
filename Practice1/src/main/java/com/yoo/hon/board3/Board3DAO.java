package com.yoo.hon.board3;

import java.util.List;

import com.yoo.hon.common.FileVO;
import com.yoo.hon.common.PageVO;
import com.yoo.hon.common.SearchVO;

public interface Board3DAO {
    public Integer selectBoard3Count(SearchVO param);
    public List<?> selectBoard3List(PageVO param);
    public void insertBoard3(Board3DTO param, List<FileVO> fileList, String[] fileno) throws Exception;
    public Board3DTO selectBoard3One(String brdno);
    public void deleteBoard3(String brdno);
    public void updateBoard3(Board3DTO param);
    public void updateBoard3Read(String brdno);
    public List<?> selectBoard3FileList(String brdno);
}
