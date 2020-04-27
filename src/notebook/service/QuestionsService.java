
package notebook.service;

import java.sql.SQLException;
import java.util.List;

import notebook.dao.QuestionsDao;
import notebook.dao.QuestionsDaoImpl;
import notebook.domain.Questions;


public class QuestionsService {
	
	public static QuestionsDao queDAO = new QuestionsDaoImpl();

	public static List<Questions> selectAll() throws SQLException{
		List<Questions> list = queDAO.selectAll();
		
		return list;
	}
	
	
}
