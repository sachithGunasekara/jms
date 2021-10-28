package app.jms.simple.service.impl.warehouse;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import app.jms.simple.model.BookOrder;
import app.jms.simple.service.warehouse.WarehouseService;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	private static final String BOOK_QUEUE = "book.order.queue";

	@JmsListener(destination = BOOK_QUEUE)
	@Override
	public void getOrder(BookOrder order) {
		System.out.println(order);
	}

}
