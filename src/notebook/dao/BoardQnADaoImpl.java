package notebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
				String userId = rs.getString("user_id");//사용자id
				String subject = rs.getString("subject");//제목
				String content = rs.getString("content");//내용
				String createDate = rs.getString("create_date");//등록일
				String password = rs.getString("password");
				int viewCnt = rs.getInt("view_cnt");
				int answerState = rs.getInt("answer_state");
				String serialNum = rs.getString("serialNum");
				String modelName = rs.getString("model_name");
				String company = rs.getString("company");
				Product product = new Product();
				product.setSerialNum(serialNum);
				product.setModelName(modelName);
				product.setCompany(company);
				qna = new BoardQnA(qnaNo, userId, subject, content, createDate, password, viewCnt, answerState, product);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return qna;
	}

	@Override
	public List<BoardQnA> selectBySerialNum(String serialNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board_qna where serialNum = ?";
		List<BoardQnA> list = new ArrayList<BoardQnA>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, serialNum);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int qnaNo = rs.getInt("qna_no");
				String userId = rs.getString("user_id");
				String subject = rs.getString("subject");
				String createDate = rs.getString("create_date");
				String password = rs.getString("password");
				int viewCnt = rs.getInt("view_cnt");
				int answerState = rs.getInt("answer_state");
				list.add(new BoardQnA(qnaNo, userId, subject, null, createDate, password, viewCnt, answerState, null));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<BoardQnA> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board_qna";
		List<BoardQnA> list = new ArrayList<BoardQnA>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int qnaNo = rs.getInt("qna_no");
				String userId = rs.getString("user_id");
				String subject = rs.getString("subject");
				String createDate = rs.getString("create_date");
				String password = rs.getString("password");
				int viewCnt = rs.getInt("view_cnt");
				int answerState = rs.getInt("answer_state");
				list.add(new BoardQnA(qnaNo, userId, subject, null, createDate, password, viewCnt, answerState, null));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int update(BoardQnA board) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE board_qna SET subject = ?, content = ?, create_date = sysdate, password = ?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int insert(BoardQnA board) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO board_qna(qna_no, user_id, serialnum, subject, content, password) VALUES(seq_board_qna, ?, ?, ?, ?, ?)";;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getUserId());
			ps.setString(2, board.getProduct().getSerialNum());
			ps.setString(3, board.getSubject());
			ps.setString(4, board.getContent());
			ps.setString(5, board.getPassword());
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int delete(int qnaNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE board_qna WHERE qna_no = ?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qnaNo);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int increamentView(int qnaNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE board_qna SET review_cnt = review_cnt + 1 WEHRE qna_no = ?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qnaNo);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int updateState(int qnaNo, int cnt) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE board_qna SET answer_state = ? WEHRE qna_no = ?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			int answerState = cnt == 0 ? 0 : 1;
			ps.setInt(1, answerState);
			ps.setInt(2, qnaNo);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

}
