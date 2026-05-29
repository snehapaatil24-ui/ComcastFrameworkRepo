package practiceTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Practice111 {

	@BeforeSuite
	public void configBS() {
		System.out.println("BS is executing");
	}

	@BeforeClass
	public void configBC() {
		System.out.println("BC is executing");

	}

	@BeforeTest
	public void configBT() {
		System.out.println("BT is executing");

	}

	@BeforeMethod
	public void configBM() {
		System.out.println("BM is executing");
	}

	@AfterTest
	public void configAT() {
		System.out.println("AT is executing");
	}

	@AfterMethod
	public void configAM() {
		System.out.println("AM is executing");
	}

	@AfterClass
	public void configAC() {
		System.out.println("AM is executing");
	}

	@AfterSuite
	public void configAS() {
		System.out.println("AS is executing");
	}

}
