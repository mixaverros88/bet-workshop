package gr.opap.placebet.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfiguration {

  public static final String USER_EMAIL_VERIFICATION = "user.email.verification";
  public static final String BET_QUEUE = "bet";
  public static final String BET_EXCHANGE = "bet";

  @Bean
  @Qualifier("betQueue")
  Queue betQueue() {
    return new Queue(BET_QUEUE, false);
  }

  @Bean
  @Qualifier("betExchange")
  DirectExchange betExchange() {
    return new DirectExchange(BET_QUEUE);
  }

  @Bean
  Binding betBinding(
      @Qualifier("betQueue") Queue queue,
      @Qualifier("betExchange") DirectExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(BET_QUEUE);
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
