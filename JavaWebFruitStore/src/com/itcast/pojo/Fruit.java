package com.itcast.pojo;

public class Fruit {
	private int id;
	private String name;
	private double price;
	private String unit;

	public Fruit() {
	};

	public Fruit(String name, double price, String unit) {
		this.name = name;
		this.price = price;
		this.unit = unit;
	}

	public Fruit(int id, String name, double price, String unit) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.unit = unit;
	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
