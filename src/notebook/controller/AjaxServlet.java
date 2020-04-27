package notebook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import notebook.controller.product.ProHomeController;

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, Controller> map;
	@Override
	public void init() throws ServletException {
		ServletContext application = super.getServletContext();
		map = (Map<String, Controller>)application.getAttribute("map");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("command");
		Controller controller = null;
		if(key == null || key.equals("")) {
			controller = new ProHomeController();
		}else {
			controller = map.get(key);
		}
		PrintWriter out = response.getWriter();

		JSONObject jsonObj = new JSONObject();
	
		try {
			controller.handleRequest(request, response);
		} catch (Exception e) {
			
		}finally {
			jsonObj = (JSONObject)request.getAttribute("jsonObj");
			out.print(jsonObj);
		}
	}

}
