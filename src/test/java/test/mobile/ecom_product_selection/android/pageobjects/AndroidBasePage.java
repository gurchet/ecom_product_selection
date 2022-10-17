package test.mobile.ecom_product_selection.android.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidBasePage {

	public AndroidDriver<AndroidElement> driver;

	AndroidBasePage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public void waitAndClick(By by) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void waitAndEnter(By by, String text) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(text);
	}
}
