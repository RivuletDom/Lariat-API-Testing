package test.java.MarComAPI;

import org.testng.annotations.Test;

import test.java.MarComAPI.General.ClientContactPerson;

import org.testng.annotations.AfterSuite;

public class validation {
  @Test
  public void f() {
  }
  @AfterSuite
  public void afterSuite() {
	  
	  String email = ClientContactPerson.clientemail;
	  System.out.println("xxx" +email);
  }

}
