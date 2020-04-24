package notebook.domain;

import java.util.List;

public class OrderInfo {
	private int orderNo;
	private String userId;
	private String purchaseDate;
	private int deliveryState;
	private int refundState;
	private int totalPrice;
	private String addrDelivery;
	private List<OrderList> orderList;
	
	public OrderInfo() {
		super();
	}
	
	public OrderInfo(int orderNo, String userId, String purchaseDate, int deliveryState, int refundState,
			int totalPrice, String addrDelivery, List<OrderList> orderList) {
		super();
		this.orderNo = orderNo;
		this.userId = userId;
		this.purchaseDate = purchaseDate;
		this.deliveryState = deliveryState;
		this.refundState = refundState;
		this.totalPrice = totalPrice;
		this.addrDelivery = addrDelivery;
		this.orderList = orderList;
	}

	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getDeliveryState() {
		return deliveryState;
	}
	public void setDeliveryState(int deliveryState) {
		this.deliveryState = deliveryState;
	}
	public int getRefundState() {
		return refundState;
	}
	public void setRefundState(int refundState) {
		this.refundState = refundState;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getAddrDelivery() {
		return addrDelivery;
	}
	public void setAddrDelivery(String addrDelivery) {
		this.addrDelivery = addrDelivery;
	}
	public List<OrderList> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<OrderList> orderList) {
		this.orderList = orderList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
