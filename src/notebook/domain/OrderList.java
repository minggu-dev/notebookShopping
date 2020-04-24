package notebook.domain;

public class OrderList {
	private Product product;//	상품 정보만 가져오기
	private int orderNo;
	private int quantity;
	public OrderList() {
		super();
	}
	public OrderList(Product product, int orderNo, int quantity) {
		super();
		this.product = product;
		this.orderNo = orderNo;
		this.quantity = quantity;
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
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
}
