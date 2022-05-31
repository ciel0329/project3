package com.spring.mall.order.vo;

public class UserOrderDetailVO {
	private int order_detail_id;
	private int user_order_cnt;
	private String order_id;
	private int product_id;
	
	public UserOrderDetailVO() {
		System.out.println(">> UserOrderDetailVO() 객체 생성~~");
	}

	public UserOrderDetailVO(int order_detail_id, int user_order_cnt, String order_id, int product_id) {
		super();
		this.order_detail_id = order_detail_id;
		this.user_order_cnt = user_order_cnt;
		this.order_id = order_id;
		this.product_id = product_id;
	}

	public int getOrder_detail_id() {
		return order_detail_id;
	}

	public void setOrder_detail_id(int order_detail_id) {
		this.order_detail_id = order_detail_id;
	}

	public int getUser_order_cnt() {
		return user_order_cnt;
	}

	public void setUser_order_cnt(int user_order_cnt) {
		this.user_order_cnt = user_order_cnt;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	@Override
	public String toString() {
		return "UserOrderDetailVO [order_detail_id=" + order_detail_id + ", user_order_cnt=" + user_order_cnt
				+ ", order_id=" + order_id + ", product_id=" + product_id + "]";
	}
	
	
}
