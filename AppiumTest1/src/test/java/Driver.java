import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Driver {

	
	public static AppiumDriver<AndroidElement> driver;
	
	
	@BeforeClass
	public static AppiumDriver<AndroidElement> initialize_driver () throws MalformedURLException
	{
		
		DesiredCapabilities capability = new DesiredCapabilities();
		
		
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"in.amazon.mShop.android.shopping");
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.amazon.mShop.home.HomeActivity");
		
		driver= new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capability);
		return driver;
	}
	
	@Test
	public void skipLogin()
	{

		driver.findElement(By.className("android.widget.ImageView")).click();
		System.out.println("Image Clicked");
		
	}
	
	
	
}
