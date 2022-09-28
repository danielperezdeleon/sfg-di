package com.immutableant.sfgdi.controllers;

import com.immutableant.sfgdi.services.GreetingService;

public class PropertyInjectedController {
  public GreetingService greetingService;

  public String getGreeting() {
    return greetingService.sayGreeting();
  }
}
