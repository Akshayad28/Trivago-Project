package Automation.HotelBooking;





import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import CraftDriver.xpaths;

public class HotelSearch {

protected WebDriver driver;
protected Properties data;

    public void logIn(WebDriver driver, Properties data) throws InterruptedException
    {
    	



          Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(xpaths.SignIn).click();
            
    
            Thread.sleep(2000);
            
            driver.findElement(xpaths.EmailID).click();
            System.out.println(xpaths.EmailID);
            
            Thread.sleep(2000);
           // driver.findElement(xpaths.EmailID).sendKeys(data.getProperty("EmailID"));
           // methods.enterText(xpaths.EmailID, data.getProperty("EmailID"));
            driver.findElement(xpaths.EmailID).sendKeys(data.getProperty("EmailID"));
            driver.findElement(xpaths.ContinueButton).click();
            System.out.println(data.getProperty("EmailID"));
            Thread.sleep(2000);
    
            driver.findElement(xpaths.Password).sendKeys(data.getProperty("Password"));
            driver.findElement(xpaths.ContinueButton).click();
          //  WebElement continueButton = driver.findElement(xpaths.ContinueButton);
            System.out.println(data.getProperty("Password"));
            Thread.sleep(2000);
          
            Thread.sleep(5000);
       
    }



    public void Booking(WebDriver driver, Properties data) throws InterruptedException
    {

        Thread.sleep(4000);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(xpaths.Destination).sendKeys(data.getProperty("Destination"));
        Thread.sleep(3000);
        String index = data.getProperty("Suggetion");
        WebElement suggetion = driver.findElement(By.xpath("//*[@id='suggestion-list']/ul/li["+index+"]/div/div/div[2]/span[1]/span"));
        suggetion.click();
        Thread.sleep(3000);
       
       System.out.println(suggetion);

        WebElement calendarIcon = driver.findElement(By.xpath("//button[@data-testid='search-form-calendar-checkin']"));
        calendarIcon.click();

        // Date to select (replace with your desired date)


        driver.findElement(xpaths.DATE).click();
        String checks = data.getProperty("CheckInDate");
        System.out.println(checks);
        System.out.println(driver.findElements(By.xpath("//*[@datetime='"+ data.getProperty("CheckInDate")+"']")));
       

        while (true) {
            try {
                if(driver.findElements(By.xpath("//*[@datetime='"+ data.getProperty("CheckInDate")+"']")).size() !=0)
                {
                    Thread.sleep(2000);
                    // Perform the action if the condition is met
                    driver.findElement(By.xpath("//*[@datetime='"+ data.getProperty("CheckInDate")+"']")).click();
                    break; // End the loop if the if condition is true
                } 
                else {
                    Thread.sleep(2000);
                    // Perform the action if the else condition is true
                    driver.findElement(xpaths.NextMonth).click();
                }
            } catch (NoSuchElementException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread.sleep(2000);


        while (true) {
            try {
                if(driver.findElements(By.xpath("//*[@datetime='"+ data.getProperty("CheckOutDate")+"']")).size() !=0)
                {
                    Thread.sleep(2000);
                    // Perform the action if the condition is met
                    driver.findElement(By.xpath("//*[@datetime='"+ data.getProperty("CheckOutDate")+"']")).click();
                    break; // End the loop if the if condition is true
                } 
                else {
                    Thread.sleep(2000);
                    // Perform the action if the else condition is true
                    driver.findElement(xpaths.NextMonth).click();
                }
            } catch (NoSuchElementException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        Thread.sleep(2000);

        String Adults = data.getProperty("AdultsCount");
        String Childrens = data.getProperty("ChildCount");
        String Rooms = data.getProperty("RoomsCount");

         
            if(!Adults.equals("0"))
            {   
                Thread.sleep(2000);
                driver.findElement(xpaths.AdultCount).sendKeys(Keys.chord(Keys.CONTROL, "a"));
                Thread.sleep(2000);
                driver.findElement(xpaths.AdultCount).sendKeys(Keys.BACK_SPACE);
                Thread.sleep(2000);
                driver.findElement(xpaths.AdultCount).sendKeys(data.getProperty("AdultsCount"));
                Thread.sleep(2000);

            
            }
            else 
            {
                System.out.println("Aduults are not selected");
            }
            Thread.sleep(2000);
            if(!Childrens.equals("0"))
            {
                Thread.sleep(2000);
                driver.findElement(xpaths.ChildCount).sendKeys(Keys.chord(Keys.CONTROL, "a"));
                Thread.sleep(2000);
                driver.findElement(xpaths.ChildCount).sendKeys(Keys.BACK_SPACE);
                Thread.sleep(2000);
                driver.findElement(xpaths.ChildCount).sendKeys(data.getProperty("ChildCount"));
                Thread.sleep(2000);

            
            }
            else 
            {
                System.out.println("Childrens are not selected");
            }
            Thread.sleep(2000);
            if(!Rooms.equals("0"))
            {
                Thread.sleep(2000);
                driver.findElement(xpaths.RoomCount).sendKeys(Keys.chord(Keys.CONTROL, "a"));
                Thread.sleep(2000);
                driver.findElement(xpaths.RoomCount).sendKeys(Keys.BACK_SPACE);
                Thread.sleep(2000);
                driver.findElement(xpaths.RoomCount).sendKeys(data.getProperty("RoomsCount"));
                Thread.sleep(2000);

            
            }
            else 
            {
                System.out.println("Rooms are not selected");
            }


            Thread.sleep(2000);
          
            System.out.println("It worked");

            int CHcount = Integer.parseInt(Childrens); // Convert string to integer
          

             
            for (int i = 1; i <= CHcount; i++) 
            {  
                if(!Childrens.equals("0"))  
                {

                driver.findElement(By.xpath("//label[text()='Child "+i+"']/following::select[1]/option[@value='"+data.getProperty("Child"+i+"")+"']")).click();
                System.out.println("Child "+i+" Available");
                }

                else{
                    System.out.println("Child "+i+" Not Available");
                }
            }


            Thread.sleep(2000);
            driver.findElement(xpaths.ApplyBTN).click();
            Thread.sleep(8000);
    
       
         
        List<WebElement> element1 = driver.findElements(xpaths.HotelName);
        List<WebElement> element2 = driver.findElements(xpaths.Type);
        List<WebElement> Distance = driver.findElements(xpaths.Distance);
        List<WebElement> Rating = driver.findElements(xpaths.Rating);
        List<WebElement> Reviews = driver.findElements(xpaths.Reviews);
        List<WebElement> Prices = driver.findElements(xpaths.Prices);
        List<WebElement> TotalStayPrice = driver.findElements(xpaths.TotalStayPrice);
        List<WebElement> BookingSite1 = driver.findElements(xpaths.BookingSite1);
        List<WebElement> BookingSite2 = driver.findElements(xpaths.BookingSite2);
        List<WebElement> BookingSite3 = driver.findElements(xpaths.BookingSite3);
        List<WebElement> OtherPrices = driver.findElements(xpaths.OtherPrices);
        List<WebElement> OtherPrices2 = driver.findElements(xpaths.OtherPrices2);
        List<WebElement> StayPrice = driver.findElements(xpaths.StayPrice);
        List<WebElement> StayPrice2 = driver.findElements(xpaths.StayPrice2);

     
//        int countElement1 = element1.size();
//        int countElement2 = element2.size();
//        int countElement3 = Distance.size();
//        int countElement4 = Rating.size();
//        int countElement5 = Reviews.size();
//        int countElement6 = Prices.size();
//        
//        int[] counts = {countElement1, countElement2, countElement3, countElement4, countElement5, countElement6};
//
//        for (int count : counts) {
//            System.out.println(count);
//        }
        // for (WebElement element : elements) {
        //     String Names = element.getText();
        //     System.out.println(Names);
        //     for (WebElement element1 : elements1) {
        //         String Titles = element1.getText();
        //         System.out.println(Titles);
        //         break;
        //     }
      





int maxSize = Math.max(element1.size(), Math.max(element2.size(), Math.max(Distance.size(), Math.max(Rating.size(), Math.max(Reviews.size(), Math.max(Prices.size(), Math.max(BookingSite1.size(),
		Math.max(TotalStayPrice.size(), Math.max(BookingSite2.size(), Math.max(BookingSite3.size(), Math.max(OtherPrices.size(), Math.max(OtherPrices.size(), Math.max(StayPrice2.size(),  StayPrice.size())))))))))))));

        try {
            // Write data to the file
            FileWriter fileWriter = new FileWriter("webElementData.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < maxSize; i++) {
                if (i < element1.size()) {
                    bufferedWriter.write(element1.get(i).getText() + "\n");
                }
                if (i < element2.size()) {
                    bufferedWriter.write(element2.get(i).getText() + "\n");
                }
                if (i < Distance.size()) {
                    bufferedWriter.write(Distance.get(i).getText() + "\n"+"Rating:");
                }
                if (i < Rating.size()) {
                    bufferedWriter.write(Rating.get(i).getText());
                    
                }
                else
                {
                	bufferedWriter.write("\n");
                }
                if (i < Reviews.size()) {
                    bufferedWriter.write(Reviews.get(i).getText() + "\n");
                }
                else
                {
                	bufferedWriter.write("\n");
                }
                if (i < BookingSite1.size()) {
                    bufferedWriter.write(BookingSite1.get(i).getText() + ": ");
                }
                else
                {
                	bufferedWriter.write("\n");
                }
                if (i < Prices.size()) {
                    bufferedWriter.write(Prices.get(i).getText());
                }
                else
                {
                	bufferedWriter.write("\n");
                }
                if (i < TotalStayPrice.size()) {
                    bufferedWriter.write(TotalStayPrice.get(i).getText() + "\n");
                    
                }
                else
                {
                	bufferedWriter.write("\n");
                }
                if (i < BookingSite2.size()) {
                	bufferedWriter.write(BookingSite2.get(i).getText() + ": ");
                }
                else
                {
                	bufferedWriter.write("\n");
                }
                if (i < OtherPrices.size()) {
                	bufferedWriter.write(OtherPrices.get(i).getText());
                }
                else
                {
                	bufferedWriter.write("\n");
                }
                if (i < StayPrice.size()) {
                	bufferedWriter.write(StayPrice.get(i).getText() + "\n");
                }
                else
                {
                	bufferedWriter.write("\n");
                }
                if (i < BookingSite3.size()) {
                	bufferedWriter.write(BookingSite3.get(i).getText() + " ");
                }
                else
                {
                	bufferedWriter.write("\n");
                }
                if (i < OtherPrices2.size()) {
                	bufferedWriter.write(OtherPrices2.get(i).getText());
                }
                else
                {
                	bufferedWriter.write("\n");
                }
                if (i < StayPrice2.size()) {
                	bufferedWriter.write(StayPrice2.get(i).getText() + "\n");
                }

                bufferedWriter.write("\n");
            }

            bufferedWriter.close();
            System.out.println("Hotel data has been written to webElementData.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }




       

        Thread.sleep(10000);

    }
    

            
}