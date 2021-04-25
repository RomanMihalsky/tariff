package com.faustov.tariff.exception;

public class RouterNotFoundException extends RuntimeException{
  public RouterNotFoundException() {
    super();
  }
  
  public RouterNotFoundException(String message) {
    super(message);
  }
}
