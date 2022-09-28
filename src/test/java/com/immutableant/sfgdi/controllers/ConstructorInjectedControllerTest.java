package com.immutableant.sfgdi.controllers;

import static org.junit.jupiter.api.Assertions.*;

import com.immutableant.sfgdi.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorInjectedControllerTest {

  private ConstructorInjectedController controller;

  @BeforeEach
  void setUp() {
    controller = new ConstructorInjectedController((new GreetingServiceImpl()));
  }

  @Test
  void getGreeting() {
    System.out.println((controller.getGreeting()));
  }
}