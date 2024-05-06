package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.But;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Base;
import pages.Login;
import pages.SearchPage;

public class LoginStep extends Base{
	private HookClass hooks=new HookClass();
	private WebDriver driver=hooks.getDriver();
	private Login login=new Login(driver);
	private SearchPage search;
	WebElement passwordBox;
	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
	    login.openLoginPage();
	}

	@When("user enters the {string} and {string}")
	public void user_enters_the_and(String string, String string2) {
		login.enterUserName(string);
		login.enterPassword(string2);
	}
	@Then("user is navigated to login page")
	public void user_is_navigated_to_login_page() {
	   login.validLogin();
	}
	
	@Then("user should not see the signin page again")
	public void user_should_not_see_the_signin_page_again() {
		
		login.verification();
	}
	
	@Given("user enters the {string} in the search bar")
	public void user_enters_the_in_the_search_bar(String string) {
		driver=hooks.getDriver();
		search= new SearchPage(driver);
	    search.searchProduct(string);
	}

	@When("user selectes the first item")
	public void user_selectes_the_first_item() {
	    search.selectProduct();
	}

	@When("user add the product in the cart")
	public void user_add_the_product_in_the_cart() {
	    search.closingTab();
	}

	@Then("cart page is shown")
	public void cart_page_is_shown() {
	    search.goToHomepage();
	}
	@But("user should not be on the cart page")
	public void user_should_not_be_on_the_cart_page() {
		search.verification();
	}
}
