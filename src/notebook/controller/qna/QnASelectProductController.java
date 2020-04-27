package notebook.controller.qna;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.BoardQnA;
import notebook.exception.NotFoundException;
import notebook.service.QnAService;

public class QnASelectProductController implements Controller {
	
	/**
	 * 상품상세보기에서 qna게시판 눌렀을 때
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String serialNum = request.getParameter("serialNum");
		
		if(serialNum == null || serialNum.equals("")) {
			throw new NotFoundException("입력값이 충분하지 않습니다.");
		}
		
		List<BoardQnA> list = QnAService.selectBySerialNum(serialNum);
		request.setAttribute("list", list);
		
		ModelAndView mv = new ModelAndView(false, "");
		return mv;
	}

}
