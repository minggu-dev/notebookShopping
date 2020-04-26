package notebook.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Users;
import notebook.exception.NotEnoughParameterException;
import notebook.service.UserService;

/**
 * 유저 핸드폰으로 아이디 찾기
 * @author 김민호
 *
 */
public class UserFindController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String phone = request.getParameter("phone");
		if(phone == null||phone.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		Users user = UserService.selectByPhone(phone);
		String userId = user.getUserId();
		request.setAttribute("userId", userId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("로그인창으로");
		return mv;
	}
}
