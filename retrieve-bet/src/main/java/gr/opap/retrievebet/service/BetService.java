package gr.opap.retrievebet.service;

import gr.opap.retrievebet.dto.BetDto;
import gr.opap.retrievebet.repository.BetRepository;
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

  public List<BetDto> retrieveBet() {
    return betRepository.findAll().stream().map(BetDto::new).collect(Collectors.toList());
  }



}
