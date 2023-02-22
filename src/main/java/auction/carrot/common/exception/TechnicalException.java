package auction.carrot.common.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TechnicalException extends RuntimeException {

    private ErrorCode errorCode;

    public TechnicalException() { }

    @Builder
    public TechnicalException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
