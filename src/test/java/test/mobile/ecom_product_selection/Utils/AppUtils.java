package test.mobile.ecom_product_selection.Utils;

import test.mobile.ecom_product_selection.common.Extension;
import test.mobile.ecom_product_selection.common.Platform;
/**
 * @author : gurchet.singh
 *
 */
public class AppUtils {

	public static String getAppPath(Platform platform) {
		String basePath = System.getProperty("user.dir") + "/";
		String appName = PropertiesUtils.get("appname");
		switch (platform) {
		case ANDROID:
			return basePath + "resources/" + appName + "." + Extension.APK.getName();
		case IOS:
			return basePath + "resources/" + appName + "." + Extension.IPA.getName();
		default:
			return "";
		}

	}

	public static String getAppPackage(Platform platform) {
		return PropertiesUtils.get(platform.getName() + "_app_package");
	}

}
