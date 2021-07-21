package Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumTest2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		// TODO Auto-generated method stub
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyhhmmss");
		LocalDateTime ldt =  LocalDateTime.now();
		String ldt_String = dtf.format(ldt).toString();
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\Sanjay\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
				.withLogFile(new File("C:\\Users\\Sanjay\\Appium\\eclipse-workspace\\AppiumTest1\\src\\test\\resources\\Logs\\AppiumLogs\\logs_"+ldt_String+".log"))
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
					
		
		service.start();
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "65f651f31e00");
		dc.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.21.0");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		
		
		File apkFile = new File(System.getProperty("user.dir")+File.separator+"amazon.apk");
		//dc.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "in.amazon.mShop.android.shopping");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.amazon.mShop.home.HomeActivity");
		
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Continue in English\"]")).click();
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();;
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("Mobile");
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/search_right_cam_img")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	
		
		
		/* 	
		 	
			driver.pressKey(new KeyEvent(AndroidKey.HOME));
		 	driver.longPressKey(new KeyEvent(AndroidKey.HOME));
			driver.toggleAirplaneMode();
			driver.toggleWifi();
			driver.toggleLocationServices();
			driver.toggleData();
		*/	
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text")).click();
		Actions action = new Actions(driver);
		action.sendKeys("Mobile Phones").perform();
		
		
		
		Thread.sleep(3000);
		
		driver.quit();
		service.stop();
	}

}
