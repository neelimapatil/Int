package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.PageObjectManager;
import managers.WebDriverManager;
import utils.Config;


public class Hooks {
	
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	
	@Before(value={"@Regression"})
	public void before(Scenario scene) throws IOException   {
		if(Config.InitStarted==false)
		{
			Config.InitFlags();
			Config.InitStarted = true;
		}
		//Initialize objects of managers
		webDriverManager = new WebDriverManager();//Initialize browser
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		Config.driver=webDriverManager.getDriver();
		//Extent report initialization
	 /*   HTMLReportGenerator.TestSuiteStart(Config.strReportFolderPath , "ejagruti");
		String ScenarioName = scene.getName();
		HTMLReportGenerator.TestCaseStart(ScenarioName, ScenarioName);*/
	}

//returns manager object
		public WebDriverManager getWebDriverManager() 
		{
			return webDriverManager;
		}
		public PageObjectManager getPageObjectManager() {
			return pageObjectManager;
		}
	

@After(value={"@Regression"})
	public void after() throws InterruptedException {
	Thread.sleep(6000);
/*	HTMLReportGenerator.TestCaseEnd();
	HTMLReportGenerator.TestSuiteEnd();*/
    getWebDriverManager().closeDriver();
   	}
@After(value={"@Configuration"})  
public void afterSkip(Scenario scen) {        
   if(scen.isFailed())            
      Config.skipFlag = true;   
}

}