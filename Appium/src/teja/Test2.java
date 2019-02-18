package teja;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Test2 
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
        WebDriverWait w=new WebDriverWait(driver,20);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Local']")));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Local']")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@resource-id='com.mxtech.videoplayer.ad:id/play_last']")));
        driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.mxtech.videoplayer.ad:id/play_last']")).click();
       
	}

}
