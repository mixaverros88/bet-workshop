package gr.opap.antifraud.amqp;

import com.fasterxml.jackson.databind.ObjectMapper;
import gr.opap.antifraud.dto.BetDto;
import gr.opap.antifraud.service.AntifraudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static gr.opap.antifraud.amqp.AmqpConfiguration.BET_VALIDATION_FAILED_ROUTING_KEY;
import static gr.opap.antifraud.amqp.AmqpConfiguration.BET_VALIDATION_RESULT_EXCHANGE;
import static gr.opap.antifraud.amqp.AmqpConfiguration.BET_VALIDATION_SUCCESS_ROUTING_KEY;

@Component
public class Listeners {

    Logger logger = LoggerFactory.getLogger(Listeners.class);

    @Autowired
    AntifraudService antifraudService;

    @Autowired
    Publisher publisher;

    @RabbitListener(queues = AmqpConfiguration.BET_VALIDATION_QUEUE)
    public void betValidationListener(@Payload BetDto betDto) {
        if (antifraudService.validateBet(betDto)) {
            logger.info("Bet: {} is valid", betDto);
            publisher.publish(BET_VALIDATION_RESULT_EXCHANGE, BET_VALIDATION_SUCCESS_ROUTING_KEY, betDto);
        } else {
            logger.info("Bet: {} is not valid", betDto);
            publisher.publish(BET_VALIDATION_RESULT_EXCHANGE, BET_VALIDATION_FAILED_ROUTING_KEY, betDto);
        }
    }

}
