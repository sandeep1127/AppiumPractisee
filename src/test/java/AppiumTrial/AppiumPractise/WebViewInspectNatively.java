package AppiumTrial.AppiumPractise;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;


 /* HybridApp : Inspecting WebView elements using appium inspector on NATIVE MODE  [NOT RECOMEMED coz same code won't work for both Platforms]

 1. We may be able to inspect WebView elemnets using appium inspctor but it can b done only natively
 2. Check if a page or a portion of the page is a WebView or a Native view
 3. case where APPIUM INSPECTOR won't inspect the WebView Elements.

*/

public class WebViewInspectNatively {

	public static void main(String[] args) throws Exception {
	
		
		
		AppiumDriver driver = BetterDriverSession.initializeDriver("Android");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
 driver.findElement(AppiumBy.accessibilityId("Views")).click();
      
//THIS WILL WORK ONLY FOR ANDROID [We need stategu which will work for both android and IOS] : NOT RECOMMENDED
 
      scrollAndroidDeviceScreen(driver); // Calling method to scroll to the bottom
      driver.findElement(AppiumBy.accessibilityId("WebView2")).click();
      Thread.sleep(3000);
   
      System.out.println(driver.findElement(AppiumBy.xpath("//android.webkit.WebView/android.widget.TextView[1]")).getText());   // Finding the text label text of the Element
      
   
      // BELOW CODE will Work only for IOS : NOT RECOMMENDED
       
     /* 
      scrollIOSDeviceScreen(driver);
      driver.findElement(AppiumBy.accessibilityId("Web View")).click();
      Thread.sleep(3000);
      System.out.println(driver.findElement(AppiumBy.accessibilityId("This is HTML content inside a WKWebView .")).getAttribute("label"));   // We did n't use getText() coz it would have returned 1 as value.
              
       */
       
	}
	
	
	
        // -> Scroll code for Android starts here. This will scroll the screen downas we need to click on WEBVIEW option in app
      public static  void scrollAndroidDeviceScreen(AppiumDriver driver)
      {
             WebElement androidElement = driver.findElement(AppiumBy.id("android:id/list"));
             
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) androidElement).getId(),
                "direction", "up",
                "percent", 0.75
        ));
      
      
      }
      

        // -> Scroll code for iOS starts here
        public static void scrollIOSDeviceScreen(AppiumDriver driver)
        {
        	WebElement iOSElement = driver.findElement(AppiumBy.
                    iOSNsPredicateString("type == \"XCUIElementTypeTable\""));
            Map<String, Object> params = new HashMap<>();
            params.put("direction", "up");
            params.put("element", ((RemoteWebElement) iOSElement).getId());
            driver.executeScript("mobile: swipe", params);  
        	
        }
       
        // -> Scroll code for iOS ends here

        

    }

