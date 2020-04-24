package notebook.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.exception.NotEnoughParameterException;
import notebook.service.user.UserService;

/**
 * 회원탈퇴 기능 / 비활성화 기능
 * @author kosta
 *
 */
public class UserWithdrawalController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		ModelAndView mv = new ModelAndView(true, "note");
		
		if(userId == null || userId.equals("") || password == null || password.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		
		UserService.withdrawMember(userId, password);
		return mv;
	}
}
