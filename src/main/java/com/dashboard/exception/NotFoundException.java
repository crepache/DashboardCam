package com.dashboard.exception;

import com.dashboard.web.v1.response.Response;

public class NotFoundException extends RuntimeException {

  private transient final Response response;

  public Response getResponse() {
    return response;
  }

  public NotFoundException(Response response) {
    super();
    this.response = response;
  }
}
