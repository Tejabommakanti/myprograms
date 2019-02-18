package teja;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Unlock 
{

	public static void main(String[] args) throws Exception
	{

        //Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd /k \"appium -a 127.0.0.1 -p 4723\"");
		//Get Appium server address
		URL u=new URL("http://127.0.0.1:4723/wd/hub"); 
		//provide details of app and device (ARD)
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","82e2d65c");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","5.1.1");
		dc.setCapability("appPackage","com.android.dialer");
		dc.setCapability("appActivity","com.android.dialer.DialtactsActivity");
		dc.setCapability("noReset","true");
		//create driver object to launch APP in AVD
		     AndroidDriver driver;
		      while(2>1)
		       {
		      	try
		       	{
		       		driver=new AndroidDriver(u,dc);
		       		break;
		       	}
		       	catch(Exception ex)
		       	{
		       		System.out.println(ex.getMessage());
		       	}
		     }
              driver.lockDevice();
              driver.unlockDevice();
	}


}
