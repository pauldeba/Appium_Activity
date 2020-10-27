package AppiumTesting;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Screenshots {
	AppiumDriver<MobileElement> driver= null;
 
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  //set Desired Capabilities
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceId", "d22ad3957ce5");
	  caps.setCapability("platformName", "Android");
	  caps.setCapability("appPackage", "com.miui.calculator");
	  caps.setCapability("appActivity", ".cal.CalculatorActivity");
	  caps.setCapability("noReset", "true");
	  // Instantiate Appium Driver
	  URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	  driver = new AppiumDriver<MobileElement>(appServer,caps);
  }
  
  @Test
  public void mainTest() throws IOException {
	  String timeStamp;
	  File screenShotName;
	  // Take ScreenShot
	  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  // this specifies the location the screenshot will be saved
	  screenShotName = new File("src/test/resources/screenshot.jpg");
	  // this will copy the screenshot to the file created
	  FileUtils.copyFile(scrFile, screenShotName);
	  //set FilePath for image
	  String filePath = "../"+screenShotName.toString();
	  // set image HTML in the report
	  String path = "<img scr='"+filePath+"'/>";
	  //show image in report
	  Reporter.log(path);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
