package gr.opap.bet.exception.handler;

import gr.opap.bet.exception.bet.BetIsNotValid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BetIsNotValid.class)
    public final ProblemDetail handleBadRequest(Exception ex, WebRequest req) {
        logger.info("handleBadRequest - Exception: {} , WebRequest: {}", ex, req);
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }


}
