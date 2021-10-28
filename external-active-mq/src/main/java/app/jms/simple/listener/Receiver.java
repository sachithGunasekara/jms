package app.jms.simple.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@JmsListener(destination = "order-queue")
	public void getMessage(String message) {
		System.out.println(message);
	}
}
