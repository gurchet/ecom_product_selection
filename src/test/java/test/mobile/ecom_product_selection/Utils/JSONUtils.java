package test.mobile.ecom_product_selection.Utils;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class JSONUtils {

	public static JSONArray getJSONArray(String jsonLocation) throws Exception {
		JSONParser jsonParser = new JSONParser();
		return (JSONArray) jsonParser.parse(new FileReader(jsonLocation));
	}
}
