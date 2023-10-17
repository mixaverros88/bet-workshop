package gr.opap.antifraud.service;

import gr.opap.antifraud.dto.BetDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AntifraudService {

    Logger logger = LoggerFactory.getLogger(AntifraudService.class);

    public boolean validateBet(BetDto betDto) {
        if (
            betDto.getHomeTeam().equalsIgnoreCase("Liverpool") &&
                betDto.getAwayTeam().equalsIgnoreCase("Alkmaar") &&
                betDto.getAmount() > 1000
        ) {
            return false;
        }
        return true;
    }

}
