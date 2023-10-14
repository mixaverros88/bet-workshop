package gr.opap.placebet.dto;

import gr.opap.placebet.entity.Bet;

public class BetDto {

  private Long id;
  private Double amount;

  public BetDto() {
  }

  public BetDto(Bet bet) {
    this.id = bet.getId();
    this.amount = bet.getAmount();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }
}
