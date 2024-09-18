package edu.jsp.store.model;

public class product {
	private int id;
	private String name;
	private double price;
	private int quantity;
	private boolean availability;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "id=" + id + "\n, name=" + name + "\n, price=" + price + "\n, quantity=" + quantity + "\n, availability="
				+ availability + "\n";
	}

	public product(int id, String name, double price, int quantity, boolean availability) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.availability = availability;
	}

}
