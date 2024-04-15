package bssm.devcoop.occount.global.exception;

import bssm.devcoop.occount.global.exception.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GlobalException extends Throwable {
    private final ErrorCode errorCode;
}
