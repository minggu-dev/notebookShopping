package notebook.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.exception.NotEnoughParameterException;
import notebook.service.user.UserService;

public class UserDisableController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		if(userId == null || userId.equals("") || password == null || password.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		UserService.withdrawMember(userId, password);
		return null;
	}

}
