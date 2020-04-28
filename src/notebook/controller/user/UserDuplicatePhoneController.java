package notebook.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.exception.DuplicateException;
import notebook.exception.NotEnoughParameterException;
import notebook.service.UserService;

/**
 * 전화번호 중복체크(ajax통신)
 * @author 김민호
 *
 */
public class UserDuplicatePhoneController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String phone = request.getParameter("phone");
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("status", 2);
		request.setAttribute("jsonObj", jsonObj);
		
		if(phone == null || phone.equals("")) {
			request.setAttribute("jsonObj", jsonObj);
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다");
		}
		try {
			if(UserService.selectByPhone(phone) != null) {
				throw new DuplicateException("이미 등록된 전화번호 입니다.");
			}
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		jsonObj.replace("status", 1);
		return null;
	}
}
