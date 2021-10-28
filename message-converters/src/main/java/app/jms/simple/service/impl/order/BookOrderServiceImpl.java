package app.jms.simple.service.impl.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import app.jms.simple.model.BookOrder;
import app.jms.simple.service.order.BookOrderService;

@Service
public class BookOrderServiceImpl implements BookOrderService {

	private static final String BOOK_QUEUE = "book.order.queue";

	private JmsTemplate jmsTemplate;

	@Autowired
	public BookOrderServiceImpl(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public BookOrderServiceImpl() {

	}

	@Override
	public void addOrder(BookOrder order) {
		jmsTemplate.convertAndSend(BOOK_QUEUE, order);
	}

}
