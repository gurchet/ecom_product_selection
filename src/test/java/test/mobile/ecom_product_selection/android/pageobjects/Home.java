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

	public Home(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}
	
	public ProductResults searchProduct(String productName) {
		waitAndEnter(this.searchBar, productName);
		waitAndClick(this.searchButton);
		return new ProductResults(this.driver);
	}

}
