package practiceTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//@Listeners(com.comcast.crm.listener.ListImpClass.class)
public class InvoiceTest extends com.comcast.crm.listener.BaseClass{
	@Test
	public void createInvoiceTest() {
		System.out.println("execute createInvoiceTest");
		String actTitle= driver.getTitle();
		Assert.assertEquals(actTitle, "login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}

	@Test
	public void createInvoicewithContacttest() {
		System.out.println("execute createInvoicewithContacttest");
		
	}
}


