package notebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import notebook.domain.BoardQnA;
import notebook.domain.Product;
import notebook.util.DbUtil;

public class BoardQnADaoImpl implements BoardQnADao {

	@Override
	public BoardQnA selectByNo(int qnaNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardQnA qna = null;
		String sql = "SELECT * FROM board_qna_view WHERE qna_no=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qnaNo);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return null;
	}

	@Override
	public List<BoardQnA> selectBySerialNum(String serialNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return null;
	}

	@Override
	public List<BoardQnA> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return null;
	}

	@Override
	public int update(BoardQnA board) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return 0;
	}

	@Override
	public int insert(BoardQnA board) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return 0;
	}

	@Override
	public int delete(int qnaNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return 0;
	}

	@Override
	public int increamentView(int qnaNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return 0;
	}

}
