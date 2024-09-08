package AppiumTrial.AppiumPractise;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class MobileGestures {

	public static void main(String[] args) throws Exception {
		AppiumDriver driver = BetterDriverSession.initializeDriver("Android");
		longClickGesture(driver);   // calling longClickGesture method
		clickGesture(driver);
		swipeGesture(driver);
		
	}
	/*	GESTURES :-
	
	WAYS to use GESTURES:
	   a) Mobile Extensions/Backend Command  -> Different commands for Android & IOS. 
	
	ANDROID | IOS
	1) mobile: longClickGesture | Mobile: touchAndHold                  >Do long press on given element and if element is missing provide Coordinates to long press.
	2) mobile: clickGesture | Mobile: tap                               >performing click operation on element using coordinates
	3) mobile: dragGesture | Mobile: dragFromToForDuration   			>perform drag and drop
	4) mobile: swipeGesture | Mobile: swipe                  			> Swipe up/down/top/bottom
	5) mobile: scrollGesture | Mobile: scroll                			> To scroll the screen        // IMP : We use  'up' word to see the below screen data but we use "scroll down" word to see the below screen data. Both actions do same here
	6) mobile: pinchOpenGesture and mobile:pinchCloseGesture| Mobile: pinch     >Zoom in and Zoom out 
	
	
	IOS specific:
	mobile: selectPickerWheelValue     >
	mobile:scrollToSelement
	
	DOCUMENT available on : Github
	
	*/
		
		
		
		
		
// 1 .  mobile: longClickGesture | Mobile: touchAndHold     > Appium will execute commands as Javascript executer
		
		// ONLY ANDROID SCENARIOS are covered below:
		public static void longClickGesture(AppiumDriver driver) {    // we need 'Driver' so we took it as argument so that we can use 'driver'
			driver.findElement(AppiumBy.accessibilityId("Views")).click();
			driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
			
			WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));   // found the element on which we will perform long click
			
		                           // IF WANT TO USE "ELEMENTID" to perform the action 	 [BETTER APPROACH]
			
		                        	// If we don't want to provide our own hold timer and wana use 500ms defualt one"
			driver.executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement) element).getId()));      // in order to get Id, we needed to caste webElement to RemoteWeblement as this method "getId" is available in RemoteWebElemnt class and not in WebElement class.
		                                                             																//We're using ImmutableMap to supply the Key values pairs
		  
																															// IMMUATBLE MAP = Its nothing but extended version of map collection in Java. Elements are Read only so they're constants
			
									// If we want to provide our own  timer and don't wana use 500ms default one"
			
			driver.executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement) element).getId(), "duration", 2000));   // We want element to be clicked for 2 seconds
		
		
									// IF WANT TO USE "COORDINATES" to perform action.
			
			driver.executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement) element).getId(),"x",217 , "y",659, "duration", 2000));   // Gave X and Y coordinates for long click.
		}
		
		

		
		
// 2) mobile: clickGesture      > We can supply ELEMENT ID or COORDINATES to use this 
		
		
		
		             // Using 'ELEMENT ID'
		
		public static void clickGesture(AppiumDriver driver) {    // we need 'Driver' so we took it as argument so that we can use 'driver'
			WebElement element1 = driver.findElement(AppiumBy.accessibilityId("Views"));
			
			driver.executeScript("mobile: clickGesture", ImmutableMap.of("elementId",((RemoteWebElement) element1).getId()));  // we've done casting here and getting ID from the method getId() as this method is available only to the RemoteWebElement class. We're using ImmutableMap to supply the Key values pairs
			
		}
		           // Using  coordinates   [do it yourself]
			
			
			
// 3) mobile: dragGesture     > Perform drag action from the given element/Coordinates ot the Given point
			
			
			public static void dragGesture(AppiumDriver driver) {
				
				
				driver.findElement(AppiumBy.accessibilityId("Views")).click();
				driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
				
		    WebElement element1 = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));  // storing the elemnt which we need to drag
			    
				
		    driver.executeScript("mobile: clickGesture", ImmutableMap.of(
		    		"elementId" , ((RemoteWebElement) element1).getId(),        // we're supplying the element id via "getId()" which is "elementId" which is element1 
		    		"endX" , 649,   // destination X corrindiate where we need to drop 
		    		"endY" , 662    // destination Y corrindiate where we need to drop
		    ));
		    
	
			}
	
			
			
// 4) mobile: swipeGesture		 > can work on ELEMENTID or COORDINATES
		
			
			// Work with COORDINATES:
			// SWIPE UP
			public static void swipeGesture(AppiumDriver driver) {
				
			driver.findElement(AppiumBy.accessibilityId("Views")).click();
			driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
					"left" , 100,
		    		"top", 100,
		    		"width", 600,
		    		"height", 600,
		    		"direction", "up",   // Which direction use is swiping
		    		"percentage", 0.75   // % of the bounding area you need to swipe
		    		));
			
			
			// Work with ELEMENTID:   >Don't take just some element for this, it needs to be some element which has bounding area, basically some element which has area to get swiped
			// SWIPE UP
			driver.findElement(AppiumBy.accessibilityId("Views")).click();
			WebElement element1 = driver.findElement(AppiumBy.id("android:id/list"));
			
			driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
					"left" , 100,
		    		"top", 100,
		    		"width", 600,
		    		"height", 600,
		    		"elementId" , ((RemoteWebElement) element1).getId(), 
		    		"direction", "up",   // Which direction user is swiping
		    		"percentage", 0.75   // % of the bounding area you need to swipe    But in realistic, it actually swipes till the bottom of screen
		    		));
			
			
			
			// SWIPE LEFT  [Work with ELEMENTID]
			driver.findElement(AppiumBy.accessibilityId("Views")).click();
			driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
			driver.findElement(AppiumBy.accessibilityId("1. photos")).click();
			
			WebElement element2 = driver.findElement(AppiumBy.xpath("//*[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]"));   // x path of the 1st image which we are swiping
			
			
			driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
					"left" , 100,
		    		"top", 100,
		    		"width", 600,
		    		"height", 600,
		    		"elementId" , ((RemoteWebElement) element2).getId(), 
		    		"direction", "left",   // Which direction user is swiping
		    		"percentage", 0.75   // % of the bounding area you need to swipe    But in realistic, it actually swipes till the bottom of screen
		    		));
			
			
			}
			
