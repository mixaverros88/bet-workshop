package gr.opap.bet.service;

import gr.opap.bet.dto.BetDto;
import gr.opap.bet.entity.Bet;
import gr.opap.bet.repository.BetRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BetService {

    Logger logger = LoggerFactory.getLogger(BetService.class);

    @Autowired
    BetRepository betRepository;

    public void place(@Valid final BetDto betDto) {
        betRepository.save(new Bet(betDto));
    }

    public List<BetDto> retrieve() {
        return betRepository.findAll().stream().map(BetDto::new).collect(Collectors.toList());
    }

}
