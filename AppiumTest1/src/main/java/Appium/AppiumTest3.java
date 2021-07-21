package Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class AppiumTest3 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		AppiumDriverLocalService  service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
											.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
											.withAppiumJS(new File("C:\\Users\\Sanjay\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
											.withLogFile(new File("C:\\Users\\Sanjay\\Appium\\eclipse-workspace\\AppiumTest1\\src\\test\\resources\\Logs\\AppiumLogs\\Logs.log"))
											.withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
		
		service.start();
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName","65f651f31e00");
		dc.setCapability("platformName","Android");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("appPackage","in.amazon.mShop.android.shopping");
		dc.setCapability("appActivity","com.amazon.mShop.home.HomeActivity");
		
		//AppiumDriver<AndroidElement> driver = new AppiumDriver<AndroidElement>(new URL("https://137.0.0.1:4723/wd/hub"),dc);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Continue in English\"]")).click();
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();;
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("Mobile");
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/search_right_cam_img")).click();
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	
		
		
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text")).click();
		Actions action = new Actions(driver);
		action.sendKeys("Mobile Phones").perform();
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		
		//Using Mobile By
		driver.findElement(MobileBy.id("in.amazon.mShop.android.shopping:id/glow_subnav_label")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		
		AndroidElement element= driver.findElement(By.xpath("//android.view.View[@content-desc='Fresh Fresh']"));
		System.out.println(element.getAttribute("enabled"));
		element.click();
		Thread.sleep(3000);
		driver.quit();
		
		
		dc.setCapability("appPackage","com.google.android.dialer");
		dc.setCapability("appActivity","com.google.android.dialer.extensions.GoogleDialtactsActivity");
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		
		Thread.sleep(1000);
		driver.findElement(By.id("com.google.android.dialer:id/dialpad_fab")).click();
		Thread.sleep(1000);
			
		//AndroidElement dialerFrame = driver.findElement(By.className("android.widget.FrameLayout"));
		String phoneNumber ="9790594970";
		String[] numbersText = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		
		
		for(int i=0;i<=9;i++)
		{
			
			char digit = phoneNumber.charAt(i);
			int digitInt = Integer.parseInt(Character.toString(digit));
			System.out.println("com.google.android.dialer:id/"+numbersText[digitInt]);
			driver.findElement(By.id("com.google.android.dialer:id/"+numbersText[digitInt])).click();
			Thread.sleep(500);
			
		}
		
		//click Call button
		//driver.findElement(By.id("com.google.android.dialer:id/dialpad_voice_call_button")).click();
		
		AndroidElement clearDiallerDigits = driver.findElement(By.id("com.google.android.dialer:id/deleteButton"));
		
		AndroidTouchAction touchAction = new AndroidTouchAction(driver);
		touchAction.press( ElementOption.element(clearDiallerDigits)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(ElementOption.element(element));
		
		
		
		touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(clearDiallerDigits)))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).release().perform();
		
		/*
		
		AndroidTouchAction touchAction2 = new AndroidTouchAction(driver)
				.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(clearDiallerDigits)))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).perform();
		
		*/
		
		AndroidElement diapPadView = driver.findElement(By.id("com.google.android.dialer:id/dialpad_view"));
		for(int i=0;i<=9;i++)
		{
			
			char digit = phoneNumber.charAt(i);
			int digitInt = Integer.parseInt(Character.toString(digit));
			System.out.println("com.google.android.dialer:id/"+numbersText[digitInt]);
			diapPadView.findElement(By.id("com.google.android.dialer:id/"+numbersText[digitInt])).click();
			Thread.sleep(500);
			
		}
		//driver.findElement(By.id("com.google.android.dialer:id/dialpad_voice_call_button")).click();
		
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//driver.longPressKey(new KeyEvent(AndroidKey.FORWARD));
		
		TouchAction action1 = new TouchAction(driver);
		action1.tap(PointOption.point(243,11)).perform();
		action1.tap(TapOptions.tapOptions().withElement(ElementOption.element(driver.findElement(By.id("com.google.android.dialer:id/dialpad_voice_call_button"))))).perform();
		
		
		
		driver.quit();
		service.stop();
		
	}

}
