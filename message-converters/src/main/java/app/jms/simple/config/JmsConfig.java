package app.jms.simple.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.oxm.xstream.XStreamMarshaller;

import app.jms.simple.model.Book;
import app.jms.simple.model.BookOrder;
import app.jms.simple.model.Customer;

@EnableJms
@Configuration
public class JmsConfig {

	//@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
	
	@Bean
	public MessageConverter xmlMarshallingMessageConverter() {
		MarshallingMessageConverter converter = new MarshallingMessageConverter(xmlMarshaller());
		converter.setTargetType(MessageType.TEXT);
		return converter;
	}
	
	@Bean
	public XStreamMarshaller xmlMarshaller() {
		XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
		xStreamMarshaller.setSupportedClasses(Book.class,Customer.class,BookOrder.class);
		return xStreamMarshaller;
	}
	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
		return factory;
	}

	public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setConcurrency("1-1");
		//factory.setMessageConverter(jacksonJmsMessageConverter());
		factory.setMessageConverter(xmlMarshallingMessageConverter());
		return factory;
	}
}
