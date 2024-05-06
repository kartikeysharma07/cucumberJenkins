package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utils.UtilityClass;
public class BecomeAffiliatePage extends Base {
		
	WebDriver driver;
	private UtilityClass util= new UtilityClass();
	
	public BecomeAffiliatePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToHomepage() {
		WebElement homepage=driver.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]"));
		util.waitTime(driver, homepage);
		homepage.click();
		
		String actualTitle=driver.getTitle();
		String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		util.assertPage(actualTitle, expectedTitle);
	}
	
	public void scrollDown() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight*0.80)");
	}
	
	public void affiliateLink() {
		WebElement affiliateButton=driver.findElement(By.linkText("Become an Affiliate"));
		util.waitTime(driver, affiliateButton);
		affiliateButton.click();
				
		WebElement pageText = driver.findElement(By.className("ac-welcome-page-benefits-heading"));
		String actualTitle=pageText.getText();
		
		String expectedTitle="Amazon Associates - Amazon's affiliate marketing program";
		
		util.assertPage(actualTitle, expectedTitle);
		}
	
	public void signUp() {
		WebElement signupButton= driver.findElement(By.id("a-autoid-0-announce"));
		util.waitTime(driver, signupButton);
		signupButton.click();
	}
	
	public void verification() {
		String actualTitle= driver.getTitle();
		System.out.println(actualTitle);
		String notExpectedTitle="Amazon Sign-In";
		
		util.assertPage(actualTitle, notExpectedTitle);
	}
}
