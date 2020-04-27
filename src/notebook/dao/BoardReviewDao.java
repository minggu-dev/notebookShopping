package notebook.dao;

import java.sql.SQLException;
import java.util.List;

import notebook.domain.BoardReview;
import notebook.exception.CannotModifyException;
import notebook.exception.NotFoundException;

public interface BoardReviewDao {
	/**
	 * 상품별 후기 보기
	 * @param serialNum
	 * @return
	 */
	public List<BoardReview> selectBySerialNum(String serialNum) throws SQLException;
	
	/**
	 * 후기 수정
	 * @param review
	 * @return
	 */
	public int update(BoardReview review) throws SQLException;
	
	/**
	 * 후기 삭제
	 * @param reviewNo
	 * @return
	 */
	public int delete(int reviewNo) throws SQLException, NotFoundException, CannotModifyException;
	
	/**
	 * 후기 등록
	 * @param review
	 * @return
	 */
	public int insert(BoardReview review) throws SQLException, NotFoundException, CannotModifyException;
}
