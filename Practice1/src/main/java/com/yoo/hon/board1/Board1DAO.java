package com.yoo.hon.board1;

import java.util.List;

public interface Board1DAO {
    List<?> selectBoardList();
    public void insertBoard1(Board1DTO param);
    public Board1DTO selectBoardOne(String brdno);
    public void deleteBoard1(String brdno);
    public void updateBoard1(Board1DTO param);
}
