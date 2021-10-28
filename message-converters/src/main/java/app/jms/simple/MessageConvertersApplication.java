package app.jms.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class MessageConvertersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageConvertersApplication.class, args);
	}
}
