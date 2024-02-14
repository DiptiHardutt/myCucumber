package steps;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.DashboardPage;
import pages.LoginPage;

public class StepDefinetion extends BasePage{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	//make sure you import @Before from cucumber not junit
	@Before
	public void beforeRun() {
		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
	}
	
	@Given("User is on the codefios login page")
	public void user_is_on_the_codefios_login_page() {
	  String url=  getProperty("url");
	  driver.get(url);
	}

	@When("User enters the username as {string}")
	public void user_enters_the_username_as(String string) {
	   loginPage.insertUserName(string);
	}

	@When("User enters the password as {string}")
	public void user_enters_the_password_as(String string) {
		loginPage.insertPassword(string);
	}

	@When("User clicks on sign in button")
	public void user_clicks_on_sign_in_button() {
	    loginPage.clickSubmit();
	}

	@Then("User should be able to land on dashboard page")
	public void user_should_be_able_to_land_on_dashboard_page() {
	   String actualTitle = dashboardPage.getTitle();
		Assert.assertEquals("title doesn't match","Codefios QA", actualTitle);
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
