package test.mobile.ecom_product_selection.android.tests;

import test.mobile.ecom_product_selection.Utils.PropertiesUtils;
import test.mobile.ecom_product_selection.common.AppiumService;
import test.mobile.ecom_product_selection.common.Platform;
import test.mobile.ecom_product_selection.common.LocalAppiumDriver;
import test.mobile.ecom_product_selection.common.LocalAppiumService;
import java.util.Date;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
/**
 * @author : gurchet.singh
 *
 */
public class TestProductSelection {

	AppiumService appiumService;
	
	@Parameters({ "port_number","device_name" })
	@BeforeTest
	public void beforeTest(String portNumber, String deviceName) throws Exception {
		PropertiesUtils.put("port_number", portNumber);
		PropertiesUtils.put("device_name", deviceName);
		LocalAppiumService.startAppiumDriverService(Integer.parseInt(portNumber));
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		LocalAppiumDriver.createAppiumDriver(Platform.ANDROID);
		System.out.println("Appium driver is created for device "+PropertiesUtils.get("device_name"));
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		LocalAppiumDriver.quit();
	}

	@Test
	public void runMessagesTest() throws Exception {
		System.out.println("Appium driver : " + LocalAppiumDriver.getAppiumDriver().getAutomationName());
	}

	@AfterTest
	public void afterTest() throws Exception {
		LocalAppiumService.stopAppiumDriverService();
	}

	private void log(String message) {
		System.out.println(" ### " + new Date() + " ### " + message);
	}
}
