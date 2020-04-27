package notebook.dao;

import java.sql.SQLException;
import java.util.List;

import notebook.domain.BoardAnswer;
import notebook.exception.CannotModifyException;
import notebook.exception.NotFoundException;

public interface BoardAnswerDao {
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
	public int delete(int ansNo, int qnaNo) throws SQLException, NotFoundException, CannotModifyException;
	
	/**
	 * 답변 등록
	 * @param answer
	 * @return
	 */
	public int insert(BoardAnswer answer) throws SQLException, CannotModifyException;
	
	/**
	 * 게시물 답변 가져오기
	 */
	public List<BoardAnswer> selectByQnaNo(int qnaNo) throws SQLException;
}
