package gr.opap.placebet.amqp;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Listeners {

  Logger logger = LoggerFactory.getLogger(Listeners.class);


  @RabbitListener(queues = AmqpConfiguration.USER_EMAIL_VERIFICATION)
  public void userEmailVerification(@Valid @Payload String message) {
    logger.info("userEmailVerification: {}", message);
  }

}
