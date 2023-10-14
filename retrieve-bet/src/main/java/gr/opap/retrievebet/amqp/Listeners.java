package gr.opap.retrievebet.amqp;

import gr.opap.retrievebet.dto.BetDto;
import gr.opap.retrievebet.entity.Bet;
import gr.opap.retrievebet.repository.BetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Listeners {

  Logger logger = LoggerFactory.getLogger(Listeners.class);

  @Autowired
  BetRepository betRepository;

  @RabbitListener(queues = AmqpConfiguration.BET_QUEUE)
  public void userEmailVerification(@Payload BetDto betDto) {
    logger.info("userEmailVerification: {}", betDto);
    betRepository.save(new Bet(betDto));
  }

}
