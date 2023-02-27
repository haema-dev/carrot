package auction.carrot.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    // 서버 에러
    INTERNAL_SERVER_ERROR(500, "S999", "서버 에러");

    private int status;
    private String code;
    private String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}