package com.dashboard.exception;

import com.dashboard.web.v1.response.Response;

public class BadRequestException extends RuntimeException {
  /**
   * Represents an error for an entity.
   */
  private transient final Response response;

  public Response getResponse() {
    return response;
  }

  public BadRequestException(Response response) {
    super();
    this.response = response;
  }
}
