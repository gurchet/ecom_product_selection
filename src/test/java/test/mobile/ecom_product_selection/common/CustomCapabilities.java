package test.mobile.ecom_product_selection.common;

import org.openqa.selenium.remote.DesiredCapabilities;
import test.mobile.ecom_product_selection.Utils.CapabilitiesReader;
import test.mobile.ecom_product_selection.Utils.PropertiesUtils;

/**
 * @author : gurchet.singh
 *
 */
public class CustomCapabilities {

	public static DesiredCapabilities get() throws Exception {
		String capabilitiesPath = "config/capabilities.json";
		DesiredCapabilities capabilities = CapabilitiesReader.getDesiredCapabilities(PropertiesUtils.get("device_name"),
				capabilitiesPath);
		return capabilities;
	}
}
