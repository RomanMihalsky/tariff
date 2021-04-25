package com.faustov.tariff.exception;

public class TariffNotFoundException extends RuntimeException{
  public TariffNotFoundException() {
    super();
  }
  
  public TariffNotFoundException(String message) {
    super(message);
  }
}
