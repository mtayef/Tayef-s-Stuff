package dockerValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StopDocker {
	
	@Test
	public static void startFile() {
		try {
			boolean flag = false;
			
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("cmd /c start dockerDown.bat");
			
			String file = "output.txt";
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.SECOND, 45);
			long stop = cal.getTimeInMillis();
			Thread.sleep(3000);
			
			while(System.currentTimeMillis()<stop) {
				
				if(flag) {
					break;
				}
				
				BufferedReader br = new BufferedReader(new FileReader(file));
				String currentLine = br.readLine();
	
				while(currentLine != null && !flag) {
					if(currentLine.contains("selenium-hub exited with code")) {
						System.out.println("Found text!");
						flag = true;
						break;
					}
					currentLine = br.readLine();
				}
				br.close();
			}
			
			Assert.assertTrue(flag);
			File f = new File(file);
			f.delete();
			Thread.sleep(15000);
		} catch(Exception e) {
			System.err.println("ERROR: Caught an exception! "+e.getMessage());
		}
	}
}
