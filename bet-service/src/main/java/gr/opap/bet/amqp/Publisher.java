package gr.opap.bet.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    Logger logger = LoggerFactory.getLogger(Publisher.class);

    private final RabbitTemplate rabbitTemplate;

    public Publisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(String exchange, String routingKey, Object dto) {
        rabbitTemplate.convertAndSend(exchange, routingKey, dto);
        logger.info("{} bet has been send successfully to exchange: {} with routing key: {}", dto, exchange, routingKey);
    }
}
