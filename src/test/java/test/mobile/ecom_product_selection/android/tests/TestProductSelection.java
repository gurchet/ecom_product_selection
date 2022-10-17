package test.mobile.ecom_product_selection.android.tests;

import test.mobile.ecom_product_selection.Utils.PropertiesUtils;
import test.mobile.ecom_product_selection.common.AppiumService;
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

import io.appium.java_client.AppiumDriver;

/**
 * @author : gurchet.singh
 *
 */
public class TestProductSelection {

	AppiumService appiumService;
	AppiumDriver driver;

	@Parameters({ "port_number", "platform", "target_type", "device_name" })
	@BeforeTest
	public void beforeTest(String portNumber, String platform, String targetType, String deviceName) throws Exception {
		PropertiesUtils.put("port_number", portNumber);
		PropertiesUtils.put("platform", platform);
		PropertiesUtils.put("target_type", targetType);
		PropertiesUtils.put("device_name", deviceName);
		LocalAppiumService.startAppiumDriverService();
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		driver = LocalAppiumDriver.getAppiumDriver();
		System.out.println("Appium driver is created for device " + PropertiesUtils.get("device_name"));
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		LocalAppiumDriver.quit();
	}

	@Test
	public void testProductSelection() throws Exception {
		
	}

	@AfterTest
	public void afterTest() throws Exception {
		LocalAppiumService.stopAppiumDriverService();
	}

	private void log(String message) {
		System.out.println(" ### " + new Date() + " ### " + message);
	}
}
