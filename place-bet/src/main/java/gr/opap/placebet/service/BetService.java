package gr.opap.placebet.service;

import gr.opap.placebet.dto.BetDto;
import gr.opap.placebet.entity.Bet;
import gr.opap.placebet.repository.BetRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetService {

  Logger logger = LoggerFactory.getLogger(BetService.class);
  @Autowired
  BetRepository betRepository;

  public BetDto add(@Valid final BetDto betDto) {
    Bet save = betRepository.save(new Bet(betDto));
    return new BetDto(save);
  }



}
