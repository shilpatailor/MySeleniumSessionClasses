package test.com;

import org.testng.annotations.Test;

public class InvocationCountTest {

  @Test(invocationCount = 5)
  public void sum() {
	  int a=9;
	  int b=1;
	  int c=a+b;
	  System.out.println("Total sum ==> " + c);
  }

}
