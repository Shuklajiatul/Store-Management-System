package edu.jsp.store.model;

import java.util.List;


public class Store {

	private int id;
	private String name;
	private long contact;
	private String address;
	private List<product> products;

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

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<product> getProducts() {
		return products;
	}

	public void setProducts(List<product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "store [id=" + id + ", name=" + name + ", contact=" + contact + ", address=" + address + "]";
	}
	
	

}
