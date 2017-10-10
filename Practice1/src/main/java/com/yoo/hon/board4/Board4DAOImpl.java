package com.yoo.hon.board4;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.yoo.hon.common.FileVO;
import com.yoo.hon.common.PageVO;
import com.yoo.hon.common.SearchVO;

@Repository("board4DAO")
public class Board4DAOImpl implements Board4DAO {
    
    @Autowired
    SqlSessionTemplate sqlSession;
    
    @Autowired
    private DataSourceTransactionManager txManager;
    
    public Integer selectBoard4Count(SearchVO param) {
        return sqlSession.selectOne("selectBoard4Count");
    }
    
    public List<?> selectBoard4List(PageVO param) {
        return sqlSession.selectList("selectBoard4List", param);
    }
    
    public void insertBoard4(Board4DTO param) {
        sqlSession.insert("insertBoard4", param);
    }
  
    public Board4DTO selectBoard4One(String brdno) {
        return sqlSession.selectOne("selectBoard4One", brdno);
    }

    public void deleteBoard4(String brdno) {
        sqlSession.delete("deleteBoard4One", brdno);
    }
    
    public void updateBoard4(Board4DTO param) {
        sqlSession.update("updateBoard4", param);
    }

    public void updateBoard4Read(String brdno) {
        sqlSession.update("updateBoard4Read", brdno);
    }

    @Override
    public void insertBoard4(Board4DTO param, List<FileVO> fileList, String[] fileno) throws Exception {
        
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(def);

        try{
            if (param.getBrdno()==null || "".equals(param.getBrdno()))
                   sqlSession.insert("insertBoard4", param);
            else sqlSession.update("updateBoard4", param);
            
            // 폼에서 저장할 때, 파일에 대한 리스트가 넘어오면 삭제하는 것으로 인지한다.
            if (fileno != null) {
                HashMap p = new HashMap();
                p.put("fileno", fileno) ;
                sqlSession.insert("deleteBoard4File", p);
            }


            for (FileVO f : fileList) {
                f.setParentPK(param.getBrdno());
                sqlSession.insert("insertBoard4File", f);
            }
            txManager.commit(status);
        } catch (Exception ex) {
            txManager.rollback(status);
            throw ex;
        }  

    }

    @Override
    public List<?> selectBoard4FileList(String brdno) {
        return sqlSession.selectList("selectBoard4FileList", brdno);
    }
    
    @Override
    public void insertBoardReply(BoardReplyVO param) {
        if (param.getReno()==null || "".equals(param.getReno())) {
            sqlSession.insert("insertBoard4Reply", param);
        } else {
            sqlSession.insert("updateBoard4Reply", param);
        }
    }
    
    @Override
    public List<?> selectBoard4ReplyList(String param) {
        return sqlSession.selectList("selectBoard4ReplyList", param);
    }

    @Override
    public void deleteBoard4Reply(String param) {
        sqlSession.delete("deleteBoard4Reply", param);
    }    

}