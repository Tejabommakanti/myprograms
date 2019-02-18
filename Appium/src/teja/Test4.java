package teja;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Test4 
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
		dc.setCapability("deviceName","4c23816a7d04");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","7.1.2");
		dc.setCapability("appPackage","com.mxtech.videoplayer.ad");
		dc.setCapability("appActivity","com.mxtech.videoplayer.ad.OnlineActivityMediaList");
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
		
	      KeyEvent k=new KeyEvent(AndroidKey.MUSIC);
	      driver.pressKey(k);
	      Thread.sleep(5000);
	      KeyEvent k2=new KeyEvent(AndroidKey.MEDIA_PLAY);
	      driver.pressKey(k2);
	      Thread.sleep(5000);
	      
	      driver.closeApp();
	      Thread.sleep(5000);
	      if(driver.findElement(By.xpath("//*[@content-desc='Clear all notifications.']")).isDisplayed())
	      {
	    	  driver.findElement(By.xpath("//*[@content-desc='Clear all notifications.']")).click();
	      }
	      else
	      {
	    	  KeyEvent k1=new KeyEvent(AndroidKey.BACK);
		      driver.pressKey(k1);
		  
	      }
	      Thread.sleep(5000);
	      driver.closeApp();
	     
	     
	     
		      
	}

}
