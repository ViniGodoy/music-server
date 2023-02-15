package br.pucpr.musicserver.lib.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends NoSuchElementException {
    public NotFoundException() {}

    public NotFoundException(Long id) {
        this("Not Found: " + id);
    }

    public NotFoundException(String s, Throwable cause) {
        super(s, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(String s) {
        super(s);
    }
}
