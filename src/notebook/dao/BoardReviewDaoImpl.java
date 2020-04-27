package notebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import notebook.domain.BoardReview;
import notebook.exception.CannotModifyException;
import notebook.exception.NotFoundException;
import notebook.util.DbUtil;

public class BoardReviewDaoImpl implements BoardReviewDao {
	@Override
	public List<BoardReview> selectBySerialNum(String serialNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from board_review where serialnum=?";
		List<BoardReview> list = new ArrayList<BoardReview>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, serialNum);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int reviewNo = rs.getInt("review_no");
				String userId = rs.getString("user_id");
				String imgName = rs.getString("img_name");
				String createDate = rs.getString("create_date");
				String content = rs.getString("content");
				int grade = rs.getInt("grade");
				
				list.add(new BoardReview(reviewNo, userId, imgName, createDate, content, serialNum, grade));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int update(BoardReview review) throws SQLException, CannotModifyException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			
			
			//후기 정보 수정
			String sql = "UPDATE board_review SET create_date=sysdate, content=?, grade=? WHERE review_no = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, review.getContent());
			ps.setInt(2, review.getGrade());
			ps.setInt(3, review.getReviewNo());
			if(ps.executeUpdate() ==0) {
				con.rollback();
				throw new CannotModifyException("후기를 수정할 수 없습니다.");
			}
			ps.close();
			
			//상품의 후기정보들 가져오기
			sql = "SELECT gra"
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	public int delete(int reviewNo) throws SQLException, NotFoundException, CannotModifyException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			con =DbUtil.getConnection();
			con.setAutoCommit(false);
		
			//상품의 후기들의 갯수와 평점 총합을 구한다.
			String sql = "select serialnum, grade from board_review where review_no = ?";
			String serialNum = null ;
			int mygrade = 0;
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				serialNum = rs.getString("serialnum");
				mygrade = rs.getInt("grade");
			}
			ps.close();
			rs.close();
			
			//serialnum이 동일한리뷰의 개수를 찾아내서 reviewcnt에 담는다.
			//grade의 모든 합계를 sum에 담는다.
			sql = "select grade from board_review where serialnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, serialNum);
			rs = ps.executeQuery();
			
			int sum = 0;
			int reviewcnt = 0;
			while(rs.next()) {
				sum += rs.getInt("grade");
				reviewcnt++;
			}
			ps.close();
			rs.close();
			
			//후기 삭제
			sql = "DELETE board_review WHERE review_no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewNo);
			result = ps.executeUpdate();
			if(result == 0) {
				con.rollback();
				throw new NotFoundException("삭제 불가능 ");
			}
			ps.close();
			
			//update product grade
			if(reviewcnt > 1) {
				sql = "UPDATE product SET grade = ? WHERE serialnum = ?";
				ps = con.prepareStatement(sql);
				ps.setDouble(1, (sum - mygrade) / (reviewcnt - 1));
				ps.setString(2, serialNum);
				result = ps.executeUpdate();
				if(result == 0) {
					con.rollback();
					throw new CannotModifyException("cannot modify grade");
				}
			}
			con.commit();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
	}
	
	@Override
	public int insert(BoardReview review) throws SQLException, NotFoundException, CannotModifyException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con =DbUtil.getConnection();
			con.setAutoCommit(false);
			
			//먼저 serialnum이 동일한리뷰의 개수를 찾아내서 reviewcnt에 담는다.
			//grade의 모든 합계를 sum에 담는다.
			String sql = "select grade from board_review where serialnum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, review.getSerialNum());
			rs = ps.executeQuery();
			
			int sum = 0;
			int reviewcnt = 0;
				while(rs.next()) {
					sum += rs.getInt("grade");;
					reviewcnt++;
				}
				ps.close();
				rs.close();
			
			//insertReview
			sql = "INSERT INTO board_review(review_no, user_id, serialnum, img_name, content, grade) VALUES(seq_board_review.NEXTVAL, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, review.getUserId());
			ps.setString(2, review.getSerialNum());
			ps.setString(3, review.getImgName());
			ps.setString(4, review.getContent());
			ps.setInt(5, review.getGrade());
			result = ps.executeUpdate();
			if(result == 0) {
				con.rollback();
				throw new SQLException("insert fail");
			}
			ps.close();
			
			//update product grade
			sql = "UPDATE product SET grade = ? WHERE serialnum = ?";
			ps = con.prepareStatement(sql);
			double refreshgrade = (review.getGrade() + sum)/(reviewcnt+1);
			ps.setDouble(1, refreshgrade);
			ps.setString(2, review.getSerialNum());
			result = ps.executeUpdate();
			if(result == 0) {
				con.rollback();
				throw new CannotModifyException("cannot modify grade");
			}
			
			con.commit();
		}finally {
			DbUtil.dbClose(con, ps, rs);
			
		}
		
		return result;
	}

}
