package PageFiles;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	
	WebDriver driver;
	String HomeScreenWindowHandle ;
	String ClientAreasScreen_WindowHandle;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		driver.get("https://phptravels.com/demo/");
		PageFactory.initElements(driver,LoginPage.class);
		//or
		//PageFactory.initElements(driver,this)
		//HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	}
	@FindBy(xpath ="//input[@class='marketing-nav__button marketing-button marketing-button--small'][@type='submit'][@value='Login']")
	private WebElement LoginHomeScreenButton;
	
	
	
	public void enterURL()
	{
		driver.get("https://phptravels.com/demo/");
		driver.manage().window().maximize();
	}
	
	public void registerApplication()
	{
		HomeScreenWindowHandle= driver.getWindowHandle();
		LoginHomeScreenButton.click();
		Set<String> windowHandles = driver.getWindowHandles();
		
		boolean clientHandle =false;
		for(String handle:windowHandles)
		{
			if(!handle.equals("HomeScreenWindowHandle"))
			{
				ClientAreasScreen_WindowHandle=handle;
				clientHandle = true;
			}
		}
		
		if(!clientHandle)
		{
			System.out.println("Client Area Screen did not open");
		}
		else
		{
			driver.switchTo().window(ClientAreasScreen_WindowHandle);
		}
		
		
		
	}
	
}
