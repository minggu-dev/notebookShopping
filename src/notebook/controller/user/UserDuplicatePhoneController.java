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
 * ��ȭ��ȣ �ߺ�üũ(ajax���)
 * @author ���ȣ
 *
 */
public class UserDuplicatePhoneController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String phone = request.getParameter("phone");
		JSONObject jsonObj = new JSONObject();
		if(phone == null || phone.equals("")) {
			jsonObj.put("status", 2);
			request.setAttribute("jsonObj", jsonObj);
			throw new NotEnoughParameterException("�Է°��� ������� �ʽ��ϴ�");
		}
		try {
			if(UserService.selectByPhone(phone) != null) {
				throw new DuplicateException("�̹� ��ϵ� ��ȭ��ȣ �Դϴ�.");
			}
			jsonObj.put("status", 1);
		}catch (Exception e) {
			jsonObj.put("status", 2);
			throw new Exception(e.getMessage());
		}finally {
			request.setAttribute("jsonObj", jsonObj);
		}
		return null;
	}
}