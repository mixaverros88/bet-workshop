package gr.opap.antifraud.amqp;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfiguration {

    public static final String BET_VALIDATION_QUEUE = "bet.validation";
    public static final String BET_VALIDATION_RESULT_EXCHANGE = "bet.validation.result.exchange";
    public static final String BET_VALIDATION_SUCCESS_ROUTING_KEY = "bet.success";
    public static final String BET_VALIDATION_FAILED_ROUTING_KEY = "bet.failed";

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
