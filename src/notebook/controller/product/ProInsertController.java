package notebook.controller.product;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notebook.controller.Controller;
import notebook.controller.ModelAndView;
import notebook.domain.Product;
import notebook.exception.NotEnoughParameterException;
import notebook.service.ProductService;

/**
 * 관리자 상품 등록
 * @author kosta
 *
 */
public class ProInsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String saveDir = request.getServletContext().getRealPath("/save");
		int maxSize = 1024 * 1024 * 100;//100MB
		String encoding = "UTF-8";
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		String modelName = m.getParameter("modelName");
		String company = m.getParameter("company");
		String price = m.getParameter("price");
		String ram = m.getParameter("ram");
		String cpu = m.getParameter("cpu");
		String noteSize = m.getParameter("noteSize");
		String noteWeight = m.getParameter("noteWeight");
		String launchDate = m.getParameter("launchDate");
		
		if(modelName == null || modelName.equals("") || company == null || company.equals("") || price == null || price.equals("")
				|| ram == null || ram.equals("") || cpu == null || cpu.equals("") || noteSize == null || noteSize.equals("") || noteWeight == null || noteWeight.equals("")
				|| launchDate == null || launchDate.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		Product product = new Product(modelName, company, Integer.parseInt(price), Integer.parseInt(ram), cpu, Integer.parseInt(noteSize), Double.parseDouble(noteWeight), launchDate);
		
		Enumeration files = m.getFileNames();
		String file = (String)files.nextElement();
		String imgName = m.getFilesystemName(file);

		String file2 = (String) files.nextElement();
		String descriptionImgName = m.getFilesystemName(file2);
		
		if(imgName == null || imgName.equals("") || descriptionImgName == null || descriptionImgName.equals("")) {
			throw new NotEnoughParameterException("입력값이 충분하지 않습니다.");
		}
		product.setImgName(imgName);
		product.setDescriptionImgName(descriptionImgName);
		
		
		ProductService.insert(product);
		ModelAndView mv = new ModelAndView(false, "관리자 페이지");
		
		return mv;
	}
}
