package notebook.service;

import java.sql.SQLException;
import java.util.List;

import notebook.dao.BoardAnswerDaoImpl;
import notebook.dao.BoardQnADao;
import notebook.dao.BoardQnADaoImpl;
import notebook.domain.BoardAnswer;
import notebook.domain.BoardQnA;
import notebook.exception.CannotModifyException;
import notebook.exception.NotFoundException;

public class QnAService {
	
	private static BoardQnADao bd = new BoardQnADaoImpl();
	
	/**
	 * 게시물 상세보기_조회수 증가.
	 * @param qnaNo
	 * @param flag
	 * @return
	 * @throws SQLException
	 * @throws NotFoundException
	 */
	public static BoardQnA selectByNo(int qnaNo, boolean flag) throws SQLException, NotFoundException{
		
		if(flag) {
			if(bd.increamentView(qnaNo) == 0) {
				throw new SQLException("조회수 증가에 오류가 발생했습니다.");
			}
		}
		
		BoardQnA boardQna = bd.selectByNo(qnaNo);
		if(boardQna == null) {
			throw new NotFoundException("해당하는 게시물 정보를 불러 올 수 없습니다.");
		}
		List<BoardAnswer> list = new BoardAnswerDaoImpl().selectByQnaNo(qnaNo);
		boardQna.setAnswers(list);
		
		return boardQna;
	}
	
	public static List<BoardQnA> selectBySerialNum(String serialNum) throws SQLException {
		List<BoardQnA> list = bd.selectBySerialNum(serialNum);
		
		return list;
		
	}
	
	/**
	 * 게시물 전체보기
	 * @return
	 * @throws SQLException
	 * @throws NotFoundException 
	 */
	public static List<BoardQnA> selectAll() throws SQLException, NotFoundException {
		List<BoardQnA> list = bd.selectAll();
		return list;
	}
	
	/**
	 * 게시물 수정하기
	 * @throws CannotModifyException 
	 */
	public static void update(BoardQnA board) throws SQLException, CannotModifyException{
		
		//BoardQnADao dbboard = bd.selectByNo(board.getPassword())
		BoardQnADao b = new BoardQnADaoImpl();
		int result = b.update(board);
		if(result == 0) {
			throw new CannotModifyException("수정이 불가능 합니다.");
		}
	}
	
	/**
	 * 게시물 등록하기(공지 등)
	 */
	public static void insert(BoardQnA board) throws SQLException{
		BoardQnADao b = new BoardQnADaoImpl();
		b.insert(board);
	}
	
	/**
	 * 게시물 삭제
	 * @param qnaNo
	 * @throws SQLException
	 * @throws CannotModifyException
	 */
	public static void delete(int qnaNo) throws SQLException, CannotModifyException {
		int result = bd.delete(qnaNo);
		if(result == 0) {
			throw new CannotModifyException("삭제되지 않았습니다.");
		}
	}
	
	
}
