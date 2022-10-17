package test.mobile.ecom_product_selection.android.pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author : gurchet.singh
 *
 */
public class SignIn extends AndroidBasePage {

	By email = By.xpath("//input[@type='email']");
	By password = By.xpath("//input[@type='password']");
	By continueButton = By.id("continue");
	By signInButton = By.id("signInSubmit");

	SignIn(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	public void enterEmail(String emailString) {
		waitAndEnter(this.email, emailString);
	}

	public void continueNext() {
		waitAndClick(this.continueButton);
	}

	public void enterPassword(String passwordString) {
		waitAndEnter(this.password, passwordString);
	}

	public void signIn() {
		waitAndClick(this.signInButton);
	}
}
