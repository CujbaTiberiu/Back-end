package day4.Esercizio;

import java.time.LocalDate;
import java.util.List;

public class Order {
	
	private long id;
	private String status;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private List<Product> products;
	private Customer customer;
	
	public Order(long id, String status, LocalDate orderDate, LocalDate deliveryDate,List<Product> products,
			Customer customer) {
		this.id = id;
		this.status = status;
		this.orderDate = null;
		this.deliveryDate = null;
		this.products = products;
		this.customer = customer;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(int day, int month, int year) {
		this.orderDate = LocalDate.of(year, month, day);
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(int day, int month, int year) {
		this.deliveryDate = LocalDate.of(year, month, day);
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate
				+ ", products=" + products + ", customer=" + customer + "]";
	}


	
	
	

}
