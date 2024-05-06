package pages;


import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.UtilityClass;

public class SearchPage extends Base{
	private UtilityClass util= new UtilityClass();
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginPage() {
		WebElement signinButton= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		util.waitTime(driver, signinButton);
		signinButton.click();
	}
	
	public void searchProduct(String product) {
		WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
		util.waitTime(driver, searchBox);
		searchBox.sendKeys(product);
		searchBox.submit();
		
		String actualTitle= driver.getTitle();
		String expectedTitle=product;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Assert.assertTrue(actualTitle.contains(expectedTitle));
	}
	
	public void selectProduct() {
		WebElement textInput = driver.findElement(By.cssSelector("a.a-link-normal.s-no-outline"));
		util.waitTime(driver, textInput);
		textInput.click();
	}
	
	public void closingTab() {
		ArrayList<String> switchTabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(switchTabs.get(1));
		
		WebElement body= driver.findElement(By.tagName("body"));
		util.waitTime(driver, body);
		driver.close();
		driver.switchTo().window(switchTabs.get(0));
	}
	
	public void goToHomepage() {
		WebElement cart= driver.findElement(By.id("nav-cart"));
		util.waitTime(driver, cart);
		cart.click();
		
		String actualTitle=driver.getTitle();
		String expectedTitle="Shopping Cart";
		Assert.assertTrue(actualTitle.contains(expectedTitle));
		
		WebElement goToHomepage= driver.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]"));
		util.waitTime(driver, goToHomepage);
		goToHomepage.click();
	}
	
	public void verification() {
		String actualTitle=driver.getTitle();
		String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		
		util.assertPage(actualTitle, expectedTitle);
	}
}
