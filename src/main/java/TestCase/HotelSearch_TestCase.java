package TestCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Automation.HotelBooking.BrowserLaunch;
import Automation.HotelBooking.HotelSearch;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HotelSearch_TestCase {

    protected WebDriver driver;
    protected Properties data;

    @BeforeMethod
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aksha\\git\\repository2\\TrivagoHotelSearch\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        FileReader reader = new FileReader("C:\\Users\\aksha\\git\\repository2\\TrivagoHotelSearch\\Data.properties");
        data = new Properties();
        data.load(reader);
    }

    @Test
    public void hotelSearchTest() throws InterruptedException, IOException {
        BrowserLaunch test = new BrowserLaunch();
        HotelSearch out = new HotelSearch();

        test.browser(driver, data);
        out.logIn(driver, data);
        out.Booking(driver, data);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
