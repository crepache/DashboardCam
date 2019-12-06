package com.dashboard.exception;

import com.dashboard.web.v1.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DashboardControllerAdvice {

  private ResponseEntity<?> error(HttpStatus status, Response e) {
    return ResponseEntity.status(status).body(e);
  }

  @ExceptionHandler({BadRequestException.class})
  public ResponseEntity<?> handleBadRequestException(BadRequestException e) {
    return error(HttpStatus.BAD_REQUEST, e.getResponse());
  }

  @ExceptionHandler({NotFoundException.class})
  public ResponseEntity<?> handleNotFoundException(NotFoundException e) {
    return error(HttpStatus.NOT_FOUND, e.getResponse());
  }

}
