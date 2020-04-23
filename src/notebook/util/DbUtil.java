package notebook.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * DB연동에 관련된
 * 로드, 연결, 닫기 기능 담당 클래스
 * @author kosta
 *
 */
public class DbUtil {
	//connection을 미리 생성하려는 객체
	private static DataSource ds;
	/**
	 * 로드
	 */
	static {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:/comp/env/jdbc/myoracle");
		}catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 연결
	 */
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	/**
	 * 닫기 (DML전용 : insert, update, delete)
	 */
	public static void dbClose(Connection con, Statement stmt) {
		try {
			if(stmt != null)stmt.close();
			if(con != null)con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 닫기 (select전용)
	 */
	public static void dbClose(Connection con, Statement stmt, ResultSet rs) {
		try {
			if(rs != null)rs.close();
			dbClose(con, stmt);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
