package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

import utils.Config;
import utils.Results;
import utils.Screenshot;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
		 }
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'LOGOUT')]") 
	private WebElement lnk_logout;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Financial Analysis')]/parent::div") 
	private WebElement lnk_FinAnalysis;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Financial Analysis')]/following-sibling::div") 
	private WebElement lnk_FinAnalysis_Sibling;
	@FindBy(how = How.XPATH, using = "//*[@id='_easyui_tree_1']//child::span[1]") 
	private WebElement lnk_Company;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Manage Company')]") 
	private WebElement lnk_ManageCompany;
	
	public void userIsOnHomePage() {
			Assert.assertEquals(true, lnk_logout.isDisplayed());
		}

	public void ClickonFinAnaLink() throws IOException, InterruptedException
	{
		Results objResults=new Results(driver);
		Thread.sleep(4000);
		try
		{
		// String strReadValue=objLogin.GetParameterValue_again("OBJ_FINANCIAL_ANALYSIS_LINK", "OR.properties");
		
			String strVar = lnk_FinAnalysis.getAttribute("class");
				if (strVar.contains("selected"))
			{
				;
			}	
			else
			{
			
				lnk_FinAnalysis_Sibling.click();
			}
			Config.strOp= "Status:=PASS,Method:=ClickonFinAnaLink,Parmeters:=,Note:Able to click on financial analysis link";
/*			Config.logger.info(Config.strOp);
			Screenshot.CaptureScreenshot(Config.strScreenShotFolderPath, "ClickonFinAnaLink",this.driver);
			HTMLReportGenerator.StepDetails("PASS", "ClickonFinAnaLink", "Successfully clicked on financial analysis link", Config.strScreenShotFileName);	*/
			objResults.setLogRep(Config.strOp, "PASS", "ClickonFinAnaLink", "Note:Able to click on financial analysis link");
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			Config.strOp= "Status:=FAIL,Method:=ClickonFinAnaLink,Parmeters:=,Note:Unable to click on financial analysis link";
	/*		Config.logger.info(Config.strOp);
			Screenshot.CaptureScreenshot(Config.strScreenShotFolderPath, "ClickonFinAnaLink",this.driver);
			HTMLReportGenerator.StepDetails("FAIL", "ClickonFinAnaLink", "Failed clicked on financial analysis link", Config.strScreenShotFileName);*/
			objResults.setLogRep(Config.strOp, "FAIL", "ClickonFinAnaLink", "Failed to click on financial analysis link");
		}
	}

	public void ClickonCompanyLink() throws IOException
	{
		Results objResults=new Results(driver);
		try
		{
	    //	String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_LINK", "OR.properties");
	    //	WebElement objLink=ExplicitWait.WaitForObjectExist(strReadValue);
	    	String strVar = lnk_Company.getAttribute("class");
	    	if (strVar.contains("expanded"))
	    	{
	    		;
	    	}	
	    	else
	    	{
	    		//objLink=ExplicitWait.WaitForObjectExist(strReadValue);//("//*[@id='_easyui_tree_1']//child::span[1]");
	    		lnk_Company.click();
	    	}
			Config.strOp= "Status:=PASS,Method:=ClickonCompanyLink,Parmeters:=,Note:Able to click on Company link";
/*			Config.logger.info(Config.strOp);
			Screenshot.CaptureScreenshot(Config.strScreenShotFolderPath, "ClickonCompanyLink",this.driver);
			HTMLReportGenerator.StepDetails("PASS", "ClickonCompanyLink", "Successfully clicked on Company link", Config.strScreenShotFileName);*/
			objResults.setLogRep(Config.strOp, "PASS", "ClickonCompanyLink", "Able to click on Company link");
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			Config.strOp= "Status:=FAIL,Method:=ClickonCompanyLink,Parmeters:=,Note:Unable to click on financial analysis link";
/*			Config.logger.info(Config.strOp);
			Screenshot.CaptureScreenshot(Config.strScreenShotFolderPath, "ClickonCompanyLink",this.driver);
			HTMLReportGenerator.StepDetails("FAIL", "ClickonCompanyLink", "Failed to click on financial analysis link", Config.strScreenShotFileName);
		*/
			objResults.setLogRep(Config.strOp, "FAIL", "ClickonCompanyLink", "Failed to click on Company link");
		}
	}

	public void ClickonManageCompanyLink() throws IOException
	{
		Results objResults=new Results(driver);
		try
		{
		//	String strReadValue=objLogin.GetParameterValue_again("OBJ_MANAGE_COMPANY_LINK", "OR.properties");
		//	WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));
			lnk_ManageCompany.click();
			Config.strOp= "Status:=PASS,Method:=ClickonManageCompanyLink,Parmeters:=,Note:Able to click on manage company link";
		/*	Config.logger.info(Config.strOp);
			Screenshot.CaptureScreenshot(Config.strScreenShotFolderPath, "ClickonManageCompanyLink",this.driver);
			HTMLReportGenerator.StepDetails("PASS", "ClickonManageCompanyLink", "Successfully clicked on manage company link", Config.strScreenShotFileName);
		*/
			objResults.setLogRep(Config.strOp, "PASS", "ClickonManageCompanyLink", "Able to click on manage company link");
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			Config.strOp= "Status:=FAIL,Method:=ClickonManageCompanyLink,Parmeters:=,Note:Unable to click on manage company link";
/*			Config.logger.info(Config.strOp);
			Screenshot.CaptureScreenshot(Config.strScreenShotFolderPath, "ClickonManageCompanyLink",this.driver);
			HTMLReportGenerator.StepDetails("FAIL", "ClickonManageCompanyLink", "Failed to click on manage company link", Config.strScreenShotFileName);
		*/
			objResults.setLogRep(Config.strOp, "FAIL", "ClickonManageCompanyLink", "Unable to click on manage company link");
		}
	}

}
