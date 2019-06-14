package com.itcast.pojo;

public class Customer {
	private int id;
	private String name;
	private String password;
	private String sex;
	private String address;
	private String telephone;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String toString() {
		return "用户ID" + id + "用户名" + name + "密码" + password + "性别" + sex + "地址" + address + "电话" + telephone;
	}

	public Customer() {
	};

	public Customer(int id, String name, String password, String sex, String address, String telephone) {

		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.address = address;
		this.telephone = telephone;
	}

	public Customer(String name, String password, String sex, String address, String telephone) {

		this.name = name;
		this.password = password;
		this.sex = sex;
		this.address = address;
		this.telephone = telephone;
	}
}
