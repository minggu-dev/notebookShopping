package notebook.dao;

import java.sql.SQLException;
import java.util.List;

import notebook.domain.Questions;

public interface QuestionsDao {
	/**
	 * 회원가입시 회원인증 질문
	 * @return
	 */
	public List<Questions> selectAll() throws SQLException;
}
