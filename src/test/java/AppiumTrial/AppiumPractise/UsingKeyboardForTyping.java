package AppiumTrial.AppiumPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class UsingKeyboardForTyping {
	// Sometimes, we need to check if tapping inside text field, keyboard is displayed or not. For this we will use below methods . Also, we will  use keyboard to type in field.
	

	public static void main(String[] args) throws Exception {
		
		AppiumDriver driver = BetterDriverSession.initializeDriver("Android");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// navigating to the desired screen to test our methods using BY class
		By views = AppiumBy.accessibilityId("Views");
		By textFields = AppiumBy.accessibilityId("TextFields");
		By editbox = AppiumBy.id("io.appium.android.apis:id/edit");
		
		driver.findElement(views).click();  // clicking on Views 
		 
		 WebElement element = driver.findElement(AppiumBy.id("android:id/list"));    // using swipe gesture
	        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
	                "elementId", ((RemoteWebElement) element).getId(),
	                "direction", "up",
	                "percent", 0.75
	        ));

	        driver.findElement(textFields).click();    // Clicking TextField
	        driver.findElement(editbox).click();      // Clicking Edit box 
	        Thread.sleep(3000);

	    
	        // calling method created below
	        isKeyboardDisplaying(driver);    
	        sendingCharactersViaKeyboard(driver);
	        hideKeyboard(driver);
	        
	}
	     
	
	
	
	// METHOD TO CHECK IF KEYBOARD is DISPLAYED or NOT inside text box
	        public static void isKeyboardDisplaying(AppiumDriver driver)   // This method will tell if keyboard is shown or not
	        {
	        	
	        	System.out.println(((AndroidDriver) driver).isKeyboardShown());  // give you boolean
		        	
	        }
	        
	        	
	        
	        
	        
 // Method to type via keyboard without using SendKeys()
	        public static  void sendingCharactersViaKeyboard(AppiumDriver driver) throws InterruptedException    
	        
	        {
	        	
	        	// We need to use method "presskey(KeyEvent keyEvent)" > need to create new instance of NewEvent Class of Android inside method's () > use method "withKey() and inside brackets () use AndroidKey.[keys you want]
		        
		        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.C));   // We need to cast our DRIVER to ANDROID DRIVER to use the method "presskey()" coz driver doesn't have this method as its APPIUM DRIVER.
//		        driver.getKeyboard().pressKey(Keys.ARROW_DOWN); -> Deprecated
		        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.A));
		        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.B));
		        
		       // ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.HOME));  // app will be put into background
		       // ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.CALENDAR));  // using keys we can even open inbuilt apps  
		        //((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.B));
		        
//		        driver.getKeyboard().pressKey(Keys.HOME); -> Deprecated
		        Thread.sleep(3000);
		        hideKeyboard(driver);   // just hiding the keyboard
		        isKeyboardDisplaying(driver);
		        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.C));
		        isKeyboardDisplaying(driver);
		        System.out.println("2nd method done");
	        }
	        
	        
	        
	        
	        // METHOD TO HIDE THE KEYBOARD     
	        public static  void hideKeyboard(AppiumDriver driver) throws InterruptedException   
	        {
	        	// METHOD TO HIDE the KEYBOARD
	        	
	        	Thread.sleep(3000);
		        ((AndroidDriver) driver).hideKeyboard();
	        }
	        
	     

	    
	}
