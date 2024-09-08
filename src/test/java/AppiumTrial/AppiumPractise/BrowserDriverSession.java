package AppiumTrial.AppiumPractise;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class BrowserDriverSession {

	public static void main(String[] args) throws Exception {
		/* How to create Appium Driver session with Android Chrome Browser.
		   > We need to create a Driver session if we're going to interact chrome  browser directly a& we need chrome driver to interact with browser
		   > We DON'T need to create driver session in case of HYBROD APP that navigate to WEBVIEW or Chrome Browser. I this case just SWICTH the CONTEXT to WEBVIEW
       
       
       
       
       */
		 AppiumDriver driver= BrowserDriverSession.initializeBrowserDriver("Android");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://tesla.com");  // trying to open this website inside chrome of mobile
		
		
    }

    
    
    
    public static AppiumDriver initializeBrowserDriver(String platformName) throws Exception {                // Here we created method which has argument on whose basis platform will be decided and it would return that platform's driver object.
        DesiredCapabilities caps = new DesiredCapabilities();

       // caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName); //  "MobileCapabilityType" is depricated, so use below line code.
        caps.setCapability(CapabilityType.PLATFORM_NAME, platformName);           // Instead of "MobileCapabilityType", use "CapabilityType" but it works only for PLATFORMNAME only and not for other like 'deviceName"
        caps.setCapability("newCommandTimeout", 300);

        URL url = new URL("http://0.0.0.0:4723/");

        switch (platformName) {
            case "Android":
              //  caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nokia5.4");             //  "MobileCapabilityType" is deprecated from java client v 9.0.0,Instead of this use below line code ie use capability name directly :
            	caps.setCapability("deviceName",  "Nokia5.4");
            	caps.setCapability("automationName", "UiAutomator2");
            	caps.setCapability("udid", "PD21BDD464038424");
                
                caps.setCapability("unlockType", "pin");   // These 2 capabilities are used when you want to unlock your locked phone set with some PIN
                caps.setCapability("unlockKey", "1010");
                
                 // Manual way to add Chrome driver 
                
                caps.setCapability("browserName", "Chrome");   // While using this we'll have to remove "app package,activility" and "location of app" capabilities since we'll deal with only mobile brwoser
    // NOT WORKING coz of path           caps.setCapability("chromedriverExecutable", "E:\\ChromeDriver");     // Capability to add CHROME DRIVER, which is used for WebView screens . Although chrome driver comes along with appium driver bit it might be old version
                return new AndroidDriver(url, caps);

            case "IOS":
            	caps.setCapability("deviceName", "iPhone 12");
            	caps.setCapability("automationName", "XCUITest");
            	caps.setCapability("udid", "PD21BDD464038424");
                
               
                caps.setCapability("simulatorStartuptimeout", 180000);
         
                
                caps.setCapability("browserName", "Safari");  // capability to setup safari driver . You might get "developer need to be verified" . for this go to PREFERENCES> Security & Privacy > Allow apps downloaded from > allow anyway
                return new IOSDriver(url, caps);

            default:
                throw new Exception("Invalid platform. Please check your code");
      
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    

}	
		 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



