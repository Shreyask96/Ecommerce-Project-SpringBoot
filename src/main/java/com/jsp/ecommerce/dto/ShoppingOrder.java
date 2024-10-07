package com.jsp.ecommerce.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ShoppingOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String order_id;
	String payment_id;
	LocalDateTime dateTime;
	double amount;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

	@Override
	public String toString() {
		return "ShoppingOrder [id=" + id + ", order_id=" + order_id + ", payment_id=" + payment_id + ", dateTime="
				+ dateTime + ", amount=" + amount + ", items=" + items + ", customer=" + customer + "]";
	}



	@OneToMany
	List<Item> items;

	@ManyToOne
	Customer customer;
	
	public String getDate()
	{
		return this.dateTime.format(DateTimeFormatter.ofPattern("dd-MMM-YYYY hh:mm"));
	}
}