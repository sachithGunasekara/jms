package app.jms.simple.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookOrderMessageProcessingListener implements MessageListener{

	private static final Logger logger = LoggerFactory.getLogger(BookOrderMessageProcessingListener.class);
	@Override
	public void onMessage(Message message) {
	try {
		String text = ((TextMessage)message).getText();
		logger.info(text);
	} catch (JMSException e) {
		logger.error("jms exception occurred", e);
	}
		
	}

}
