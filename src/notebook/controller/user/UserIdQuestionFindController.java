package notebook.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Users;
import notebook.exception.NotEnoughParameterException;
import notebook.exception.NotFoundException;
import notebook.service.UserService;

/**
 * 유저 핸드폰으로 아이디 찾기 -> 질문 가져오기
 * @author 김민호
 *
 */
public class UserIdQuestionFindController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		ModelAndView mv = new ModelAndView();
		try {
			if(phone == null||phone.equals("") || name == null || name.equals("")) {
				throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
			}
			Users user = UserService.selectByPhoneName(phone, name);
			if(user.getState() == 2) {
				throw new NotFoundException("정보를 확인할 수 없습니다.");
			}else {
				String question = user.getQuestion().getQuestion();
				//핸드폰 번호랑 답변으로 찾아오자
				request.setAttribute("question", question);
				request.setAttribute("phone", phone);
				mv.setViewName("findById2.jsp");
			}
		}catch (Exception e) {
			mv.setViewName("findFail.jsp");
			mv.setRedirect(true);
		}
		
		return mv;
	}
}
