package test.mobile.ecom_product_selection.common;
/**
 * @author : gurchet.singh
 *
 */
public enum Platform {

	ANDROID("android"), IOS("ios");

	private final String name;

	Platform(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
