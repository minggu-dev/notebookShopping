package notebook.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.exception.NotEnoughParameterException;
import notebook.service.UserService;

/**
 * 회원탈퇴 기능 / 비활성화 기능
 * @author kosta
 *
 */
public class UserWithdrawalController implements Controller {

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String adminId = (String)request.getSession().getAttribute("id");
      String userId=request.getParameter("id");
      String password = request.getParameter("password");

      if(userId == null || userId.equals("") || password == null || password.equals("")) {
          throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
      }
      UserService.withdrawMember(userId, password);
      ModelAndView mv;
      
      if((adminId).equals("admin")) {
          mv = new ModelAndView(true, "note?command=userAll");
      }else {
          mv = new ModelAndView(true, "note");
          request.getSession().removeAttribute("id");
      }
      
      return mv;
   }
}