package gr.opap.placebet.service;

import gr.opap.placebet.amqp.Publisher;
import gr.opap.placebet.dto.BetDto;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static gr.opap.placebet.amqp.AmqpConfiguration.BET_EXCHANGE;

@Service
public class BetService {

  Logger logger = LoggerFactory.getLogger(BetService.class);

  @Autowired
  Publisher publisher;

  public String add(@Valid final BetDto betDto) {
    publisher.publish(BET_EXCHANGE, betDto);
    return "added";
  }



}
