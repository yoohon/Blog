package com.yoo.hon.board1;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("board1DAO")
public class Board1DAOImpl implements Board1DAO {
    
    @Autowired
    SqlSessionTemplate sqlSession;    

    public List<?> selectBoardList() {
        return sqlSession.selectList("selectBoard1List");
    }
    public void insertBoard1(Board1DTO param) {
        sqlSession.insert("insertBoard1", param);
    }
  
    public Board1DTO selectBoardOne(String brdno) {
        return sqlSession.selectOne("selectBoard1One", brdno);
    }

    public void deleteBoard1(String brdno) {
        sqlSession.delete("deleteBoard1One", brdno);
    }
    
    public void updateBoard1(Board1DTO param) {
        sqlSession.update("updateBoard1", param);
    }

}
