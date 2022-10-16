package test.mobile.ecom_product_selection.common;

import java.util.Objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
/**
 * @author : gurchet.singh
 *
 */
public class LocalAppiumDriver {

	private static AppiumDriver driver;

	public static AppiumDriver getAppiumDriver() throws Exception {
		return driver;
	}

	public static void createAppiumDriver(Platform platform) throws Exception {
		switch (platform) {
		case ANDROID:
			driver = new AndroidDriver<AndroidElement>(LocalAppiumService.getAppiumServerUrl(),
					CustomCapabilities.get(platform));
		case IOS:
			driver = new IOSDriver<IOSElement>(LocalAppiumService.getAppiumServerUrl(),
					CustomCapabilities.get(platform));
		}

	}

	public static void quit() {
		if (Objects.nonNull(driver)) {
			driver.quit();
		}
	}

}
