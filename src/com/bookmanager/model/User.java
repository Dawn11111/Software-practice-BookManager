package com.bookmanager.model;

/**
 * 用户实体
 * @author WenRan
 *
 */
public class User {
	private int id;//编号
	private String userName;//用户名
	private String password;//密码
	
	//用来辅助LogOnFrm，连接到数据库
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
