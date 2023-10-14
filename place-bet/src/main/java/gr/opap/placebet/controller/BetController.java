package gr.opap.placebet.controller;

import gr.opap.placebet.dto.BetDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bet")
public class BetController {
  Logger logger = LoggerFactory.getLogger(BetController.class);

  @PostMapping
  public BetDto add(@RequestBody final BetDto betDto) {
    return new BetDto();
  }

}
