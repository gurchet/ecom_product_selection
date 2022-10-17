package test.mobile.ecom_product_selection.android.pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author : gurchet.singh
 *
 */
public class BuyNow extends AndroidBasePage {

	By buyNowButton = By.id("buy-now-button");

	BuyNow(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	public SignIn buyNow() {
		waitAndClick(this.buyNowButton);
		return new SignIn(this.driver);
	}
}
