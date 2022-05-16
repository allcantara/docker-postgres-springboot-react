package com.allcantara.app.config;

import java.util.Date;

import javax.servlet.ServletException;

import com.allcantara.app.utils.exception.AllcantaraAppException;
import com.allcantara.app.utils.exception.ErrorDetails;
import com.allcantara.app.utils.exception.ForbiddenException;
import com.allcantara.app.utils.exception.InternalErrorException;
import com.allcantara.app.utils.exception.NotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionConfig extends ResponseEntityExceptionHandler {
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(RestExceptionConfig.class);

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception exception, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetails details = getErrorDetails(exception, status);
        return new ResponseEntity<Object>(details, headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServletException.class)
    public ResponseEntity<?> handleServletException(ServletException servletException) {
        ErrorDetails details = getErrorDetails(servletException, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException notFoundException) {
        ErrorDetails details = getErrorDetails(notFoundException, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<?> handleForbiddenException(ForbiddenException notFoundException) {
        ErrorDetails details = getErrorDetails(notFoundException, HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(details, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AllcantaraAppException.class)
    public ResponseEntity<?> handleByCodersAppException(AllcantaraAppException byCodersAppException) {
        ErrorDetails details = getErrorDetails(byCodersAppException, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchMethodException.class)
    public ResponseEntity<?> handleNoSuchMethodException(NoSuchMethodException byCodersAppException) {
        ErrorDetails details = getErrorDetails(byCodersAppException, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalErrorException.class)
    public ResponseEntity<?> handleInternalErrorException(InternalErrorException internalErrorException) {
        ErrorDetails details = getErrorDetails(internalErrorException, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException runtimeException) {
        ErrorDetails details = getErrorDetails(runtimeException, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    private ErrorDetails getErrorDetails(Exception exception, HttpStatus status) {
        ErrorDetails details = getErrorDetails(exception.getMessage(), exception.getClass().getName(), status.value());
        LOG.error(details.getMessage(), exception);
        return details;
    }

    private ErrorDetails getErrorDetails(String message, String exception, Integer status) {
        return ErrorDetails.builder()
                .timestamp(new Date().getTime())
                .status(status)
                .message(message)
                .exception(exception)
                .build();
    }
}
