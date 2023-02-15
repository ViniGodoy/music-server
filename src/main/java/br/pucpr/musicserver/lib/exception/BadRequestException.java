package br.pucpr.musicserver.lib.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends NoSuchElementException {
    public BadRequestException() {}

    public BadRequestException(Long id) {
        this("Not Found: " + id);
    }

    public BadRequestException(String s, Throwable cause) {
        super(s, cause);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    public BadRequestException(String s) {
        super(s);
    }
}
