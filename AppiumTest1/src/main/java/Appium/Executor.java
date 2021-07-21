package Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;
import com.sun.glass.ui.View.Capability;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Executor {
	
	 public static AndroidDriver driver;
	

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
			
			
			
			//capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"in.amazon.mShop.android.shopping");
			//capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.amazon.mShop.home.HomeActivity");
				
			
			//Start Appium Server Programatically
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyhhmmss");
			LocalDateTime ldt =  LocalDateTime.now();
			String ldt_String = dtf.format(ldt).toString();
			
			AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
					.withAppiumJS(new File("C:\\Users\\Sanjay\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
					.withLogFile(new File("C:\\Users\\Sanjay\\Appium\\eclipse-workspace\\AppiumTest1\\src\\test\\resources\\Logs\\AppiumLogs\\logs_"+ldt_String+".log"))
					.withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
			
			service.start();
		
			Thread.sleep(5000);
		
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "65f651f31e00");
			dc.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.21.0");
			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		
			
			dc.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
			dc.setCapability("chromedriverExecutable",System.getProperty("user.dir")+File.separator+"Drivers"+File.separator+"chromedriver.exe");	
			//capability.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
			 ChromeOptions chromeOptions = new ChromeOptions();
	         chromeOptions.setExperimentalOption("w3c", false);
	         dc.merge(chromeOptions);
	         
	         
	         
			AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get("https://www.amazon.in");
			driver.findElement(By.xpath("//input[@class='nav-input nav-progressive-attribute']")).sendKeys("Mobiles");
			driver.findElement(By.xpath("//input[@type='submit'][@class='nav-input']")).click();
			driver.quit();
			
			
			service.start();
			
			
			DesiredCapabilities dc1 = new DesiredCapabilities(); 
			File apkFile = new File(System.getProperty("user.dir")+File.separator+"amazon.apk");	
			//dc1.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
			//to work on capabilty type specific to Android we need to specify that AndroidMobileCapabilityType
			
			dc1.setCapability(AndroidMobileCapabilityType.APP_PACKAGE ,"in.amazon.mShop.android.shopping");
			dc1.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.amazon.mShop.home.HomeActivity");
			
			
			AndroidDriver<AndroidElement> driver1 = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc1);
			driver1.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			
			
			driver1.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Continue in English\"]")).click();
			driver1.findElement(By.id("in.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();;
			
			driver1.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("Mobile");
			
			driver1.findElement(By.id("in.amazon.mShop.android.shopping:id/search_right_cam_img")).click();
			
			Thread.sleep(3000);
			
			
			
			
			driver.quit();
			service.stop();
			
			
	}

}
