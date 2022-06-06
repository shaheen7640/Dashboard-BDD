package appHooks;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.Factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	
	
	@Before
	public void launchBrowser() {
		
		driverFactory = new DriverFactory();
		driver = driverFactory.initDriver();
		
	}
	
	@After(order = 0)
	public void quitBrowser() {
		
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