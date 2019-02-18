package teja;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Phonecall
{
	public static void main(String[] args) throws Exception
	{
	   // Get mobile number
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter a mobile number");
	   String mbno=sc.nextLine();
	   //Start appium server 
	   Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4721\"");
	   URL u=new URL("http://127.0.0.1:4721/wd/hub");
	   //Maintain details base for app and ARD
	   DesiredCapabilities dc=new DesiredCapabilities();
	   dc.setCapability(CapabilityType.BROWSER_NAME,"");
	   dc.setCapability("deviceName","4c23816a7d04");
	   dc.setCapability("platformName","android");
	   dc.setCapability("platformVersion","7.1.2");
    	dc.setCapability("appPackage","com.android.contacts");
		dc.setCapability("appActivity","com.android.contacts.activities.TwelveKeyDialer");
		dc.setCapability("noReset","true");
		//Launch app in ard
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
			}
		}
	   //App Automation
		try
		{
			WebDriverWait w1=new WebDriverWait(driver,20);
			w1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='android.widget.ImageView']")));
			driver.findElement(By.xpath("//*[@class='android.widget.ImageView']")).click();
			for(int i=0;i<mbno.length();i++)
        	{
        		char d=mbno.charAt(i);
        		String w="";
        		switch(d)
        		{
        		case'0':
        			w="zero";
        			break;
        		case'1':
        			w="one";
        			break;
        		case'2':
        			w="two";
        			break;
        		case'3':
        			w="three";
        			break;
        		case'4':
        			w="four";
        			break;
        		case'5':
        			w="five";
        			break;
        		case'6':
        			w="six";
        			break;
        		case'7':
        			w="seven";
        			break;
        		case'8':
        			w="eight";
        			break;
        		case'9':
        			w="nine";
        			break;
        		}
        	
        	w1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='Contacts']")));
        	driver.findElement(By.xpath("//*[@content-desc='"+w+"']")).click();
		  }
			w1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='Dial using SIM1']")));
			driver.findElement(By.xpath("//*[@content-desc='Dial using SIM1']")).click();
			w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='00:10']")));
			driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc='End']/android.widget.ImageView")).click();
			
		}	
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//stop appium desktop server 
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
