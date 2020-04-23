package notebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import notebook.domain.BoardAnswer;
import notebook.util.DbUtil;

public class BoardAnswerDaoImpl implements BoardAnswerDao {

	@Override
	public List<BoardAnswer> selectByQnaNo(int qnaNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT ans_no, qna_no, content, create_date FROM board_answer where qna_no=?";
		List<BoardAnswer> list = new ArrayList<BoardAnswer>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qnaNo);
			rs = ps.executeQuery();
			boolean isFirst = true;
			
			while(rs.next()) {
				if(isFirst) {
					list.add(new BoardAnswer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
				}
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

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
	public int delete(int ansNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE board_answer WHERE ans_no=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, ansNo);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int insert(BoardAnswer answer) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO board_answer VALUES(seq_board_ans.NEXTVAL, ?, ?, SYSDATE)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, answer.getQnaNo());
			ps.setString(2, answer.getContent());
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

}
