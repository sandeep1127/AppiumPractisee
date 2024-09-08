package AppiumTrial.AppiumPractise;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class AutomaticBrowserDriver {

	
	
	
	public static void main(String[] args) throws Exception {
		/*We'll learn how to set up chrome driver automatically. Also for IOS ie safari browser.
	STEPS :
		1. Start APPIUM server by using the command "appium --allow-insecure chromedriver_autodownload"   : This will autodownload the chromedriver compatible with phone browser and will save it on default location . Example in my case, the default loacation was "C:\Users\schoudhary\.appium\node_modules\appium-uiautomator2-driver\node_modules\appium-chromedriver\chromedriver\win"
         2. Suppose you don't want to save the automatically downloaded ChromeDriver inside Default location and want in custom location. Then use below Capability which will save the driver in your providede location.
         "chromedriverExecutableDir" > This capability makes Appium download the driver in location you provided
         
	*/
		AppiumDriver driver = AutomaticBrowserDriver.initializeAutoDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://tesla.com");
		
		
	}
	
	public static AppiumDriver initializeAutoDriver(String platformName) throws Exception {                // Here we created method which has argument on whose basis platform will be decided and it would return that platform's driver object.
        DesiredCapabilities caps = new DesiredCapabilities();

       // caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName); //  "MobileCapabilityType" is depricated, so use below line code.
        caps.setCapability(CapabilityType.PLATFORM_NAME, platformName);           // Instead of "MobileCapabilityType" use "CapabilityType" but it works only for PLATFORMNAME only and not for other like 'deviceName"
        caps.setCapability("newCommandTimeout", 300);

        URL url = new URL("http://0.0.0.0:4723/");

        switch (platformName) {
            case "Android":
              //  caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nokia5.4");             //  "MobileCapabilityType" is deprecated from java client v 9.0.0,Instead of this use below line code ie use capability name directly :
            	caps.setCapability("deviceName",  "Nokia5.4");
            	caps.setCapability("automationName", "UiAutomator2");
            	caps.setCapability("udid", "PD21BDD464038424");
            

               // String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "Resources" + File.separator + "ApiDemos-debug.apk"; // Here we are trying to give  path till Project folder  which is "E:\SandeepJavaWorkspace\PractiseAppium" + App location

               // caps.setCapability("appPackage", "io.appium.android.apis");
               // caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
                
                caps.setCapability("unlockType", "pin");   // These 2 capabilities are used when you want to unlock your locked phone set with some PIN
                caps.setCapability("unlockKey", "1010");
                
                 
                caps.setCapability("browserName", "Chrome");   // While using this we'll have to remove capabilities "app package","app activity" and "location of app" since we'll deal with only mobile brwoser
                caps.setCapability("chromedriverExecutableDir", "E:\\AppiumChromeDriver");  // This capability will autodownload the Chrome browser driver compatible with you mobile's browser and will save that driver in the location you provide. FYI you'll need to run Appium by command "appium --allow-insecure chromedriver_autodownload"
              
                return new AndroidDriver(url, caps);

            case "IOS":
            	caps.setCapability("deviceName", "iPhone 12");
            	caps.setCapability("automationName", "XCUITest");
            	caps.setCapability("udid", "PD21BDD464038424");
                
                String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "Resources" + File.separator + "ApiDemos-debug.apk";
                caps.setCapability("simulatorStartuptimeout", 180000);
                caps.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
                
                
                caps.setCapability("browserName", "Safari");
                return new IOSDriver(url, caps);

            default:
                throw new Exception("Invalid platform. Please check your code");
        }
    }
}