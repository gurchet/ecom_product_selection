package test.mobile.ecom_product_selection.Utils;

import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author : gurchet.singh
 *
 */
public class DriverUtils {

	private static void setDriverForConnectedDevice() {

	}

	private static ArrayList<String> getConnectedDeviceUdids() {
		ArrayList<String> udids = new ArrayList<>();
		CommandRunner cmd = new CommandRunner();
		String resultStdOut = null;
		try {
			resultStdOut = cmd.runCommandThruProcess("adb devices");
			String[] devices = resultStdOut.split("\n");
			for (int cnt = 1; cnt < devices.length; cnt++) {
				udids.add(resultStdOut.split("\n")[cnt].split("[ /\t]")[0]);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Error getting list of devices" + e.getMessage());
		}
		if (udids.size() == 0) {
			throw new RuntimeException("No devices connected");
		}
		return udids;
	}
}
