package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ManageCompanyPage;

	public class PageObjectManager{

		private WebDriver driver;
		private HomePage objHomePage;
		private LoginPage objLoginPage;
		private ManageCompanyPage objManageCompanyPage;

		public PageObjectManager(WebDriver driver) {

			this.driver = driver;

		}
		public HomePage getHomePage(){

			return (objHomePage == null) ? objHomePage = new HomePage(driver) : objHomePage;

		}
		public LoginPage getLoginPage(){

			return (objLoginPage == null) ? objLoginPage = new LoginPage(driver) : objLoginPage;

		}
		public ManageCompanyPage getManageCompanyPage(){

			
			return (objManageCompanyPage == null) ? objManageCompanyPage = new ManageCompanyPage(driver) : objManageCompanyPage;

		}
		
		}

