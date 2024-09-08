package AppiumTrial.AppiumPractise;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class UsingAppPackageAppActivity {

public static void main(String[] args) throws MalformedURLException {
		
		
		
		
		DesiredCapabilities caps = new DesiredCapabilities();                  // There is another way to set the capabilities which is using "OPTIONS" Class
		caps.setCapability("platformName", "Android");
		caps.setCapability("deviceName", "Nokia5.4");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("UDID", "PD21BDD464038424");
	    caps.setCapability("appPackage", "io.appium.android.apis");
	    caps.setCapability("appActivity", "io.appium.android.apis.nfc.ForegroundNdefPush");
		                                  
	    
	    // W EWON"T USE below 2 lines of code since we are not asking APPIUM to install the app from location.
	//String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "Resources"  + File.separator + "ApiDemos-debug.apk" ; // Here we are giving path of location where our app is available. This give path till Project folder which is "E:\SandeepJavaWorkspace\PractiseAppium"	    
	// caps.setCapability("app", appUrl) ;  // WON"T USE THIS AS WE DON"T WANT TO INSTALL THE APPLICATION     // here we give the location of App which we want appium to install in our device automatcially . If we have APPILICATION already available in our device, we use different capabilites which are APP PACKAGE and APP ACTIVITY
          
	    // IOS can use the location format "E:\SandeepJavaWorkspace\PractiseAppium\src\main\Resources\ApiDemos-debug.apk" but ANDROID won't because of slashes "/", thats why we use FILE SEPARATOR so that Both platform can use same code. basically Filter.Separatoer means "/"
		
	 
	 
	 
	   // NOW CREATING DRIVER SEESION
	      URL appiumUrl = new URL("http://0.0.0.0:4723/");  // Here we provide the URL of our APPIUM Server which we will use in below line. (From Appium 2.0 we don't to need to add /wd/hub/ to the URL)
		  AppiumDriver driver = new AppiumDriver(appiumUrl, caps);  // Creating driver session- It gets created using URL of appium server and capabilities we gave.  Here we could also use "AndroidDriver" as well if we're working only for Android device
		//  String sessionId = driver.getSessionId().toString();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}