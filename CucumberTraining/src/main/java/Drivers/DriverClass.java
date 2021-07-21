package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverClass {
	
	protected WebDriver driver;
	
	public static DriverClass DriverClassObject;
	
	
	public static DriverClass getInstanceOf()
	{
		if(DriverClassObject==null)
		{
			DriverClassObject= new DriverClass();
		}
		
		return DriverClassObject;
	}
	
	public WebDriver getDriver()
	{
		if (driver==null) 
		{
			System.setProperty("webdriver.gecko.driver","drivers//geckodriver.exe");
			driver=new FirefoxDriver() ;
		}
		return driver;
	}
	
	
	public void closeDriver()
	{
		driver.close();
	}
	
	public void quit()
	{
		driver.quit();
	}
}
