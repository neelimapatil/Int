package utils;
import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public static void CaptureScreenshot(String strRootFolderPath,String strMethodName,WebDriver driver)
	{
		// Take screenshot and store as a file format;
		//File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//TakesScreenshot is an interface
		
		 TakesScreenshot ts = (TakesScreenshot) driver;
		 
		 File src = ts.getScreenshotAs(OutputType.FILE);
		try {

		//return newFileNamePath;
		
			String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.png'").format(new Date());
		File Dest = new File(strRootFolderPath+strMethodName+filename);
					 // now copy the  screenshot to desired location using copyFile //method			
		FileUtils.copyFile(src, Dest);
		Config.strScreenShotFileName=Dest.getPath();
		}
		 
		catch (IOException e)
		 {
		  System.out.println(e.getMessage());
		 }
	}

}
