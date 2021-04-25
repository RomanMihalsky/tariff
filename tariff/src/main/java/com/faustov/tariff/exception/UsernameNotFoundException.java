package com.faustov.tariff.exception;

public class UsernameNotFoundException extends RuntimeException{
  
  public UsernameNotFoundException() {
    super();
  }
  
  public UsernameNotFoundException(String message) {
    super(message);
  }
}
