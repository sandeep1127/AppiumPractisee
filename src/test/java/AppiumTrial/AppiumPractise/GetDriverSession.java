package AppiumTrial.AppiumPractise;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class GetDriverSession {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();                  
		caps.setCapability("platformName", "Android");
		caps.setCapability("deviceName", "Nokia5.4");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("UDID", "PD21BDD464038424");
		caps.setCapability("newCommandTimeout", "900000");  // By default, it is 60 seconds . For how much time appium should wait till it quits the session if there is no command from user
		
		                                  
		  String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "Resources"  + File.separator + "ApiDemos-debug.apk" ; // Here we are trying to get the This give path till Project folder which is "E:\SandeepJavaWorkspace\PractiseAppium"
		  
		  
	 caps.setCapability("app", appUrl) ;       
	  URL appiumUrl = new URL("http://0.0.0.0:4723/"); 
	
	  //CREATING DRIVER SEESION
	       
		 AppiumDriver driver = new AppiumDriver(appiumUrl, caps);  
		 System.out.println("session id is : " + driver.getSessionId());
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
	}

}
