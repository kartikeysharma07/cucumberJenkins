package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.Base;

public class HookClass extends Base {
	@Before
	public void  Driver() {
		driver= new ChromeDriver();
	    driver.get("https://www.amazon.in");
	    driver.manage().window().maximize();
	    
	}
	public WebDriver getDriver() {
		return driver;
	}
	@After
	public void tearDown() {
		driver.quit();
	}
}
