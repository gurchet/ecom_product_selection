package test.mobile.ecom_product_selection.android.pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author : gurchet.singh
 *
 */
public class Home extends AndroidBasePage {

	By searchBar = By.id("search_query_top");
	By searchButton = By.id("nav-search-submit-button");

	Home(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}
	
	public void searchProduct(String productName) {
		waitAndEnter(this.searchBar, productName);
		waitAndClick(this.searchButton);
	}

	public void selectProductByIndex(int index) {
		waitAndClick(By.xpath("//div[@data-cel-widget='search_result_" + String.valueOf(index) + "']"));
	}
}
