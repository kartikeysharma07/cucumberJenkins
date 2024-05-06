package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utils.UtilityClass;
import org.testng.Assert;
public class NewReleasePage extends Base {
	
	private UtilityClass util= new UtilityClass();
	
	public NewReleasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickingHamburger() {
		WebElement hamburgerIcon= driver.findElement(By.id("nav-hamburger-menu"));
		util.waitTime(driver, hamburgerIcon);
		hamburgerIcon.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void clickingNewRelease() {
		WebElement newRelease=driver.findElement(By.linkText("New Releases"));
		util.waitTime(driver, newRelease);
		newRelease.click();
		
		WebElement pageHeading=driver.findElement(By.xpath("//*[@id=\"zg_banner_text\"]"));
		String actualTitle=pageHeading.getText();
		String expectedTitle="Amazon Hot New Releases";
		
		util.assertPage(actualTitle, expectedTitle);
	}
	
	public void selectingProduct() {
		WebElement newreleaseItem= driver.findElement(By.xpath("//*[@id=\"B0CTQB592W\"]/a[2]/span/div"));
		util.waitTime(driver, newreleaseItem);
		newreleaseItem.click();
	}
	public void addToCart() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"dealsx_atc_btn\"]/span/a"));
		util.waitTime(driver, addToCartButton);
	    addToCartButton.click();
	}
	public void verification() {
		String actualTitle=driver.getTitle();
		String expectedTitle="Amazon Sign In";
		util.assertPage(actualTitle, expectedTitle);
	}
}
