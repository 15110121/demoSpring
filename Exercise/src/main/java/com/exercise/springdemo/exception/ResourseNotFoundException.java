package com.exercise.springdemo.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends RuntimeException {

    public ResourseNotFoundException(String message) {
        super(message);
    }

    public ResourseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourseNotFoundException(Throwable cause) {
        super(cause);
    }
}
