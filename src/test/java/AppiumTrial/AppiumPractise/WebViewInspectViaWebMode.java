package AppiumTrial.AppiumPractise;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class WebViewInspectViaWebMode {

	public static void main(String[] args) throws Exception {
		/* 
		 1. Using APPIUM INSPECTOR's "WEB/HYBRID App mode  [NOT GOOD]
		 2. Using Web Chrome's Inspect method [GOOD]
		 */
		
		 
		//  1. [THIS IS FOR BOTH ANDROID and IOS]Here we can inspect WebView Elements via Appium Inspector in WEB MODE as well but it won't be as efficient as done in CHROME WEB Inspection. In Appium Inspector just click "WEB/HYBRID App mode" button. Looks like world globe icon
    
	
	
		// 2. ANDROID : Using CHROME REMOTE DEBUGGER to inspect WebView Elements	 .   just fill "chrome://inspect/#devices" in chrome and then inspect it the way you do for selenium
		
		// Inside Web chrome, just open whatever you want to inspect. eg App's page which has WebView page OR open any website inside phone's browser. See that same will be available for inspecting inside chrome://inspect/#devices [If WebView is not showing then it means "setWebContentDebuggingEnabled" is not enabled in Application so talk to dev team]
		 
	
	
	
	// **********************AUTOMATING WEBVIEW ELEMENTS of HYBRID app using Chrome Inspecter*****************************************
	  	
		
		AppiumDriver driver = BetterDriverSession.initializeDriver("Android");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	 driver.findElement(AppiumBy.accessibilityId("Views")).click();
	 
	 
	 scrollAndroidDeviceScreen(driver);
	 
	 
	 driver.findElement(AppiumBy.accessibilityId("WebView")).click();
	 
	 // To get the CONTEXT HANDLES which can be used to iterate over all contexts
	 

	
	
	Thread.sleep(3000);
    Set<String> contextHandles = ((AndroidDriver) driver).getContextHandles();   // Using the method "getContextHandles" which will return set<String>
    for(String contextHandle : contextHandles){
        System.out.println(contextHandle);
    }
        
    
    // Below code for switching first sees if Chrome Driver is installed or not and it needs to match with Chrome version for which CAPABILITY is used. SO always check if update chrome driver is available. You can also automate chrome driver.
    /* CAPABILITY to use ChromeDriver:
    capability name : chromedriverExecutable , value = "path of chrome driver"
    
    */
    
    
    
    // SWITCHING Driver to the WEBVIEW CONTEXT
    ((AndroidDriver) driver).context("WEBVIEW");   // Provide the static name of WebView without Package name. This you got from above code
//  ((AndroidDriver) driver).context(contextHandles.toArray()[1].toString());   // THIS Code is used to Switch to WEBVIEW but driver here doesn't use static name like used in above line. It uses the complete name which is at position 1 in above code.
  
    System.out.println(driver.findElement(By.cssSelector("body > h1")).getText());  // we're finding any element of WEBVIEW by using selectors which we normally use for web while doing selenium automation. 
  System.out.println(driver.findElement(By.xpath("//*[@id=\"i_am_a_textbox\"]")).getText());  // we don't get any result since value is null for this text box.
  
  // AGAIN swiwtching to NATIVE VIEW if you want to come out of WEBVIEW.
  ((AndroidDriver) driver).context("NATIVE_APP");    // This name "NATIVE_APP" we got from code in line 58

	
	
	}
   
    
    
    
	
	
	
	
	 
	   // -> Scroll code for Android. This will scroll the screen down as we need to click on WEBVIEW option in app
     public static  void scrollAndroidDeviceScreen(AppiumDriver driver)
     {
            WebElement androidElement = driver.findElement(AppiumBy.id("android:id/list"));
            
       driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
               "elementId", ((RemoteWebElement) androidElement).getId(),
               "direction", "up",
               "percent", 0.75
       ));
     
     
     
	
	
	
	
	
	
	
	
	
	
	}
}
