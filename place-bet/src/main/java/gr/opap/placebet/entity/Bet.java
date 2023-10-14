package gr.opap.placebet.entity;


import gr.opap.placebet.dto.BetDto;
import jakarta.persistence.*;


import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "BET")
public class Bet implements Serializable {

  @Serial
  private static final long serialVersionUID = -8377964838683591097L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Double amount;

  public Bet() {
  }

  public Bet(BetDto betDto) {
    this.id = betDto.getId();
    this.amount = betDto.getAmount();
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
    return "Bet{" +
            "id=" + id +
            ", amount=" + amount +
            '}';
  }
}
