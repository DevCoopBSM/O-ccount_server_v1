package bssm.devcoop.occount.global.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // User
    USER_NOT_FOUND("사용자를 찾을 수 없습니다.", 404),

    // Server
    INTERNAL_SERVER_ERROR("서버 에러가 발생하였습니다", 500),

    // Auth
    PASSWORD_NOT_CORRECT("비밀번호가 올바르지 않습니다", 400);

    private final String message;
    private final int status;
}
