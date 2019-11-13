package dockerValidation;

import org.testng.annotations.Test;

public class ScaleFirefox {
	
	@Test
	public void scaleFF() {
		try {
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("cmd /c start ffScale.bat");
			Thread.sleep(15000);
		} catch (Exception e) {
			System.err.println("ERROR: Caught Exception!: "+e.getMessage());
		}
	}
}
