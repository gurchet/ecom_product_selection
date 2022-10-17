package test.mobile.ecom_product_selection.common;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import test.mobile.ecom_product_selection.Utils.Port;
import test.mobile.ecom_product_selection.Utils.PropertiesUtils;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
/**
 * @author : gurchet.singh
 *
 */
public class LocalAppiumService {
    private static AppiumDriverLocalService appiumServer;

    public static void startAppiumDriverService() {
        System.out.println(String.format("Starting Appium server"));
        int portNumber = Integer.parseInt(PropertiesUtils.get("port_number"));
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.withStartUpTimeOut(60, TimeUnit.SECONDS);
        serviceBuilder.withAppiumJS(new File(
				"/usr/local/lib/node_modules/appium/lib/appium.js"));
        serviceBuilder.usingPort(portNumber);
        serviceBuilder.withLogFile(new File(System.getProperty("user.dir") + "/target/resources/appium_server_logs" + Thread.currentThread().getId()));
        appiumServer = AppiumDriverLocalService.buildService(serviceBuilder);
        appiumServer.start();
		System.out.println("Appium server started on : " + getAppiumServerUrl());
    }

    public static void stopAppiumDriverService() {
        if (Objects.nonNull(appiumServer))
            appiumServer.stop();
    }

    public static URL getAppiumServerUrl() {
        return appiumServer.getUrl();
    }
}
