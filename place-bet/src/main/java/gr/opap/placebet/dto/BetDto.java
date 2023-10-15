package gr.opap.placebet.dto;

import jakarta.validation.constraints.Positive;

public class BetDto {

  private Long id;
  @Positive
  private Double amount;

  public BetDto() {
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

  @Override
  public String toString() {
    return "BetDto{" +
            "id=" + id +
            ", amount=" + amount +
            '}';
  }
}
