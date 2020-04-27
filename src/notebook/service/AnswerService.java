package notebook.service;

import java.sql.SQLException;

import notebook.dao.BoardAnswerDao;
import notebook.dao.BoardAnswerDaoImpl;
import notebook.domain.BoardAnswer;
import notebook.exception.CannotModifyException;
import notebook.exception.NotFoundException;

public class AnswerService {
	private static BoardAnswerDao ans = new BoardAnswerDaoImpl();
	
	public static void delete(int ansNo, int qnaNo) throws SQLException, NotFoundException, CannotModifyException{
		int result = ans.delete(ansNo, qnaNo);
		if(result == 0 ) {
			throw new SQLException("삭제되지 않았습니다.");
		}
	}
	
	/**
	 * 답변등록_답변 상태 1로 변경(0:미답변, 1:답변완료)
	 * @param answer
	 * @throws SQLException
	 * @throws CannotModifyException
	 */
	public static void insert(BoardAnswer answer) throws SQLException, CannotModifyException{
		int result = ans.insert(answer);
		if(result == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}
	}
	
	/**
	 * 답변 수정
	 * @param answer
	 * @throws SQLException
	 * @throws CannotModifyException
	 */
	public static void update(BoardAnswer answer) throws SQLException, CannotModifyException{
		int result = ans.update(answer);
		if(result == 0) {
			throw new CannotModifyException("수정되지 않았습니다.");
		}
	}
	
	public static BoardAnswer selectByNo(int ansNo) throws SQLException, NotFoundException{
		BoardAnswer answer = ans.selectByNo(ansNo);
		if(answer == null) {
			throw new NotFoundException("답변을 찾을 수 없습니다.");
		}
		return answer;
	}
}
