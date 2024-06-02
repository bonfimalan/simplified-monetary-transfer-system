package io.github.bonfimalan.simplified_monetary_transfer_system.api.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorMessageResponse badRequest(BadRequestException cause) {
        log.warn("Bad request: {}", cause.getMessage());
        return new ErrorMessageResponse(BAD_REQUEST.value(), cause.getMessage());
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(CONFLICT)
    public ErrorMessageResponse conflict(ConflictException cause) {
        log.warn("Conflict: {}", cause.getMessage());
        return new ErrorMessageResponse(CONFLICT.value(), cause.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ErrorMessageResponse notFound(NotFoundException cause) {
        log.warn("Not found: {}", cause.getMessage());
        return new ErrorMessageResponse(NOT_FOUND.value(), cause.getMessage());
    }

}
