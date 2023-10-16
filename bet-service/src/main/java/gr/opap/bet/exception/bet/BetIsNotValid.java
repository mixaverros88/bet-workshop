package gr.opap.bet.exception.bet;

public class BetIsNotValid extends RuntimeException {

    private final String message;

    public BetIsNotValid(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return String.format(message);
    }
}
