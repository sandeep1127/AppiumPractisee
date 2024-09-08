package AppiumTrial.AppiumPractise;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class RunVirtualDeviceAutomatically {

	public static void main(String[] args) throws MalformedURLException {
		
		
		DesiredCapabilities caps = new DesiredCapabilities();                  // There is another way to set the capabilities which is using "OPTIONS" Class
		caps.setCapability("platformName", "Android");
		caps.setCapability("deviceName", "Pixel 7");
		caps.setCapability("automationName", "UiAutomator2");
		//caps.setCapability("UDID", "emulator-5554");       // Emulator UDID [pixel 7] > You got this from CMD prompt
		caps.setCapability("avd", "Pixel_7");    // This value you get from ANDROID STUDIDO emulator Device Details >avdID
		caps.setCapability("avdLaunchTimeout", 180000); // Default timeout is 60 seconds, we have 3 mins here for AVD to boot up and launch completely
		                                  
		  String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "Resources"  + File.separator + "ApiDemos-debug.apk" ; // Here we are trying to get the This give path till Project folder which is "E:\SandeepJavaWorkspace\PractiseAppium"
		  
		  
	     caps.setCapability("app", appUrl) ;      
		
	      // NOW CREATING DRIVER SEESION
	      URL appiumUrl = new URL("http://0.0.0.0:4723/");  // Here we provide the URL of our APPIUM Server which we will use in below line. (From Appium 2.0 we don't to need to add /wd/hub/ to the URL)
		  AppiumDriver driver = new AppiumDriver(appiumUrl, caps);  // Creating driver session- It gets created using URL of appium server and capabilities we gave.  Here we could also use "AndroidDriver" as well if we're working only for Android device
		//  String sessionId = driver.getSessionId().toString();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
}