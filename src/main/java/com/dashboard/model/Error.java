package com.dashboard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.validation.ObjectError;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Error<T> {

  private List<ObjectError> message;

  private T details;

  public Error(List<ObjectError> messsage) {
    this.message = messsage;
  }

  public Error(List<ObjectError>  messsage, T details) {
    this.details = details;
    this.message = messsage;
  }

  public List<ObjectError>  getMessage() {
    return message;
  }

  public void setMessage(List<ObjectError>  message) {
    this.message = message;
  }

  public T getDetails() {
    return details;
  }

  public void setDetails(T details) {
    this.details = details;
  }

}