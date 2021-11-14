package com.mongodb.project.common.exceptions;

import com.mongodb.project.common.results.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EmployeeNotFoundException.class, EmployeeNotCreatedException.class})
    public final ResponseEntity<ErrorResponse> handleException(Exception ex, WebRequest request) {

        HttpHeaders headers = new HttpHeaders();

        if (ex instanceof EmployeeNotFoundException) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            EmployeeNotFoundException employeeNotFoundException = (EmployeeNotFoundException) ex;
            return handleEmployeeNotFoundException(employeeNotFoundException, headers, status, request);
        } else if (ex instanceof EmployeeNotCreatedException) {
            HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
            EmployeeNotCreatedException employeeNotCreatedException = (EmployeeNotCreatedException) ex;
            return handleEmployeeNotCreatedException(employeeNotCreatedException, headers, status, request);
        } else {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleExceptionInternal(ex, null, headers, status, request);
        }
    }

    protected ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        return handleExceptionInternal(ex, new ErrorResponse(errors), headers, status, request);
    }

    protected ResponseEntity<ErrorResponse> handleEmployeeNotCreatedException(EmployeeNotCreatedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        return handleExceptionInternal(ex, new ErrorResponse(errors), headers, status, request);
    }

    protected ResponseEntity<ErrorResponse> handleExceptionInternal(Exception ex, ErrorResponse body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<>(body, headers, status);
    }

}
