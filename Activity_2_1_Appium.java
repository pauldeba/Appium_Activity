package AppiumTesting;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity_2_1_Appium {
	AndroidDriver<MobileElement> driver = null;
	WebDriverWait wait;
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceId", "emulator-5554");
	  caps.setCapability("platformName", "Android");
	  caps.setCapability("appPackage", "com.android.chrome");
	  caps.setCapability("appActivity","com.google.android.apps.chrome.Main");
	  //caps.setCapability(CapabilityType.BROWSER_NAME, "Android");
	  //caps.setCapability("adbExecTimeout",5000);
	  //caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5000);
	  caps.setCapability("noReset", true);
	  // Instantiate Appium Driver
      driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
      wait = new WebDriverWait(driver, 600);
  }
  
  @Test
  public void mainTest() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
	  
      driver.get("https://www.training-support.net/");
	  //driver.get("https://www.google.com");

      String pageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
      System.out.println("Title on Homepage: " + pageTitle);
      
      MobileElement aboutButton = driver.findElementByXPath("//android.view.View[@content-desc='About Us']");
      aboutButton.click();

      String newPageTitle = driver
              .findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]")
              .getText();

      System.out.println("Title on new page: " + newPageTitle);

      // Assertions
      Assert.assertEquals(pageTitle, "Training Support");
      Assert.assertEquals(newPageTitle, "About Us");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
