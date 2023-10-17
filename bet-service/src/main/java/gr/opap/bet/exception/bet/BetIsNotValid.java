package gr.opap.bet.exception.bet;

public class BetIsNotValid extends RuntimeException {

    private final String bet;

    public BetIsNotValid(String bet) {
        this.bet = bet;
    }

    @Override
    public String getMessage() {
        return String.format("Bet %s is not valid", bet);
    }
}
