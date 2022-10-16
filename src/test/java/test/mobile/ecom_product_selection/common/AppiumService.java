package test.mobile.ecom_product_selection.common;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import test.mobile.ecom_product_selection.Utils.Port;
/**
 * @author : gurchet.singh
 *
 */
public class AppiumService {
    private int portNumber;
    private String baseUrl;
    private String url = "https://127.0.0.1";


    public void startAppiumDriverService() throws IOException {
        System.out.println(String.format("Starting Appium server"));
        portNumber = Port.getAvailablePort();
        Runtime.getRuntime().exec("appium -p "+portNumber);
    }

    public void stopAppiumDriverService() throws IOException {
        Runtime.getRuntime().exec("kill $(lsof -t -i:"+portNumber+")");
    }

    public URL getAppiumServerUrl() throws MalformedURLException {
        return new URL(url + ":"+portNumber+"/");
    }
}
