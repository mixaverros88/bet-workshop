package gr.opap.antifraud.controller;

import gr.opap.antifraud.dto.BetDto;
import gr.opap.antifraud.service.AntifraudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/antifraud/check")
public class AntifraudController {

    Logger logger = LoggerFactory.getLogger(AntifraudController.class);
    @Autowired
    AntifraudService antifraudService;

    @PostMapping
    public ResponseEntity<String> validateBet(@RequestBody final BetDto betDto) {
        logger.info("Antifraud controller has received bet: {}", betDto);
        return antifraudService.validateBet(betDto);
    }

}
