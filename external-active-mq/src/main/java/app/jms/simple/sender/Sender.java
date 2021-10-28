package app.jms.simple.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendMesssage(String destination,String message) {
		jmsTemplate.convertAndSend(destination, message);
	}
}
