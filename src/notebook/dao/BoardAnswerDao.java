package notebook.dao;

import java.sql.SQLException;
import java.util.List;

import notebook.domain.BoardAnswer;

public interface BoardAnswerDao {
	/**
	 * qna게시판 하나 눌렀을 때 답변 가져오기
	 * @param qnaNo
	 * @return
	 * @throws SQLException 
	 */
	public List<BoardAnswer> selectByQnaNo(int qnaNo) throws SQLException;
	
	/**
	 * 답변 수정
	 * @param answer
	 * @return
	 */
	public int update(BoardAnswer answer) throws SQLException;
	
	/**
	 * 답변 삭제
	 * @param ansNo
	 * @return
	 */
	public int delete(int ansNo) throws SQLException;
	
	/**
	 * 답변 등록
	 * @param answer
	 * @return
	 */
	public int insert(BoardAnswer answer) throws SQLException;
}
