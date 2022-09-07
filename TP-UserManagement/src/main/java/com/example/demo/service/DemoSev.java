package com.example.demo.service;

 
import org.springframework.security.access.annotation.Secured;
 
public class DemoSev
{
  @Secured("ROLE_USER")
  public void method()
  {
    System.out.println("Method called");
  }
}