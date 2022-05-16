package com.allcantara.app.utils.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@AllArgsConstructor
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AllcantaraAppException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public AllcantaraAppException(String message) {
        super(message);
    }

    public AllcantaraAppException(String message, Exception e) {
        super(message, e);
    }

    public AllcantaraAppException(Exception e) {
        super(e);
    }
}
