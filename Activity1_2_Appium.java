package AppiumTesting;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.IIOException;

import org.openqa.selenium.remote.DesiredCapabilities;


//com.miui.calculator
//.cal.CalculatorActivity

public class Activity2_Appium {
  @Test
  public void calc() throws IIOException, IOException {
	  // Set the Desired Capabilities
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceId", "d22ad3957ce5");
	  caps.setCapability("platformName", "Android");
	  caps.setCapability("appPackage", "com.miui.calculator");
	  caps.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
	  //caps.setCapability("appPackage", "com.google.android.talk");
	  //caps.setCapability("appActivity", "com.google.android.talk.SigningInActivity");
	  // Instantiate Appium Driver
	  AppiumDriver<MobileElement> driver = null;
	  
	  try {
		  // Initialize Driver
		  driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
		  System.out.println("Calculator Is Open");
	  } catch(MalformedURLException e) {
		  System.out.println(e.getMessage());
	  }
  }
  
}
