package gr.opap.bet.controller;

import gr.opap.bet.dto.BetDto;
import gr.opap.bet.service.BetService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bet")
public class BetController {
    Logger logger = LoggerFactory.getLogger(BetController.class);

    @Autowired
    BetService betService;

    @Operation(summary = "Add A Bet")
    @PostMapping
    public ResponseEntity place(@Valid @RequestBody final BetDto betDto) {
        betService.place(betDto);
        logger.info("Bet has been added successfully to database");
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get All the Bets")
    @GetMapping
    public List<BetDto> retrieve() {
        return betService.retrieve();
    }

}
