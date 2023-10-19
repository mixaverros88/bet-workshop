package gr.opap.antifraud.service;

import gr.opap.antifraud.dto.BetDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AntifraudService {

    Logger logger = LoggerFactory.getLogger(AntifraudService.class);

    public ResponseEntity<String> validateBet(BetDto betDto) {
        ResponseEntity<String> responseEntity;
        if (
            betDto.getHomeTeam().equalsIgnoreCase("Liverpool") &&
                betDto.getAwayTeam().equalsIgnoreCase("Alkmaar") &&
                betDto.getAmount() > 1000
        ) {
            logger.info("Antifraud service classified the bet: {} as invalid: ", betDto);
            responseEntity = ResponseEntity
                .badRequest()
                .body(
                    String.format("Bet %s vs %s with selection %s is not valid",
                        betDto.getHomeTeam(),
                        betDto.getAwayTeam(),
                        betDto.getSelection())
                );
        }else {
            logger.info("Antifraud service classified the bet: {} as valid: ", betDto);
            responseEntity = ResponseEntity.ok().build();
        }
        return responseEntity;
    }

}
