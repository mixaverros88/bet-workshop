package gr.opap.bet.amqp;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfiguration {

    public static final String BET_VALIDATION_QUEUE = "bet.validation";
    public static final String BET_VALIDATION_EXCHANGE = "bet.validation.exchange";
    public static final String BET_VALIDATION_ROUTING_KEY = "bet";

    public static final String BET_VALIDATION_SUCCESS_QUEUE = "bet.validation.success";
    public static final String BET_VALIDATION_FAILED_QUEUE = "bet.validation.failed";
    public static final String BET_VALIDATION_RESULT_EXCHANGE = "bet.validation.result.exchange";
    public static final String BET_VALIDATION_SUCCESS_ROUTING_KEY = "bet.success";
    public static final String BET_VALIDATION_FAILED_ROUTING_KEY = "bet.failed";

    @Bean
    @Qualifier("betValidationQueue")
    Queue betValidationQueue() {
        return new Queue(BET_VALIDATION_QUEUE, false);
    }

    @Bean
    @Qualifier("betValidationExchange")
    TopicExchange betValidationExchange() {
        return new TopicExchange(BET_VALIDATION_EXCHANGE);
    }

    @Bean
    Binding betValidationBinding(
        @Qualifier("betValidationQueue") Queue queue,
        @Qualifier("betValidationExchange") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(BET_VALIDATION_ROUTING_KEY);
    }

    @Bean
    @Qualifier("betValidationSuccessQueue")
    Queue betValidationSuccessQueue() {
        return new Queue(BET_VALIDATION_SUCCESS_QUEUE, false);
    }

    @Bean
    @Qualifier("betValidationSuccessExchange")
    TopicExchange betValidationSuccessExchange() {
        return new TopicExchange(BET_VALIDATION_RESULT_EXCHANGE);
    }

    @Bean
    Binding betValidationSuccessBinding(
        @Qualifier("betValidationSuccessQueue") Queue queue,
        @Qualifier("betValidationSuccessExchange") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(BET_VALIDATION_SUCCESS_ROUTING_KEY);
    }

    @Bean
    @Qualifier("betValidationFailedQueue")
    Queue betValidationFailedQueue() {
        return new Queue(BET_VALIDATION_FAILED_QUEUE, false);
    }

    @Bean
    Binding betValidationFailedBinding(
        @Qualifier("betValidationFailedQueue") Queue queue,
        @Qualifier("betValidationSuccessExchange") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(BET_VALIDATION_FAILED_ROUTING_KEY);
    }

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
