package gr.opap.retrievebet.controller;

import gr.opap.retrievebet.dto.BetDto;
import gr.opap.retrievebet.service.BetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bet")
public class BetController {
  Logger logger = LoggerFactory.getLogger(BetController.class);
  @Autowired
  BetService betService;

  @GetMapping
  public List<BetDto> retrieveBet() {
    return betService.retrieveBet();
  }

}
