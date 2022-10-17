package test.mobile.ecom_product_selection.common;

import java.util.Objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import test.mobile.ecom_product_selection.Utils.PropertiesUtils;

/**
 * @author : gurchet.singh
 *
 */
public class LocalAppiumDriver {

	private static AppiumDriver driver;

	public static AppiumDriver getAppiumDriver() throws Exception {
		if (Objects.nonNull(driver))
			return driver;
		else
			switch (PropertiesUtils.get("platform")) {
			case "android":
				driver = new AndroidDriver<AndroidElement>(LocalAppiumService.getAppiumServerUrl(),
						CustomCapabilities.get());
				return driver;
			case "ios":
				driver = new IOSDriver<IOSElement>(LocalAppiumService.getAppiumServerUrl(), CustomCapabilities.get());
				return driver;
			default:
				return driver;
			}
	}

	public static void quit() {
		if (Objects.nonNull(driver)) {
			driver.quit();
		}
	}

}
