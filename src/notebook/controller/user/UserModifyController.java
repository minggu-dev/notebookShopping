package notebook.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Users;
import notebook.exception.NotEnoughParameterException;
import notebook.service.UserService;

/**
 * 회원정보 수정
 * @author kosta
 *
 */
public class UserModifyController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		String userId = request.getParameter("userId");
		if(pwd == null || pwd.equals("") || phone == null || phone.equals("") || addr == null || addr.equals("") ||userId == null || userId.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		Users user = new Users();
		user.setUserId(userId);
		user.setAddr(addr);
		user.setPhone(phone);
		user.setPwd(pwd);
		
		UserService.updateStatus(user);
		ModelAndView mv = new ModelAndView(true, "마이페이지");
		return mv;
	}

}
