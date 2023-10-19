package gr.opap.bet.amqp;

import gr.opap.bet.dto.BetDto;
import gr.opap.bet.entity.Bet;
import gr.opap.bet.repository.BetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static gr.opap.bet.amqp.AmqpConfiguration.BET_VALIDATION_FAILED_QUEUE;
import static gr.opap.bet.amqp.AmqpConfiguration.BET_VALIDATION_SUCCESS_QUEUE;

@Component
public class Listeners {

    Logger logger = LoggerFactory.getLogger(Listeners.class);

    @Autowired
    BetRepository betRepository;

    @RabbitListener(queues = BET_VALIDATION_SUCCESS_QUEUE)
    public void betValidationSuccessListener(@Payload BetDto betDto) {
        logger.info("Bet Service received a valid Bet: {} from queue: {}", betDto, BET_VALIDATION_SUCCESS_QUEUE);
        betRepository.save(new Bet(betDto));
    }

    @RabbitListener(queues = BET_VALIDATION_FAILED_QUEUE)
    public void betValidationFailedListener(@Payload BetDto betDto) {
        logger.info("Bet Service received an invalid Bet: {} from queue: {}", betDto, BET_VALIDATION_FAILED_QUEUE);
    }

}
