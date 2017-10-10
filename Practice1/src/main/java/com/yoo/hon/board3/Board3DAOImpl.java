package com.yoo.hon.board3;

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

@Repository("board3DAO")
public class Board3DAOImpl implements Board3DAO {
    
    @Autowired
    SqlSessionTemplate sqlSession;
    
    @Autowired
    private DataSourceTransactionManager txManager;
    
    public Integer selectBoard3Count(SearchVO param) {
        return sqlSession.selectOne("selectBoard3Count");
    }
    
    public List<?> selectBoard3List(PageVO param) {
        return sqlSession.selectList("selectBoard3List", param);
    }
    
    public void insertBoard3(Board3DTO param) {
        sqlSession.insert("insertBoard3", param);
    }
  
    public Board3DTO selectBoard3One(String brdno) {
        return sqlSession.selectOne("selectBoard3One", brdno);
    }

    public void deleteBoard3(String brdno) {
        sqlSession.delete("deleteBoard3One", brdno);
    }
    
    public void updateBoard3(Board3DTO param) {
        sqlSession.update("updateBoard3", param);
    }

    public void updateBoard3Read(String brdno) {
        sqlSession.update("updateBoard3Read", brdno);
    }

    @Override
    public void insertBoard3(Board3DTO param, List<FileVO> fileList, String[] fileno) throws Exception {
        
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(def);

        try{
            if (param.getBrdno()==null || "".equals(param.getBrdno()))
                   sqlSession.insert("insertBoard3", param);
            else sqlSession.update("updateBoard3", param);
            
            // 폼에서 저장할 때, 파일에 대한 리스트가 넘어오면 삭제하는 것으로 인지한다.
            if (fileno != null) {
                HashMap p = new HashMap();
                p.put("fileno", fileno) ;
                sqlSession.insert("deleteBoard3File", p);
            }


            for (FileVO f : fileList) {
                f.setParentPK(param.getBrdno());
                sqlSession.insert("insertBoard3File", f);
            }
            txManager.commit(status);
        } catch (Exception ex) {
            txManager.rollback(status);
            throw ex;
        }  

    }

    @Override
    public List<?> selectBoard3FileList(String brdno) {
        return sqlSession.selectList("selectBoard3FileList", brdno);
    }

}