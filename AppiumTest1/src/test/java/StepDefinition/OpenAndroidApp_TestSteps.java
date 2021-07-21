package StepDefinition;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class OpenAndroidApp_TestSteps {
	 public static AndroidDriver driver;
	 

@Given("^User has set all desired capabilities for AndroidAPP$")
public void user_has_set_all_desired_capabilities_for_AndroidAPP() throws Throwable {
	DesiredCapabilities capability = new  DesiredCapabilities();
	capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
	capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"in.amazon.mShop.android.shopping");
	capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.amazon.mShop.home.HomeActivity");
	//capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.amazon.micron.SignInPromptActivity");
	driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capability);
   
  
}

@When("^User wants to open Amazon App$")
public void user_wants_to_open_Amazon_App() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   
}

@Then("^Amazon App Opens with the sign in page$")
public void amazon_App_Opens_with_the_sign_in_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  
}
}
