package uas_appium_kpl;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DaylioMood {
	
	static AppiumDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			setMoodActivity();
		}catch(Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}

	}
	
	public static void setMoodActivity() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Galaxy A22");
        capabilities.setCapability("udid", "RR8RA01AXNH");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13");
        
//        capabilities.setCapability("appPackage", "com.eco.notes.notepad.notebook.simplenote");
//        capabilities.setCapability("appActivity", "com.eco.notes.notepad.notebook.simplenote.screens.start.StartActivity");
        
        capabilities.setCapability("appPackage", "net.daylio");
        capabilities.setCapability("appActivity", "net.daylio.activities.OverviewActivity");
        
        
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, capabilities);
        
        System.out.println("Application opened..");
        
        //klik tombol 'Next' utk melanjutkan ke laman berikutnya
        driver.findElementById("net.daylio:id/btn_next").click();
        //klik tombol 'Agree'
        driver.findElementById("net.daylio:id/btn_agree").click();
        //klik next beberapa kali
        driver.findElementById("net.daylio:id/clickable").click();
        driver.findElementById("net.daylio:id/clickable").click();
        driver.findElementById("net.daylio:id/clickable").click();
        
        //jeda 2 detik karena muncul pop up menanyakan utk menyalakan notifikasi
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //klik tombol 'Allow'
        driver.findElementById("com.android.permissioncontroller:id/permission_allow_button").click();
        
        //jeda 2 detik 
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //klik next lagi
        driver.findElementById("net.daylio:id/clickable").click();
        
        //klik skip utk melewatkan tawaran free trial
        driver.findElementById("net.daylio:id/skip_bottom").click();
        
        //jeda 2 detik 
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //halaman select mood
        //pilih mood 'good;
        driver.findElementById("net.daylio:id/btn_mood_good").click();
   
	}

}
