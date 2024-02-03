package org.example.blockfileextension.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    DUPLICATED_EXTENSION(1, "이미 등록된 확장자입니다."),
    EMPTY_EXTENSION(2, "확장자를 입력해주세요.");

    final int code;
    final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
