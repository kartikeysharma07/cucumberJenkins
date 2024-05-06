package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.But;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Base;
import pages.BecomeAffiliatePage;
import pages.NewReleasePage;
public class AmazonFeatureSteps extends Base {
	private HookClass hooks=new HookClass();
	private WebDriver driver=hooks.getDriver();
	private NewReleasePage release=new NewReleasePage(driver);
	private BecomeAffiliatePage affiliate=new BecomeAffiliatePage(driver);
	
	
	@Given("user clicks the hamburger icon")
	public void user_clicks_the_hamburger_icon() {
		
		release.clickingHamburger();
	}

	@And("user chooses the option of new sellers")
	public void user_chooses_the_option_of_best_sellers() {
	    release.clickingNewRelease();
	}

	@When("user selectes top item in the hot releases category of clothing and accessories")
	public void user_selectes_top_item_in_the_best_sellers_category_of_clothing_and_accessories() {
	   release.selectingProduct();
	}

	@Then("user add selected products in the cart")
	public void user_add_selected_products_in_the_cart() {
	    release.addToCart();
	}
	
	@But("user should not be on the same product page after adding product to cart")
	public void verification_of_the_page() {
		release.verification();
	}
	
	@Given("user is on the home page")
	public void user_is_on_the_home_page() {
	    
	    affiliate.goToHomepage();
	}

	@When("user scroll down to footer of the page")
	public void user_scroll_down_to_footer_of_the_page() {
	    affiliate.scrollDown();
	}

	@And("clicks on the become an affiliate link present in the Make money with us column")
	public void clicks_on_the_become_an_affiliate_link_present_in_the_make_money_with_us_column() {
	    affiliate.affiliateLink();
	}

	@Then("user clicks on the sign up button")
	public void user_clicks_on_the_sign_up_button() {
	    affiliate.signUp();
	}

	@But("user should not be on the signin page")
	public void user_should_not_be_on_the_signin_page() {
	    affiliate.verification();
	}
}
