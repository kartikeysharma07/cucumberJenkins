package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.UtilityClass;

public class Login extends Base {
	
	private UtilityClass util= new UtilityClass();
	WebElement passwordBox;
	public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openLoginPage() {
		WebElement signinButton= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		util.waitTime(driver, signinButton);
		signinButton.click();
	}
	
	public void enterUserName(String username) {
		WebElement email=driver.findElement(By.id("ap_email"));
		util.waitTime(driver, email);
		email.sendKeys(username);
		email.submit();
	}
	
	public void enterPassword(String password) {
		passwordBox=driver.findElement(By.id("ap_password"));
		util.waitTime(driver, passwordBox);
		passwordBox.sendKeys(password);
	}
	
	public void validLogin() {
		util.waitTime(driver, passwordBox);
		passwordBox.submit();
	}
	
	public void verification() {
		String actualTitle=driver.getTitle();
		String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		
		Assert.assertEquals(actualTitle, expectedTitle,"Invalid Signin operation performed");
	}
}
