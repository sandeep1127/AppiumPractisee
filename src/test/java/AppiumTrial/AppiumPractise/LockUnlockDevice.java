package AppiumTrial.AppiumPractise;

import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class LockUnlockDevice {

	public static void main(String[] args) throws Exception {
		
		AppiumDriver driver = BetterDriverSession.initializeDriver("Android");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		whenPinSet(driver);   // calling the method
		
	}
		
	
	
	
	//	NOTE : This thing to lock/unlock is not available in IOS to lock or unlock the device
		   
	
		
		
		//SCENARIO 1:  When No PIN or PATTERN is set :-
		
		
		
		 public void whenNoPinSet(AppiumDriver driver)   
		  {
			//Method 1:-                                                           At the moment, Driver is APPIUM DRIVER and not ANDROID DRIVER, so we need to caste the Driver
              ((AndroidDriver) driver).lockDevice(Duration.ofSeconds(4));   // This method will lock the device for desired seconds and then will unlock it automatically when PIN is not set
			
            //Method 2:-   
			  ((AndroidDriver) driver).lockDevice();  // This method will simply lock the device
			System.out.println(((AndroidDriver) driver).isDeviceLocked()); // To check if Device is in Locked State
			
			//Method 3:-   
			((AndroidDriver) driver).unlockDevice(); // It will unlock the device if PIN was not set	
		}
			
		 

			//SCENARIO 2 :  When PIN or PATTERN is set :-
		
		public static  void whenPinSet(AppiumDriver driver) {
			
			
            // We need to use 2 capabilities for this to work 1) "unlockType" 2)  " unlockKey"   
			                   // you should set this in your initialize method
			
			    
			 /*
			  caps.setCapability("unlockType", "pin");   // These 2 capabilities are used when you want to unlock your locked phone set with some PIN
              caps.setCapability("unlockKey", "1010");
              
               caps.setCapability("unlockType", "Pattern");   // These 2 capabilities are used when you want to unlock your locked phone set with some PATTERN
               caps.setCapability("unlockKey", "1010");    here,just put key number on which pattern is made
                   
                   fingerprint(works only for emulator 6+)
			*/
		}
	
		
	
	}
	
	
	
	
	
	
	                    
	                    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


