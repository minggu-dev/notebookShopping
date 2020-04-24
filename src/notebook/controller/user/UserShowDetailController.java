package notebook.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Users;
import notebook.exception.NotEnoughParameterException;
import notebook.service.user.UserService;

/**
 * 유저 상세보기(마이페이지)
 * @author kosta
 *
 */
public class UserShowDetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		
		if(userId == null || userId.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		Users user = UserService.selecById(userId);
		request.setAttribute("user", user);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("마이페이지");
		return mv;
	}
}
