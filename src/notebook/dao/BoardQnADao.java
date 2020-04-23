package notebook.dao;

import java.sql.SQLException;
import java.util.List;

import notebook.domain.BoardQnA;

public interface BoardQnADao {
	/**
	 * 게시물 하나 클릭해서 볼 때
	 * @param qnaNo
	 * @return
	 */
	public BoardQnA selectByNo(int qnaNo) throws SQLException;
	
	/**
	 * 상품 상세보기시 qna가져올 때
	 * @param serialNum
	 * @return
	 */
	public List<BoardQnA> selectBySerialNum(String serialNum) throws SQLException;
	
	/**
	 * qna게시판
	 * @return
	 */
	public List<BoardQnA> selectAll() throws SQLException;
	
	/**
	 * 게시물 수정
	 * @param board
	 * @return
	 */
	public int update(BoardQnA board) throws SQLException;
	
	/**
	 * 게시물 등록
	 * @param board
	 * @return
	 */
	public int insert(BoardQnA board) throws SQLException;
	
	/**
	 * 게시물 삭제
	 * @param qnaNo
	 * @return
	 */
	public int delete(int qnaNo) throws SQLException;
	
	/**
	 * 조회수 증가
	 * @param qnaNo
	 * @return
	 */
	public int increamentView(int qnaNo) throws SQLException;
}
