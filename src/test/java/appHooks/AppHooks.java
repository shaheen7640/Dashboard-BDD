package appHooks;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.Factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class AppHooks {

	private static DriverFactory driverFactory;
	private static WebDriver driver=null;
	
	@BeforeAll
	public static void launchBrowser() {

		if(driver==null) {
			driverFactory = new DriverFactory();
			driver = driverFactory.initDriver();
		}

	}

	@AfterAll(order = 0)
	public static void quitBrowser() {

		driver.quit();
	}
	//Take the screenShots if test fails
	@After(order =1)
	public void tearDown(Scenario scenario) {

		if(scenario.isFailed()) {

			String screenShotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

			scenario.attach(sourcePath, "image/png", screenShotName);
		}


	}
}