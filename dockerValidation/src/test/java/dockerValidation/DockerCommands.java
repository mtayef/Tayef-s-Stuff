package dockerValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Calendar;

import org.testng.Assert;

public class DockerCommands {
	
	public static Runtime runtime;
	public static void startStopFile(String bat, String text) {
		try {
			boolean flag = false;
			
			runtime = Runtime.getRuntime();
			//"cmd /c start dockerUp.bat"
			
			runtime.exec("cmd /c start "+bat);
			
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
					//"registered to the hub and ready to use"
					if(currentLine.contains(text)) {
						System.out.println("Found text!");
						flag = true;
						break;
					}
					currentLine = br.readLine();
				}
				br.close();
			}
			
			Assert.assertTrue(flag);
			
		} catch(Exception e) {
			System.err.println("ERROR: Caught an exception!: This is start file section --> "+e.getMessage());
		}
	}
	
	public static void scale() {
		try {
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("cmd /c start scale.bat");
			Thread.sleep(5000);
			System.out.println("Scaled up successfully!");
		} catch(Exception e) {
			System.err.println("ERROR: Caught exception!: This is scale file section -->"+e.getMessage());
		}		
	}
	
	public static void delete(){
		File fi = new File("output.txt");
		boolean delete = fi.delete();
		if(delete) {
			System.out.println("File deleted successfully");
		}
	}	
	
	public static void clsExit() {
		try { 
			runtime = Runtime.getRuntime();
			runtime.exit(0);			
		} catch(Exception e) {
			System.err.println("ERROR: Caught exception!: This is close/exit file section --> "+e.getMessage());
		}
	}
	
	public static void exit() {
		try {
			runtime = Runtime.getRuntime();
			runtime.exec("taskkill /IM cmd.exe");
		} catch (Exception e) {
			System.err.println("ERROR: Caught exception!: "+e.getMessage());
			
		}
	}
}
