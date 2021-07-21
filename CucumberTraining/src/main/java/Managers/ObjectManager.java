package Managers;

import org.openqa.selenium.WebDriver;

import PageFiles.LoginPage;

public class ObjectManager {
	
	public static ObjectManager ObjectManager ;
	protected LoginPage loginpageObject;
	
	private ObjectManager()
	{}
	
	public static ObjectManager getInstanceOf(){
	return (ObjectManager==null) ?  new ObjectManager() :  ObjectManager;
	}
	
	public LoginPage getLoginObject(WebDriver driver){
	return (loginpageObject==null) ? new LoginPage(driver): loginpageObject;
			
	}
	
	
}
