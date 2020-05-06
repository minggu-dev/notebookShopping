package notebook.controller.review;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.exception.NotEnoughParameterException;
//github.com/KimMinhoJA/notebookShopping
import notebook.service.ReviewService;

public class ReviewDeleteController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = (String)request.getSession().getAttribute("id");
		String reviewNo = request.getParameter("reviewNo");
		String imgName = request.getParameter("imgName");
		String serialNum = request.getParameter("serialNum");
		JSONObject jsonObj = new JSONObject();
		request.setAttribute("jsonObj", jsonObj);
		
		if(userId == null || userId.equals("") || reviewNo == null || reviewNo.equals("") || serialNum == null || serialNum.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		
		ReviewService.delete(Integer.parseInt(reviewNo), userId);
		
		if(imgName != null && !imgName.equals("")) {
			String path = request.getServletContext().getRealPath("/save");
			File file = new File(path + "/" + imgName);
			file.delete();
		}
		
		ModelAndView mv = new ModelAndView(true, "note?command=proDetail&serialNum="+serialNum);
		
		return mv;
	}
}