package stepDefinition;

import java.io.IOException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;

public class Home {
	HomePage objHomePage;
	Hooks objTestBase;
	
	public Home(Hooks objHooks) {
		
		objHomePage = objHooks.getPageObjectManager().getHomePage();
	}
	@Then("^user should be on home page\\.$")
	public void user_should_be_on_home_page(){
		objHomePage.userIsOnHomePage();
	}
	@When("^user clicks on Financial Analysis link$")
	public void user_clicks_on_Financial_Analysis_link() throws IOException, InterruptedException {
		objHomePage.ClickonFinAnaLink();
	}

	@And("^user clicks on Company link$")
	public void user_clicks_on_Company_link() throws IOException {
		objHomePage.ClickonCompanyLink();

	}

	@And("^user clicks on Manage Company link$")
	public void user_clicks_on_Manage_Company_link() throws IOException {
		objHomePage.ClickonManageCompanyLink();

	}
}
