package dockerValidation;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class FirefoxTest {
	
	@Test
	public static void chromeTest1() {
		try {
			URL u = new URL("http://localhost:4444/wd/hub");
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			RemoteWebDriver driver = new RemoteWebDriver(u, cap);
			driver.get("https://www.google.com/");
			System.out.println(driver.getTitle());
			driver.close();
		} catch (Exception e) {
			System.err.println("ERROR: Caught exception! "+e.getMessage());
		}
	}
}
