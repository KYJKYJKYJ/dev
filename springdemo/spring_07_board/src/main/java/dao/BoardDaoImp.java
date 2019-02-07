package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.BoardDTO;
import dto.PageDTO;

public class BoardDaoImp implements BoardDAO{
   private SqlSessionTemplate sqlSession;

   public BoardDaoImp() {

   }

   public BoardDaoImp(SqlSessionTemplate sqlSession) {
      this.sqlSession = sqlSession;
   }

   public void setSqlSession(SqlSessionTemplate sqlSession) {
      this.sqlSession = sqlSession;
   }

   @Override
   public int count() {
      return sqlSession.selectOne("board.count");
   }

   @Override
   public List<BoardDTO> list(PageDTO pv) {
      return sqlSession.selectList("board.list", pv);
   }

   // readCount 와 content 는 하나로 동작한다. // 한개의 트랜잭션에 두가지 기능 수행
   @Override
   public void readCount(int num) {
      sqlSession.selectOne("board.readCount", num);      
   }

   @Override
   public BoardDTO content(int num) {
      return sqlSession.selectOne("board.content", num);
   }

   // 답변 글 일 때는 reStepCount, save 두개 다 사용, 제목글 일 때는 save만 사용
   @Override
   public void reStepCount(BoardDTO dto) {
      sqlSession.update("board.reStepCount", dto);
   }

   @Override
   public void save(BoardDTO dto) {
      sqlSession.insert("board.save", dto);      
   }

   @Override
   public BoardDTO updateNum(int num) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void update(BoardDTO dto) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void delete(int num) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public String getFile(int num) {
      // TODO Auto-generated method stub
      return null;
   }

} // end class