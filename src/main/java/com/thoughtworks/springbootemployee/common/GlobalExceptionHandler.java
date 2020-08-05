package com.thoughtworks.springbootemployee.common;

import com.thoughtworks.springbootemployee.exception.IllegalOperationException;
import com.thoughtworks.springbootemployee.exception.NoSuchDataException;
import org.springframework.beans.BeansException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.thoughtworks.springbootemployee.common.JsonResult.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchDataException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    JsonResult handleNoSuchDataException() {
        return http404();
    }

    @ExceptionHandler(IllegalOperationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    JsonResult handleIllegalOperationException() {
        return http403();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_EXTENDED)
    JsonResult handleIllegalArgumentException() {
        return http400();
    }

    @ExceptionHandler(BeansException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    JsonResult handleTransBeansException() {
        return http503();
    }
}
