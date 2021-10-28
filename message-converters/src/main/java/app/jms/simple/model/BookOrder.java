package app.jms.simple.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 501258259447765475L;
	private String orderId;
	private Book book;
	private Customer customer;

	@JsonCreator
	public BookOrder(@JsonProperty("orderId") String orderId, @JsonProperty("book") Book book,
			@JsonProperty("customer") Customer customer) {
		this.orderId = orderId;
		this.book = book;
		this.customer = customer;
	}
	
	public BookOrder() {
		
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "BookOrder [orderId=" + orderId + ", book=" + book + ", customer=" + customer + "]";
	}
}
