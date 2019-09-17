package stepDefinition;


import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.JsonDataReader;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testDataTypes.Users;
import utils.Config;

public class Login{
	
	LoginPage objLoginPage;
	HomePage objHomePage;
	WebDriverManager webDriverManager;
	PageObjectManager pageObjectManager;
	public Login(Hooks objHooks) {
		
		
		objLoginPage = objHooks.getPageObjectManager().getLoginPage();
		objHomePage = objHooks.getPageObjectManager().getHomePage();
	}
	
	@Given("^User is on Login Page$")

	public void userIsOnLoginPage()

	{

		objLoginPage.navigateToLoginPage(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());

	}

	@When("^user login with username and password with data from json file (\\d+)$")
	public void user_login_with_username_and_password_with_data_from_json_file(int intIndex) throws Throwable {
	
		
		Object objUsers1=JsonDataReader.getJsonData("src/test/resources/testData/Users.json","Users");
		Users[] objUsers= (Users[])objUsers1;
		String strUserName = objUsers[intIndex].username;
		String strPassword = objUsers[intIndex].password;
		String strRole = objUsers[intIndex].userrole;
		
        objLoginPage.doUserLoginByRole(strUserName,strPassword,strRole);
		if(objUsers[intIndex].status.equalsIgnoreCase("valid"))
		{
			objHomePage.userIsOnHomePage();	
		}
		else
		{
			objLoginPage.verifyLoginErrorMessage(objUsers[intIndex].errormessage);
		}
	}
	
	@Then("^do nothing$")
	public void do_nothing()
	{
		//driver.close();
		Config.driver.quit();
	}
	
	@When("^user login with \"([^\"]*)\" username and password with data from json file (\\d+)$")
	public void user_login_with_username_and_password_with_data_from_json_file(String strStatus, int intIndex) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Object objUsers1=JsonDataReader.getJsonData("src/test/resources/testData/Users.json","Users");
		Users[] objUsers= (Users[])objUsers1;
		
		String strUserName = objUsers[intIndex].username;
		String strPassword = objUsers[intIndex].password;
		String strRole = objUsers[intIndex].userrole;
		String strValid = objUsers[intIndex].status;
		if(strValid.equalsIgnoreCase(strStatus))
		{
			objLoginPage.doUserLoginByRole(strUserName,strPassword,strRole);	
		}
		else
		{
			Assert.assertFalse("Expected condition not met", true);
		}
            
	}
	@Then("^user should display error message$")
	public void userLoginErrorMessage()
	{
		objLoginPage.verifyLoginErrorMessage("Please Enter Valid Username or Password!!!");
	}
	@When("^user login with \"([^\"]*)\" and \"([^\"]*)\" with data from json file$")
	public void userlogin(String strUserName, String strPassword)
			{
			objLoginPage.doUserLoginByRole(strUserName,strPassword,"fm");	
			}
}
