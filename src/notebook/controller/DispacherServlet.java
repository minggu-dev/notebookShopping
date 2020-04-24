package notebook.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.product.ProHomeController;

/**
 * Servlet implementation class DispacherServlet
 */
@WebServlet("/note")
public class DispacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, Controller> map;
	@Override
	public void init() throws ServletException {
		ServletContext application = super.getServletContext();
		map = (Map<String, Controller>)application.getAttribute("map");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String key = request.getParameter("command");
		Controller controller = null;
		if(key == null || key.equals("")) {
			controller = new ProHomeController();
		}else {
			controller = map.get(key);
		}
		
		try {
			ModelAndView mv = controller.handleRequest(request, response);
			if(mv.isRedirect()) {
				response.sendRedirect(mv.getViewName());
			}else {
				request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("에러페이지").forward(request, response);
		}
	}

}
