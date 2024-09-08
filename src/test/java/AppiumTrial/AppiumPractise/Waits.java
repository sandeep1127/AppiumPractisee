package AppiumTrial.AppiumPractise;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class Waits {

	public static void main(String[] args) throws Exception {
		
		
		// IMPLICIT WAIT :
		    
		AppiumDriver driver= BetterDriverSession.initializeDriver("Android");   // We're importing method from another class.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));   // Use  IMPLICIT WAIT immediately after initializing  driver
		
		// FYI : PageLoadTimeOut() method is not applicable for native apps. Ise for HYBRID or Browser
		
		
		
		By alertViews= AppiumBy.accessibilityId("Alert Vews");   // Finding some Element to test wait on it using BY class
		driver.findElement(alertViews).click();   // Performing CLICK action on that Element
		
		
		
		
		// EXPLICIT WAIT :
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Creating instance 
		wait.until(ExpectedConditions.visibilityOfElementLocated(alertViews)).click();   //This method returns the element if its displayed, so directly clicked it.
		
		
	
		
		
		// WHY NOT TO USE both 	IMPLICIT and EXPLICIT WAIT together -> Coz first JVM  will apply IMPLICIT wait and then EXPLICIT so double time. 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
