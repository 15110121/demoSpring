package com.exercise.springdemo.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@AllArgsConstructor
public class RelatedResourseException extends RuntimeException {
    public RelatedResourseException(String message) {
        super(message);
    }

    public RelatedResourseException(String message, Throwable cause) {
        super(message, cause);
    }

    public RelatedResourseException(Throwable cause) {
        super(cause);
    }
}
