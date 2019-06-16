package dockerValidation;

import org.testng.annotations.Test;

public class TestDocker extends DockerCommands {

	@Test
	public static void dockerTest() {

		// please select --> //"bat file name"

		String bat = "dockerDown.bat";

		//String text = "registered to the hub and ready to use";
		String text = "selenium-hub exited with";

		startStopFile(bat, text);
		//scale();
	}
}
