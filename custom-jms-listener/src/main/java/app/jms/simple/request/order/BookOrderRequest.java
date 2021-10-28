package app.jms.simple.request.order;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookOrderRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6817388108120213372L;
	@JsonProperty(required = true)
	private String bookId;
	
	@JsonProperty(required = true)
	private String bookName;
	
	@JsonProperty(required = true)
	private String customerId;
	
	@JsonProperty(required = true)
	private String customerName;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
