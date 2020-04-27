package notebook.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import notebook.domain.Product;

public interface ProductDao {
	/**
	 * 상품 상세보기
	 * @param serialNum
	 * @return
	 */
	public Map<String, Object> selectByNum(String serialNum) throws SQLException;

	/**
	 * 가격으로 검색
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	public List<Product> selectByPriceRange(int minPrice, int maxPrice) throws SQLException;
	
	/**
	 * 신상품 3개 검색
	 * @return
	 */
	public List<Product> selectNewProducts() throws SQLException;
	
	/**
	 * 평점순으로 3개 검색
	 * @return
	 */
	public List<Product> selectBestProducts() throws SQLException;
	
	/**
	 * 임의의 상품 3개 검색
	 * @return
	 */
	public List<Product> selectRendomProducts() throws SQLException;
	
	/**
	 * 전체상품 정렬해서 검색 (target이 NULL이면 번호가 초기값)
	 * @param target
	 * @return
	 */
	public List<Product> selectSortProduct(String target) throws SQLException;

	/**
	 * 회사, 모델명으로 상품 검색
	 * @param targer
	 * @param search
	 * @return
	 * @throws SQLException
	 */
	public List<Product> searchProduct(String target, String search) throws SQLException;
	/**
	 * 상품 정보 수정, 구매시 재고량 감소, 환불시 재고량 증가, 평점 매기기
	 * 정보는 다
	 * @param product
	 * @return
	 */
	public int updateProduct(Product product) throws SQLException;
	
	/**
	 * 상품 추가
	 * @param product
	 * @return
	 */
	public int insert(Product product) throws SQLException;
	
	/**
	 * 상품 평점 매기기
	 * @param serialNum
	 * @param grade
	 * @return
	 * @throws SQLException
	 */
	public int grantGrade(String serialNum, double grade) throws SQLException;
	
	/**
	 * 상품 재고 추가, 감소
	 * @param serialNum
	 * @param stock
	 * @return
	 * @throws SQLException
	 */
	public int updateStock(String serialNum, int stock) throws SQLException;
	
	/**
	 * 회사들 기준으로 상품들 검색
	 * @param company
	 * @return
	 * @throws SQLException
	 */
	public List<Product> selectByCompany(String company) throws SQLException;
}
