package Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class AppiumTest5 {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub

		
		
		AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
		//Tell Appium Where node is installed
		appiumServiceBuilder.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"));
		appiumServiceBuilder.withAppiumJS(new File("C:\\Users\\Sanjay\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"));
				
		appiumServiceBuilder.withLogFile(new File("C:\\Users\\Sanjay\\Appium\\eclipse-workspace\\AppiumTest1\\src\\test\\resources\\Logs\\AppiumLogs\\Logs.txt"));
		//appiumServiceBuilder.usingAnyFreePort();
		/* The XCUITest driver requires that a path to the Carthage binary is in the PATH variable. I have this set for my shell, but the Java process does not see it. It can be inserted here.
		HashMap<String,String> environment = new HashMap<>();
		environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
		serviceBuilder.withEnvironment(environment)
		*/
		
		AppiumDriverLocalService server=null;
		AndroidDriver<AndroidElement> driver=null;
		try {
			server	 = AppiumDriverLocalService.buildService(appiumServiceBuilder);
			server.start();
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "65f651f31e00");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "uiAutomator2");
		dc.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		dc.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		dc.setCapability("newCommandTimeout", 300);
		
		driver= new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Continue in English\"]")).click();
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();
		
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Deals of the Day\"))");
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//*[@content-desc='Learn from Home | Handpicked Desktop Computers | Upto 50000 Off ₹ 13,499.00 - ₹ 2,19,990.00']")));
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//*[@content-desc='Learn from Home | Handpicked Desktop Computers | Upto 50000 Off ₹ 13,499.00 - ₹ 2,19,990.00']"))).click();
		
		
		
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Lenovo IdeaCentre 3 Desktop (10th Gen\"))").click();;
		
		
		
		
		WebElement element = driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"bylineInfo\")");
		String brandName = element.getAttribute("content-desc");
		System.out.println(brandName.equals("Visit the Lenovo Store"));
		
			
		
		swipe("right",driver);
		Thread.sleep(1000);
		swipe("right",driver);
		Thread.sleep(1000);
		swipe("right",driver);
		Thread.sleep(4000);
		if(driver!=null)driver.quit();
		
		Thread.sleep(4000);
		}catch(Exception e) {e.printStackTrace();}
		finally {
			if(server!=null)server.stop();
			
		}
		
		
		
	}
	
	public static void swipe(String direction,AndroidDriver<AndroidElement> driver)
	{
		
		int edgeBorder=40;
		Dimension dims = driver.manage().window().getSize();
		PointOption startPoint, endPoint;
		switch(direction)
		{
		
		case "right":
		{
			 startPoint = PointOption.point(edgeBorder,dims.height/2);
			 endPoint = PointOption.point(dims.width-edgeBorder, dims.height/2);
			
			break;
		}
		default:
			startPoint = PointOption.point(edgeBorder,dims.height/2);
			 endPoint = PointOption.point(dims.width-edgeBorder, dims.height/2);
			
			break;
			
		
		}
		
		new TouchAction(driver).press(startPoint).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.moveTo(endPoint).release().perform();
			
					
		}
		
		
	}
		
	
	


