package gr.opap.placebet.controller;

import gr.opap.placebet.dto.BetDto;
import gr.opap.placebet.service.BetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bet")
public class BetController {
  Logger logger = LoggerFactory.getLogger(BetController.class);

  @Autowired
  BetService betService;

  @PostMapping
  public ResponseEntity add(@RequestBody final BetDto betDto) {
    betService.add(betDto);
    return ResponseEntity.ok().build();
  }

}
