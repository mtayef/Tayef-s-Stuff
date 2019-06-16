package dockerValidation;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeTest1 extends DockerCommands{
	
	@BeforeTest
	public static void startDocker(){
		
		String bat = "dockerUp.bat";
		String text = "registered to the hub and ready to use";
		
		delete();
		startStopFile(bat, text);
		scale();
	}
	
	@Test
	public static void chromeTest1() {
		try {
			URL u = new URL("http://localhost:4444/wd/hub");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			RemoteWebDriver driver = new RemoteWebDriver(u, cap);
			driver.get("https://www.google.com/");
			System.out.println(driver.getTitle());
			driver.close();
		} catch (Exception e) {
			System.err.println("ERROR: Caught exception! "+e.getMessage());
		}
	}
	
	@AfterTest
	public static void stopDocker() {
		String bat = "dockerDown.bat";
		String text = "selenium-hub exited with";
		
		startStopFile(bat, text);
	}
}
