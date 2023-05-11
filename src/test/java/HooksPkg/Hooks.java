package HooksPkg;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driverFactory.DriverSetUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	@Before(order = 0)
	public static void setUp() {
		DriverSetUp.setUpDriver();
		utils.LoggerLoad.info("driver setup");
	}

	@Before(order = 1)
	public static void setup2() {
		DriverSetUp.getDriver();
		utils.LoggerLoad.info("getdriver");
	}

	@After
	public static void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) DriverSetUp.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}

		// driversetup.tearDown();
	}

}
