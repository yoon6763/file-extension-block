package org.example.blockfileextension.exception;

public class FileExtensionException extends RuntimeException {
    public FileExtensionException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
