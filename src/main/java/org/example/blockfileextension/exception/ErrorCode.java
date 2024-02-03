package org.example.blockfileextension.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    DUPLICATED_EXTENSION(1, "이미 등록된 확장자입니다."),
    EMPTY_EXTENSION(2, "확장자를 입력해주세요."),
    MAX_EXTENSION_LENGTH_EXCEEDED(3, "확장자는 최대 20자까지 입력 가능합니다.");

    final int code;
    final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
