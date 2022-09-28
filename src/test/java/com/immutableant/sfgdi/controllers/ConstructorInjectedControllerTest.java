package com.immutableant.sfgdi.controllers;

import com.immutableant.sfgdi.services.ConstructorGreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorInjectedControllerTest {

  private ConstructorInjectedController controller;

  @BeforeEach
  void setUp() {
    controller = new ConstructorInjectedController((new ConstructorGreetingServiceImpl()));
  }

  @Test
  void getGreeting() {
    System.out.println((controller.getGreeting()));
  }
}