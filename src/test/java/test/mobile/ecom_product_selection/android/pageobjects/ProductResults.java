package test.mobile.ecom_product_selection.android.pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author : gurchet.singh
 *
 */
public class ProductResults extends AndroidBasePage {

	ProductResults(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	public BuyNow selectProductByIndex(int index) {
		waitAndClick(By.xpath("//div[@data-cel-widget='search_result_" + String.valueOf(index) + "']"));
		return new BuyNow(this.driver);
	}
}
