package gr.opap.bet.dto;

import gr.opap.bet.entity.Bet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class BetDto {

    private Long id;
    @Positive
    private Double amount;
    @NotBlank
    private String homeTeam;
    @NotBlank
    private String awayTeam;
    @NotBlank
    private String selection;

    public BetDto() {
    }

    public BetDto(Bet bet) {
        this.id = bet.getId();
        this.amount = bet.getAmount();
        this.homeTeam = bet.getHomeTeam();
        this.awayTeam = bet.getAwayTeam();
        this.selection = bet.getSelection();
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
        return "BetDto{" +
            "id=" + id +
            ", amount=" + amount +
            ", homeTeam='" + homeTeam + '\'' +
            ", awayTeam='" + awayTeam + '\'' +
            ", selection='" + selection + '\'' +
            '}';
    }
}
