package notebook.service;

import java.sql.SQLException;
import java.util.List;

import notebook.dao.BoardReviewDao;
import notebook.dao.BoardReviewDaoImpl;
import notebook.domain.BoardReview;
import notebook.exception.CannotModifyException;
import notebook.exception.NotFoundException;

public class ReviewService {
	private static BoardReviewDao  reviewDao = new BoardReviewDaoImpl();
	
	public static List<BoardReview> searchByUserId(String userId) throws SQLException, NotFoundException{
		List<BoardReview> re = reviewDao.selectByUserId(userId);
		if(re == null) {
			throw new NotFoundException("해당 유저는 등록한 리뷰가 없습니다.");
		}
		return re;
	}
	public static void delete(int reviewNo) throws SQLException, NotFoundException{
		int result = reviewDao.delete(reviewNo);
		if(result == 0) {
			throw new NotFoundException("글번호에 해당하는 리뷰가 없습니다.");
		}
		
	}

	public static void insert(BoardReview review) throws SQLException, NotFoundException, CannotModifyException{
		int result = reviewDao.insertAndUpdateProductGrade(review);
		if(result ==0) {
			throw new SQLException("등록되지 않았습니다.");
		}
	}
	
	public static List<BoardReview> select(String serialNum) throws SQLException, NotFoundException{
		List<BoardReview> re = reviewDao.selectBySerialNum(serialNum);
		if(re == null) {
			throw new NotFoundException("작성된 후기가 존재하지 않습니다.");
		}
		return re;
		
	}
	
	public static void update(BoardReview review) throws SQLException, NotFoundException, CannotModifyException{
		int result =reviewDao.insertAndUpdateProductGrade(review);
		if(result == 0) {
			throw new SQLException("수정되지 않았습니다.");
		}
	}
}


