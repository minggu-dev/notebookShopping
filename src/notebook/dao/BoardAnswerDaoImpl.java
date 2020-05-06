package notebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import notebook.domain.BoardAnswer;
import notebook.exception.CannotModifyException;
import notebook.exception.NotFoundException;
import notebook.util.DbUtil;

public class BoardAnswerDaoImpl implements BoardAnswerDao {
	@Override
	public int update(BoardAnswer answer) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE board_answer SET content=?, create_date=sysdate WHERE ans_no=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, answer.getContent());
			ps.setInt(2, answer.getAnsNo());
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int delete(int ansNo, int qnaNo) throws SQLException, NotFoundException, CannotModifyException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			
			//답변 지우기
			String sql = "DELETE board_answer WHERE ans_no=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ansNo);
			if(ps.executeUpdate() == 0) {
				con.rollback();
				throw new NotFoundException("답변을 찾을 수 없습니다.");
			}
			ps.close();
			
			//질문 답변 갯수 가져오기
			sql = "SELECT * FROM board_answer WHERE qna_no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, qnaNo);
			rs = ps.executeQuery();
			
			int cnt = 0;
			while(rs.next()) {
				cnt++;
			}
			if(cnt == 0) {
				con.rollback();
				throw new NotFoundException("답변을 찾을 수 없습니다.");
			}
			ps.close();
			
			//답변이 없어질경우 답변상태 0으로 바꾸기
			if(cnt == 1) {
				 sql = "UPDATE board_answer SET answer_state = 0 WHERE qna_no = ?";
				 ps = con.prepareStatement(sql);
				 ps.setInt(1, qnaNo);
				 if(ps.executeUpdate() == 0) {
					 con.rollback();
					 throw new CannotModifyException("답변상태를 변경할 수 없습니다.");
				 }
			}
			
			con.commit();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return result;
	}

	@Override
	public int insert(BoardAnswer answer) throws SQLException, CannotModifyException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			
			//답변 게시물 추가하기
			String sql = "INSERT INTO board_answer VALUES(seq_board_ans.NEXTVAL, ?, ?, SYSDATE)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, answer.getQnaNo());
			ps.setString(2, answer.getContent());
			if(ps.executeUpdate() == 0) {
				con.rollback();
				throw new SQLException("답변을 추가할 수 없습니다");
			}
			ps.close();
			
			//답변상태 바꾸기
			 sql = "UPDATE board_qna SET answer_state = 1 WHERE qna_no = ?";
			 ps = con.prepareStatement(sql);
			 ps.setInt(1, answer.getQnaNo());
			 if(ps.executeUpdate() == 0) {
				 con.rollback();
				 throw new CannotModifyException("답변상태를 변경할 수 없습니다.");
			 }
			 con.commit();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	@Override
	public List<BoardAnswer> selectByQnaNo(int qnaNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board_answer WHERE qna_no = ?";
		List<BoardAnswer> list = new ArrayList<BoardAnswer>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qnaNo);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new BoardAnswer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}
	
	@Override
	public BoardAnswer selectByNo(int ansNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board_answer WHERE ans_no = ?";
		BoardAnswer answer = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, ansNo);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				answer = new BoardAnswer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return answer;
	}
}
