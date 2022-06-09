package com.spring.mall.user.vo;

public class UserVO {
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_nickname;
	private String user_email;
	private int user_grade;
	private int user_point;
	private String user_addr;
	private String user_addr_d;
	private String user_zipcode;
	private int user_state;
	private String user_phone;
	
	//------------------
	private String searchCondition;
	private String searchKeyword;
	
	
	
	public UserVO(String user_id) {
		System.out.println("user_id" + user_id);
	}
	
	public UserVO() {
		System.out.println(">> UserVO() 생성 ");
	}

	public UserVO(String user_id,String user_pw) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	
	public UserVO(String user_id, String user_pw, String user_name, String user_nickname, String user_email,
			int user_grade, int user_point, String user_addr, String user_addr_d, String user_zipcode, int user_state,
			String user_phone) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_nickname = user_nickname;
		this.user_email = user_email;
		this.user_grade = user_grade;
		this.user_point = user_point;
		this.user_addr = user_addr;
		this.user_addr_d = user_addr_d;
		this.user_zipcode = user_zipcode;
		this.user_state = user_state;
		this.user_phone = user_phone;
	}

	
	
	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public int getUser_grade() {
		return user_grade;
	}

	public void setUser_grade(int user_grade) {
		this.user_grade = user_grade;
	}

	public int getUser_point() {
		return user_point;
	}

	public void setUser_point(int user_point) {
		this.user_point = user_point;
	}

	public String getUser_addr() {
		return user_addr;
	}

	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}

	public String getUser_addr_d() {
		return user_addr_d;
	}

	public void setUser_addr_d(String user_addr_d) {
		this.user_addr_d = user_addr_d;
	}

	public String getUser_zipcode() {
		return user_zipcode;
	}

	public void setUser_zipcode(String user_zipcode) {
		this.user_zipcode = user_zipcode;
	}

	public int getUser_state() {
		return user_state;
	}

	public void setUser_state(int user_state) {
		this.user_state = user_state;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + ", user_nickname="
				+ user_nickname + ", user_email=" + user_email + ", user_grade=" + user_grade + ", user_point="
				+ user_point + ", user_addr=" + user_addr + ", user_addr_d=" + user_addr_d + ", user_zipcode="
				+ user_zipcode + ", user_state=" + user_state + ", user_phone=" + user_phone + "]";
	}

}
