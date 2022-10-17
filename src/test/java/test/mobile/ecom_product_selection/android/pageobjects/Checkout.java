package test.mobile.ecom_product_selection.android.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Checkout extends AndroidBasePage {

	By clickToAdd = By.xpath("//button[contains(text(),'Click to add')]");
	By nameOnCardInput = By.xpath("//label[contains(text(),'Name on card')]//following-sibling::input");
	By cardNumberInput = By
			.xpath("//label[contains(text(),'Card number')]//following::input[@name='addCreditCardNumber']");

	By expirationMonth = By.xpath("//label[contains(text(),'Expiration date')]//following::select[1]");
	By expirationYear = By.xpath("//label[contains(text(),'Expiration date')]//following::select[2]");

	By addCardButton = By.xpath("//span[contains(text(),'Add your card')]//preceding-sibling::input");
	By selectPaymentMethodButton = By.xpath("//span[contains(text(),'Use this payment method')]");
	By orderTotal = By.xpath("//table[@id='subtotals-marketplace-table']//descendant::span[contains(text(),'Order Total')]//following::td[contains(text(),'.')]");
	
	Checkout(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	public Checkout addPaymentDetails(String nameOnCard, String cardNumber, String expireMonth, String expireYear) {
		waitAndClick(clickToAdd);
		this.driver.switchTo().frame("MapleAddACardIframe");
		waitAndEnter(nameOnCardInput, nameOnCard);
		waitAndEnter(cardNumberInput, cardNumber);
		Select expirationMonthSelect = new Select(this.driver.findElement(expirationMonth));
		expirationMonthSelect.selectByValue(expireMonth);
		Select expirationYearSelect = new Select(this.driver.findElement(expirationYear));
		expirationYearSelect.selectByValue(expireYear);
		waitAndClick(addCardButton);
		this.driver.switchTo().defaultContent();
		waitAndClick(selectPaymentMethodButton);
		return new Checkout(this.driver);
	}
	
	public String getTotalAmount() {
		return waitAndExtractText(orderTotal);
	}

}
