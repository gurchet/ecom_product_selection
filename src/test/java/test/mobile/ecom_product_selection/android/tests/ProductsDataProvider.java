package test.mobile.ecom_product_selection.android.tests;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;

import test.mobile.ecom_product_selection.Utils.JSONUtils;
import test.mobile.ecom_product_selection.Utils.PropertiesUtils;

public class ProductsDataProvider {

	@DataProvider(name = "name_of_dataprovider")
	public Object[][] getProducts() throws Exception {
		String jsonLocation = System.getProperty("user.dir") + PropertiesUtils.get("product_test_data_location");
		JSONArray testRecords = JSONUtils.getJSONArray(jsonLocation);
		int recordCount = testRecords.size();
		Object[][] testData = new Object[recordCount][7];
		for (int i = 0; i < testRecords.size(); i++) {
			JSONObject testRecord = (JSONObject) testRecords.get(i);
			testData[i][0] = testRecord.get("testDataId");
			testData[i][1] = testRecord.get("productName");
			testData[i][2] = testRecord.get("choiceIndex");
			testData[i][3] = testRecord.get("nameOnCard");
			testData[i][4] = testRecord.get("cardNumber");
			testData[i][5] = testRecord.get("expireMonth");
			testData[i][6] = testRecord.get("expireYear");
		}
		return testData;
	}
}
