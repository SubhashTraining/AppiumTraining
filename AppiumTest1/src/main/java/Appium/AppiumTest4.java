package Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumTest4 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\Sanjay\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
				.withLogFile(new File("C:\\Users\\Sanjay\\Appium\\eclipse-workspace\\AppiumTest1\\src\\test\\resources\\Logs\\AppiumLogs\\Logs.log"))
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
		
		service.start();			
				
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "65f651f31e00");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("appPackage","in.amazon.mShop.android.shopping");
		dc.setCapability("appActivity","com.amazon.mShop.home.HomeActivity");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		Thread.sleep(6000);
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Continue in English\"]")).click();
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();
		
		Thread.sleep(2000);
		
		
		
				
		
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Deals of the Day\"))"));
		
		
		Wait<AndroidDriver>  wait= new FluentWait(driver)
				.pollingEvery(Duration.ofMillis(300))
				.withTimeout(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class);
				
		MobileElement dealOftheDayELement= wait.until(new Function<AndroidDriver,MobileElement>(){

			@Override
			public MobileElement apply(AndroidDriver t) {
				// TODO Auto-generated method stub
				MobileElement element = driverfindElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"iQOO Z3 Series | India s first SD 768G 5G ₹ 19,990.00 - ₹ 22,990.00\")"));
				System.out.println(element.getAttribute("content-desc"));
				if(element.getAttribute("content-desc").equals("iQOO Z3 Series | India s first SD 768G 5G ₹ 19,990.00 - ₹ 22,990.00"))
					return element;
				else 
					return null;
			}

			private MobileElement driverfindElement(By androidUIAutomator) {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
	
		
		TouchAction actions = new TouchAction(driver);
		actions.press(ElementOption.element(dealOftheDayELement)).release().perform();
		
		
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).flingForward()"));
		
		Thread.sleep(6000);
		
		
		//scrollDown(driver);		
		//scrollUp(driver);		
				
		driver.quit();
		service.stop();
		
	}
	
	
	public static void scrollDown(AndroidDriver<AndroidElement> driver)
	{
		
		Dimension size = driver.manage().window().getSize();
		int center_x = (int) (size.width*0.5);
		int bottom_y = (int) (size.height*0.8);
		
		int top_y=(int) (size.height*0.2);
		
		
		for(int i=1;i<=10;i++) {
			
			AndroidTouchAction action = new AndroidTouchAction(driver);
			action.press(PointOption.point(center_x, bottom_y)).moveTo(PointOption.point(center_x, top_y)).release().perform();
					
		}		
	}
	
	
	public static void scrollUp(AndroidDriver<AndroidElement> driver)
	{
		Dimension size = driver.manage().window().getSize();
		int center= size.width/2;
		int top = 20;
		int bottom = size.height-10;
		for(int i=1;i<=10;i++) {
		
		AndroidTouchAction action = new AndroidTouchAction(driver);
		action.press(PointOption.point(center, top)).moveTo(PointOption.point(center, bottom)).release().perform();
		
		}
	}
	

}



