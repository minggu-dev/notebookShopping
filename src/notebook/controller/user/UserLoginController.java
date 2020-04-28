package notebook.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Users;
import notebook.exception.NotEnoughParameterException;
import notebook.exception.NotFoundException;
import notebook.service.UserService;

/**
 * 회원 로그인
 * @author kosta
 *
 */
public class UserLoginController implements Controller {
	
	/**
	 * 로그인
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//아이디랑 비밀번호를 받아온다.
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		if(userId == null || userId.equals("") || pwd == null || pwd.equals("")) {
			throw new NotEnoughParameterException("입력값이 부족합니다.");
		}
		
		Users user = UserService.selectById(userId);
		if(user.getPwd().equals(pwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("id", userId);//세션에 저장
		}else {
			throw new NotFoundException("회원정보가 일치하지 않습니다. 다시 확인해주세요.");
		}

		ModelAndView mv = new ModelAndView(true, "메인페이지로");
		
		return mv;
	}

}
