package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.When;

public class Login_chrome{
	
	WebDriver driver;

	
	@When("^user login with \"([^\"]*)\" and \"([^\"]*)\"$")

	public void userIsOnLoginPage1(String strUserName, String strPassword) throws Exception

	{
        System.setProperty("webdriver.chrome.driver","E:/selenium/DRIVERS/chromedriver_forversion75.exe");
        driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver","E:/selenium/DRIVERS/geckodriver_64bit_v0.20.1_for_firefox_59.0.2.exe");
       // driver = new FirefoxDriver();
        driver.get("http://localhost:90/finsys");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(strUserName);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(strPassword);
        driver.findElement(By.xpath("//*[.='Login']")).click();
        Thread.sleep(10000);
        driver.quit();
	}
}

