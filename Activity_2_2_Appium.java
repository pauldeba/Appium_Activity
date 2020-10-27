package AppiumTesting;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity_2_2_Appium {
	AppiumDriver<MobileElement> driver = null;
	
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  //set desired Capability
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceId", "d22ad3957ce5");
	  caps.setCapability("platformName", "Android");
	  caps.setCapability("appPackage", "com.miui.calculator");
	  caps.setCapability("appActivity", ".cal.CalculatorActivity");
	  caps.setCapability("noReset", true);
	  
	  // Instantiate Appium Driver
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
  }
  
  @Test
  public void add() {
	  //driver.findElementById("btn_c_s").click();
	  driver.findElementById("btn_5_s").click();
      driver.findElementById("btn_plus_s").click();
      driver.findElementById("btn_9_s").click();
      // Perform Calculation
      driver.findElementById("btn_equal_s").click();

      // Display Result
      String result1 = driver.findElementById("result").getText();
      System.out.println("5+9 "+result1);
      Assert.assertEquals(result1, "= 14");
  }
  
  @Test
  public void subtract() {
	  //driver.findElementById("btn_c_s").click();
      driver.findElementById("btn_1_s").click();
      driver.findElementById("btn_0_s").click();
      driver.findElementById("btn_minus_s").click();
      driver.findElementById("btn_5_s").click();
      // Perform Calculation
      driver.findElementById("btn_equal_s").click();

      // Display Result
      String result2 = driver.findElementById("result").getText();
      System.out.println("10-5 "+result2);
      Assert.assertEquals(result2, "= 5");
  }
  
  @Test
  public void multiply() {
	  //driver.findElementById("btn_c_s").click();
      driver.findElementById("btn_5_s").click();
      driver.findElementById("btn_mul_s").click();
      driver.findElementById("btn_1_s").click();
      driver.findElementById("btn_0_s").click();
      driver.findElementById("btn_0_s").click();
      // Perform Calculation
      driver.findElementById("btn_equal_s").click();

      // Display Result
      String result3 = driver.findElementById("result").getText();
      System.out.println("5x100 "+result3);
      Assert.assertEquals(result3, "= 500");
  }

  @Test
  public void divide() {
	  //driver.findElementById("btn_c_s").click();
      driver.findElementById("btn_5_s").click();
      driver.findElementById("btn_0_s").click();
      driver.findElementById("btn_div_s").click();
      driver.findElementById("btn_2_s").click();
      // Perform Calculation
      driver.findElementById("btn_equal_s").click();

      // Display Result
      String result4 = driver.findElementById("result").getText();
      System.out.println("50/2 "+result4);
      Assert.assertEquals(result4, "= 25");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
