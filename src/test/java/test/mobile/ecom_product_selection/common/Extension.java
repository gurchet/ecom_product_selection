package test.mobile.ecom_product_selection.common;
/**
 * @author : gurchet.singh
 *
 */
public enum Extension {

	APK("apk"),APP("app"),IPA("ipa");
	
	private final String name;

	Extension(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	
}
