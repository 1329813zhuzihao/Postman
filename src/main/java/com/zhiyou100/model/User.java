package com.zhiyou100.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	private String salt; // 盐值
	private int id;
	private String name;
	private String password;
	/*
	 * pattern : 能解析的日期模板
	 * 因为页面layui发出的日期格式是yyyy-MM-dd的字符串
	 * 需要使用该注解 将这个类型的字符串解析为日期对象,并注入
	 * User的该属性中
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	@Override
	public String toString() {
		return "User [salt=" + salt + ", id=" + id + ", name=" + name + ", password=" + password + ", birthday="
				+ birthday + "]";
	}
	public User(String salt, int id, String name, String password, Date birthday) {
		super();
		this.salt = salt;
		this.id = id;
		this.name = name;
		this.password = password;
		this.birthday = birthday;
	}
	public User() {
		super();
	}
	public User(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	
}
