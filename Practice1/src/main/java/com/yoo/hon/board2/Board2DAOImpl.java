package com.yoo.hon.board2;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yoo.hon.common.PageVO;
import com.yoo.hon.common.SearchVO;

@Repository("board2DAO")
public class Board2DAOImpl implements Board2DAO {
    
    @Autowired
    SqlSessionTemplate sqlSession;    

    public Integer selectBoard2Count(SearchVO param) {
        return sqlSession.selectOne("selectBoard2Count");
    }
    
    public List<?> selectBoard2List(PageVO param) {
        return sqlSession.selectList("selectBoard2List", param);
    }
    
    public void insertBoard2(Board2DTO param) {
        sqlSession.insert("insertBoard2", param);
    }
  
    public Board2DTO selectBoard2One(String brdno) {
        return sqlSession.selectOne("selectBoard2One", brdno);
    }

    public void deleteBoard2(String brdno) {
        sqlSession.delete("deleteBoard2One", brdno);
    }
    
    public void updateBoard2(Board2DTO param) {
        sqlSession.update("updateBoard2", param);
    }

    public void updateBoard2Read(String brdno) {
        sqlSession.update("updateBoard2Read", brdno);
    }

}
