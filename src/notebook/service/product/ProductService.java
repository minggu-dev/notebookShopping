package notebook.service.product;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import notebook.dao.ProductDao;
import notebook.dao.ProductDaoImpl;
import notebook.domain.Product;
import notebook.exception.NotFoundException;

public class ProductService {
	private static ProductDao proDao = new ProductDaoImpl();
	
	public static Map<String, List<Product>> homePage() throws SQLException, NotFoundException{
		Map<String, List<Product>> map = new HashMap<String, List<Product>>();
		
		List<Product> bestList = proDao.selectBestProducts();
		if(bestList.size() == 0) {
			throw new NotFoundException("상품을 찾을 수 없습니다.");
		}
		map.put("best", bestList);
		
		List<Product> newList = proDao.selectNewProducts();
		if(newList.size() == 0) {
			throw new NotFoundException("상품을 찾을 수 없습니다.");
		}
		map.put("new", newList);
		
		List<Product> ranList = proDao.selectRendomProducts();
		if(ranList.size() == 0) {
			throw new NotFoundException("상품을 찾을 수 없습니다.");
		}
		map.put("random", ranList);
		
		return map;
	}
	
	public static void insert(Product product) throws SQLException{
		proDao.insert(product);
	}
}
