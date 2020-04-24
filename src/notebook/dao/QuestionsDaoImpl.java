package notebook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import notebook.domain.Questions;
import notebook.util.DbUtil;

public class QuestionsDaoImpl implements QuestionsDao {

	@Override
	public List<Questions> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM questions";
		List<Questions> list = new ArrayList<Questions>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Questions(rs.getInt(1), rs.getString(2)));
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

}
