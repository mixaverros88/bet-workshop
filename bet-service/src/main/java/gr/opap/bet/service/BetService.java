package gr.opap.bet.service;

import gr.opap.bet.amqp.Publisher;
import gr.opap.bet.dto.BetDto;
import gr.opap.bet.entity.Bet;
import gr.opap.bet.repository.BetRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static gr.opap.bet.amqp.AmqpConfiguration.BET_VALIDATION_EXCHANGE;
import static gr.opap.bet.amqp.AmqpConfiguration.BET_VALIDATION_ROUTING_KEY;

@Service
public class BetService {

    Logger logger = LoggerFactory.getLogger(BetService.class);

    @Value("${antifraud.url}")
    private String antifraudUrl;
    @Autowired
    Publisher publisher;
    @Autowired
    BetRepository betRepository;

    public void place(@Valid final BetDto betDto) {
        publisher.publish(BET_VALIDATION_EXCHANGE, BET_VALIDATION_ROUTING_KEY, betDto);
    }

    public List<BetDto> retrieveBet() {
        return betRepository.findAll().stream().map(BetDto::new).collect(Collectors.toList());
    }

}
