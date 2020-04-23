package notebook.domain;

public class CartList {
	private int cartNo;
	private Product product;//	상품 정보만 가져오기
	private int quantity;
	public CartList(int cartNo, Product product, int quantity) {
		super();
		this.cartNo = cartNo;
		this.product = product;
		this.quantity = quantity;
	}
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
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
