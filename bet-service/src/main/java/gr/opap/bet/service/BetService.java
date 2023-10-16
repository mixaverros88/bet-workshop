package gr.opap.bet.service;

import gr.opap.bet.dto.BetDto;
import gr.opap.bet.entity.Bet;
import gr.opap.bet.exception.bet.BetIsNotValid;
import gr.opap.bet.repository.BetRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BetService {

  Logger logger = LoggerFactory.getLogger(BetService.class);

  @Value("${antifraud.url}")
  private String antifraudUrl;
  @Autowired
  BetRepository betRepository;

  public void place(@Valid final BetDto betDto) {
    validateBet(betDto);
    betRepository.save(new Bet(betDto));
  }

  public List<BetDto> retrieveBet() {
    return betRepository.findAll().stream().map(BetDto::new).collect(Collectors.toList());
  }

  private void validateBet(BetDto betDto) {
    RestTemplate restTemplate = new RestTemplate();

    try {
      restTemplate.postForObject(antifraudUrl, betDto, String.class);
    }catch (Exception e){
      throw new BetIsNotValid(
              betDto.getHomeTeam() + betDto.getSelection() + betDto.getAwayTeam()
      );
    }

  }

}
