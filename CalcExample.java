package AppiumTesting;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class CalcExample {
	AppiumDriver<MobileElement> driver = null;
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceId", "d22ad3957ce5");
	  caps.setCapability("platformName", "Android");
	  caps.setCapability("appPackage", "com.miui.calculator");
	  caps.setCapability("appActivity",".cal.CalculatorActivity");
	  caps.setCapability("noReset", true);
	  
	// Instantiate Appium Driver
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
  }
  
  @Test
  public void multiply() {
	  driver.findElementById("btn_9_s").click();
	  //driver.findElementById("btn_9_s").click();
	  //driver.findElementById("btn_0_s").click();
	  driver.findElementById("btn_mul_s").click();
	  driver.findElementById("btn_9_s").click();
	  driver.findElementById("btn_equal_s").click();
	  //Display Results
	  String result = driver.findElementById("result").getText();
	  System.out.println(result);
	  Assert.assertEquals("= 81", result);
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
