package app.jms.simple.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.jms.simple.model.Book;
import app.jms.simple.model.BookOrder;
import app.jms.simple.model.Customer;
import app.jms.simple.request.order.BookOrderRequest;
import app.jms.simple.service.order.BookOrderService;

@RestController
@RequestMapping(path = "orders")
public class BookOrderController {

	@Autowired
	private BookOrderService bookOrderService;

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity createOrder(@Valid @RequestBody BookOrderRequest request) {
		Book book = new Book();
		book.setId(request.getBookId());
		book.setName(request.getBookName());

		Customer customer = new Customer();
		customer.setId(request.getCustomerId());
		customer.setName(request.getCustomerName());

		BookOrder order = new BookOrder();
		order.setOrderId(UUID.randomUUID().toString());
		order.setBook(book);
		order.setCustomer(customer);

		bookOrderService.addOrder(order);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
