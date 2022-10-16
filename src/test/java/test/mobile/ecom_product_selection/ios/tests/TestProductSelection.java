package test.mobile.ecom_product_selection.ios.tests;

import test.mobile.ecom_product_selection.common.Platform;
import test.mobile.ecom_product_selection.Utils.PropertiesUtils;
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

	@Parameters({ "port_number" })
	@BeforeTest
	public void beforeTest(String portNumber) throws Exception {
		LocalAppiumService.startAppiumDriverService(Integer.parseInt(portNumber));
	}

	@Parameters({ "device_name" })
	@BeforeMethod
	public void beforeMethod(String device_name) throws Exception {
		PropertiesUtils.put("device_name", device_name);
		LocalAppiumDriver.createAppiumDriver(Platform.IOS);
		System.out.println("Appium driver is created for device " + device_name);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		LocalAppiumDriver.quit();
	}

	@Test
	public void runMessagesTest() throws Exception {
		System.out.println("Appium server : " + LocalAppiumService.getAppiumServerUrl());
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
