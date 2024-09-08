package AppiumTrial.AppiumPractise;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class PageFactory {
	/* how to use classes  [Applicable to both ANDROID and IOS]
	
	1) WebElement   --> This is from Selenium
	2) By 
	3) @FindBy
	4) @AndroidFindBy
	5) @iOSXCUITFindBy
	
   */
	public static void main(String[] args) throws Exception {
		AppiumDriver driver = BetterDriverSession.initializeDriver("Android");
		
		
		//USING WEBELEMENT CLASS to find any element
		WebElement webElement1 = driver.findElement(AppiumBy.accessibilityId("Accessibility"));             //AppiumBy is from Java Client
        System.out.println(webElement1.getText());
		
		
	}

	
	
	
	
}
