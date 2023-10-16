package gr.opap.placebet.service;

import gr.opap.placebet.amqp.Publisher;
import gr.opap.placebet.dto.BetDto;
import gr.opap.placebet.repository.BetRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static gr.opap.placebet.amqp.AmqpConfiguration.BET_EXCHANGE;

@Service
public class BetService {

  Logger logger = LoggerFactory.getLogger(BetService.class);

  @Autowired
  Publisher publisher;

  @Autowired
  BetRepository betRepository;

  public void place(@Valid final BetDto betDto) {
    publisher.publish(BET_EXCHANGE, betDto);
  }

  public List<BetDto> retrieveBet() {
    return betRepository.findAll().stream().map(BetDto::new).collect(Collectors.toList());
  }

}
