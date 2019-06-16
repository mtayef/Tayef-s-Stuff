package dockerValidation;

import org.testng.annotations.Test;

public class Clear {
	
	@Test
	public static void clear() {
		try {
		Runtime r = Runtime.getRuntime();
		r.exec("cmd /c start checkDocker.bat");
		
		} catch(Exception e) {
			System.err.println("ERROR: Caught Exception "+e.getMessage());
		}
	}
}
