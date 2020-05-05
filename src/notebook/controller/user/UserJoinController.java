package notebook.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Questions;
import notebook.domain.Users;
import notebook.exception.NotEnoughParameterException;
import notebook.service.UserService;

/**
 * 회원가입
 * @author kosta
 *
 */
public class UserJoinController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String phone = request.getParameter("phone");
		String answer = request.getParameter("answer");
		String queNo = request.getParameter("queNo");
		
		if(userId == null || userId.equals("") || pwd == null || pwd.equals("") || name == null || name.equals("") || addr == null 
				|| addr.equals("") || phone == null || phone.equals("") || answer == null || answer.equals("") || queNo == null
				|| queNo.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		ModelAndView mv = new ModelAndView(true, "login.jsp");
		Questions question = new Questions();
		question.setQueNo(Integer.parseInt(queNo));
		Users user = new Users(userId, pwd, name, addr, phone, answer, question);
		
		UserService.insert(user);
		
		return mv;
	}

}
