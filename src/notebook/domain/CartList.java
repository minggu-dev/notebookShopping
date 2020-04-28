package notebook.domain;

public class CartList {
	private String userId;
	private Product product;//	상품 정보만 가져오기
	private int quantity;
	public CartList() {
		super();
	}
	public CartList(String userId, Product product, int quantity) {
		super();
		this.userId = userId;
		this.product = product;
		this.quantity = quantity;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
