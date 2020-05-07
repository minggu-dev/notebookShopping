package notebook.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Users;
import notebook.exception.NotEnoughParameterException;
import notebook.service.UserService;

/**
 * 폰번호와 답변으로 비밀번호 가져오기
 * @author kosta
 *
 */
public class UserPwdFindController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String phone = request.getParameter("phone");
		String answer = request.getParameter("answer");
		ModelAndView mv = new ModelAndView();
		
		try {
			if(phone == null || phone.equals("") || answer == null || answer.equals("")) {
				throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
			}
			Users user = UserService.selectByPhoneAns(phone, answer);
			String pwd = user.getPwd();
			request.setAttribute("pwd", pwd);
			mv.setViewName("findByPasswordSuccess.jsp");
		}catch (Exception e) {
			mv.setViewName("findFail.jsp");
			mv.setRedirect(true);
		}
		return mv;
	}

}
