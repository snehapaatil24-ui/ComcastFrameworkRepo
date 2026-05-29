package practiceTest;

import org.testng.annotations.Test;

public class OrderTest {
	@Test(invocationCount=10)
	public void createOrderTest() {
		
		System.out.println("Execute createOrdertest--12345");
		
	}
	
	@Test(enabled =false)
	public void billingOrderTest() {
		System.out.println("Execute billingAndOrderTest---54321");
	}

}

