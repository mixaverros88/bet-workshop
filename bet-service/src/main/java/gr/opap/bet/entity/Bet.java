package gr.opap.bet.entity;

import gr.opap.bet.dto.BetDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

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
    private String homeTeam;
    private String awayTeam;
    private String selection;

    public Bet() {
    }

    public Bet(BetDto betDto) {
        this.id = betDto.getId();
        this.amount = betDto.getAmount();
        this.awayTeam = betDto.getAwayTeam();
        this.homeTeam = betDto.getHomeTeam();
        this.selection = betDto.getSelection();
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

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    @Override
    public String toString() {
        return "Bet{" +
            "id=" + id +
            ", amount=" + amount +
            ", homeTeam='" + homeTeam + '\'' +
            ", awayTeam='" + awayTeam + '\'' +
            ", selection='" + selection + '\'' +
            '}';
    }
}
