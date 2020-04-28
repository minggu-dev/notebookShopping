package notebook.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;

public class UserLogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		ModelAndView mv = new ModelAndView(true, "note");
		return mv;
	}

}
