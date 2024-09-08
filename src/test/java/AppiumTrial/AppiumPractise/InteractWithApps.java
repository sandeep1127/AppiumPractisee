package AppiumTrial.AppiumPractise;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;



public class InteractWithApps {
	
	static String packageName = "io.appium.android.apis";   // Package name of our demo app.

	public static void main(String[] args) throws Exception {
		AppiumDriver driver = BetterDriverSession.initializeDriver("Android");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		//By views = AppiumBy.accessibilityId("Views");
		//driver.findElement(views).click();

		
		// using Methods -- Just use any single method at a time
//		terminateApp(driver);
	//	installApp(driver);
//		IfAppInstalled(driver);
	//	installAppIfNotInstalled(driver);
	holdAppForSometime(driver);
//		activateAnotherApp(driver);
//		statusOfApp(driver);
	//	removeApp(driver);
		
    Thread.sleep(5000);
	}
    
	
	
	// TERMINATE APP method -- This will not kill the app but will STOP the app and will move the app to the background
    public static void terminateApp(AppiumDriver driver) {
    	
			// Please cast all the APP RELATED COMMANDS with ANDROIDDRIVER

     ((AndroidDriver) driver).terminateApp("io.appium.android.apis") ;    // Put bundleID/App package in bracket here	


    }
    	
    
  

    
	// INSTALL APP  : To install any app
    
    public static void installApp(AppiumDriver driver) {    // used argument coz want to use Driver
   
    	
		String myAndAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "Resources" + File.separator + "ApiDemos-debug.apk";
		
		
		((AndroidDriver) driver).installApp(myAndAppUrl, new AndroidInstallApplicationOptions().withReplaceEnabled());   // This method withReplaceEnabled will allow to replace app with upgrades and you'll see message on your device about "app replaced"


    }
		
 // To check if APP is INSTALLED  
    
public static void IfAppInstalled(AppiumDriver driver) { 
    	
    	((AndroidDriver) driver).isAppInstalled(packageName)  ;    // To check if this PACKAGE/APP is installed. It will return boolean value
    	
    
}
		
    // Install App only if APP is not already installed:
    
    public static void installAppIfNotInstalled(AppiumDriver driver) { 
    	
    	if(!((AndroidDriver) driver).isAppInstalled(packageName))      // To check if this PACKAGE/APP is not already installed in our device, then we'll install it
    	{
    		
    		String myAndAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "Resources" + File.separator + "ApiDemos-debug.apk";   //location of our app
    		((AndroidDriver) driver).installApp(myAndAppUrl);   // command to install the app
    		 
    		System.out.println("App is now installed");
    		
    	}
    		
    	else {
    		System.out.println("App is already installed");
    		
    	}	   
    }
    
    public static void removeInstalledAp(AppiumDriver driver) { 
    
    
    	((AndroidDriver) driver).removeApp(packageName);
    }
 
	
    
    // PUT APPLICATOPN TO BACKGROUN TO CERTAIN AMOUNT OF TIME
    
    public static void holdAppForSometime(AppiumDriver driver) { 
        
        
    	((AndroidDriver) driver).runAppInBackground(Duration.ofSeconds(5));
    }
    
    
    
    // ACTIVATE Another App eg activate settings app  -- ACTIVATING means the app which is in Opened state and on screen live
    public static void activateAnotherApp(AppiumDriver driver) throws InterruptedException { 
    	
    	
    	   terminateApp(driver);   // we are terminating our own app before we activate another app
    	   Thread.sleep(3000);
    	 ((AndroidDriver) driver).activateApp("com.android.settings" );
    	 
    	 Thread.sleep(3000); // we have some time on SETTINGS APP and then ACTIVATED our own APP
    	 ((AndroidDriver) driver).activateApp(packageName ); 
    }
   
    
    // Query App State -- it will tell the current state of the app
    public static void statusOfApp(AppiumDriver driver) {
    	
     System.out.println(((AndroidDriver) driver).queryAppState(packageName));   // we are printing the current state of app
    	
     terminateApp(driver);
     
     System.out.println(((AndroidDriver) driver).queryAppState(packageName)); // AFter termination, whats the status
    	
    }
    
    public static void removeApp(AppiumDriver driver) {
    	IfAppInstalled(driver);
    	//((AndroidDriver) driver).removeApp(packageName);
    	
    	
    	
    }
    
	}



	
	

