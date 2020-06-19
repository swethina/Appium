package pages;
import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {
	AndroidDriver<MobileElement> driver;
	File appDir = new File("src");   
	File app = new File(appDir, "trello.apk"); 
@Test

	public AndroidDriver<MobileElement> setup() throws MalformedURLException
	{
	try{
	
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_XL_API_27");
	caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
	caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
	caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
	caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
	caps.setCapability("–session-override",true);
	caps.setCapability("appPackage","com.trello");
	caps.setCapability("appActivity", "com.trello.home.HomeActivity");
	caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	URL url = new URL("http://0.0.0.0:4723/wd/hub");
	driver =  new AndroidDriver<MobileElement>(url,caps);
	System.out.println("Application started");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getCause());
		System.out.println(e.getMessage());
		
	}
	return driver;

	
	}

	
}




