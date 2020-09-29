package com.optivision.webapp.commons;

import com.optivision.webapp.appointment.exception.CollidingAppointmentHoursException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CollidingAppointmentHoursException.class})
    public final ResponseEntity<Object> handleException(CollidingAppointmentHoursException ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        //String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, ex.getLocalizedMessage(),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


}
