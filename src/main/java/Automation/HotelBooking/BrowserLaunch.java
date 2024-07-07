package Automation.HotelBooking;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
///import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;



public class BrowserLaunch {

  
public void browser(WebDriver driver, Properties data) throws IOException, InterruptedException

{
     
      //tools Drivers = new tools(driver);
	

      String url = data.getProperty("URL");
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      driver.get(url);
      Thread.sleep(2000);
    
    
      System.out.println(driver.getTitle());

      Thread.sleep(2000);
}

  // private static boolean isFullyClicked(WebElement continueButton) {
  //     // TODO Auto-generated method stub
  //     throw new UnsupportedOperationException("Unimplemented method 'isFullyClicked'");
  // }
}