// 5) mobile: scrollGesture		 > can work on ELEMENTID or COORDINATES		, Also, it returns BOOLEAN values if the object can still scroll in given direction	
					// ITS BETTER COZ it will swipe only according to the mentioned Bpunding area unlike "SwipeGesture" which always swipes till the bottom or top irrespective of the mentioned bounding area.
			public static void scrollGesture(AppiumDriver driver) {
				
				driver.findElement(AppiumBy.accessibilityId("Views")).click();
				
				// Using BOUNDING AREA
				boolean canScrollMore1 = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
					"left" , 100,
		    		"top", 100,
		    		"width", 200,
		    		"height", 200,
		    		//"elementId" , ((RemoteWebElement) element2).getId(), 
		    		"direction", "down",   // Which direction user is SCROLLING [here DOWN is same as UP for Swipe]
		    		"percentage",1.0   // % of the bounding area you need to swipe    But in realistic, it actually swipes till the bottom of screen
		    		));
				
				
				            // If we want to keep scrolling the page to reach bottom of screen .This will happen tillBoolean shows FALSE (we'll use WHILE LOOP)
                                 driver.findElement(AppiumBy.accessibilityId("Views")).click();
                                 WebElement element1 = driver.findElement(AppiumBy.accessibilityId("Animation"));
                       boolean canScrollMore2 = true;
                       while (canScrollMore2) {
                    	   
                    	    canScrollMore2 = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
               					"left" , 100,
               		    		"top", 100,
               		    		"width", 200,
               		    		"height", 200,
               		    		//"elementId" , ((RemoteWebElement) element2).getId(), 
               		    		"direction", "down",   // Which direction user is SCROLLING [here DOWN is same as UP for Swipe]
               		    		"percentage",1.0   // % of the bounding area you need to swipe    But in realistic, it actually swipes till the bottom of screen
               		    		));
                    	   System.out.println(canScrollMore2); // It will show TRUE till Scrolling area is left to do more scrolling
                       }
                       
                      
                      
                      
                      
				// Using BOUNDING AREA
				      boolean canScrollMore3 = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
					"left" , 100,
		    		"top", 100,
		    		"width", 200,
		    		"height", 200,
		    		//"elementId" , ((RemoteWebElement) element2).getId(), 
		    		"direction", "down",   // Which direction user is SCROLLING [here DOWN is same as UP for Swipe]
		    		"percentage",1.0   // % of the bounding area you need to swipe    But in realistic, it actually swipes till the bottom of screen
		    		));
				
				
				
				
				
				
				
				
				// USING ELEMENT ID
				driver.findElement(AppiumBy.accessibilityId("Views")).click();
				
				WebElement elementt = driver.findElement(AppiumBy.id("android:id/list"));   // This is the ELEMENT whose height will act as BOUNDING AREA now and SCROLL WOULD BE DONE as the % mentioned below
				
				
				boolean canScrollMore4 = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
						"left" , 100,
			    		"top", 100,
			    		"width", 200,
			    		"height", 200,
			    		"elementId" , ((RemoteWebElement) elementt).getId(), 
			    		"direction", "down",   // Which direction user is SCROLLING [here DOWN is same as UP for Swipe]
			    		"percentage",1.0   // % of the bounding area you need to swipe    But in realistic, it actually swipes till the bottom of screen
			    		));
				
			}
			
			
			
			
		
//	6. mobile: pinchOpenGesture and mobile:pinchCloseGesture	 > Zoom in or zoom is done by this. If ElementID is available then use that otherwise we need to find "pinch bounding area" for which we need to provide the coordinates of top,left ,width and height ie kind of box. Provide any 1 of them.
		// we gona use Google maps application for this	
			
			public static void pinchOpenGesture(AppiumDriver driver) throws InterruptedException {  // It will ZOOM OUT
				
				// Go to "InitializeDriver" method and change app package and app activity to open Google Maps app.  AppPackage = com.google.android.apps.maps  , appActivity= com.google.android.maps.MapsACtivity
				
				Thread.sleep(3000);
				driver.findElement(AppiumBy.xpath("//widget.Button[@text=\"SKIP\"]")).click();    // This is click on the SKIP button coz in tutorial a extra used to come
				Thread.sleep(5000);
				
				 driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
				    		"left" , 200,
				    		"top", 470,
				    		"width", 600,
				    		"height", 600,
				    		"percentage", 0.75
				    		));
				
			}
		
			
			
			
				
		
		
		                              
		
		
		
		
		
		
	

}
