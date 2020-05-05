package notebook.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Users;
import notebook.exception.DuplicateException;
import notebook.exception.NotEnoughParameterException;
import notebook.service.UserService;

/**
 * 아이디 중복 체크(ajax통신)
 * @author 김민호
 *
 */
public class UserDuplicateController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		JSONObject jsonObj = new JSONObject();
		request.setAttribute("jsonObj", jsonObj);
		
		if(userId == null || userId.equals("")) {
			jsonObj.put("status",2);	//입력x
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		
		try {
			UserService.selectById(userId);
			jsonObj.put("status", 1);	//중복
		}catch (Exception e) {
			jsonObj.put("status", 0);	//중복아님
		}
		
		return null;
	}
}
