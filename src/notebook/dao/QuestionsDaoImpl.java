package notebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import notebook.domain.Questions;
import notebook.util.DbUtil;

public class QuestionsDaoImpl implements QuestionsDao {

	@Override
	public List<Questions> selectAll() throws SQLException {
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

}
