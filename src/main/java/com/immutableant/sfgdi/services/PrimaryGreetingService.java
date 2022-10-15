package com.immutableant.sfgdi.services;

// @Service
// @Primary
public class PrimaryGreetingService implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hello World - From the PRIMARY Bean";
  }
}
