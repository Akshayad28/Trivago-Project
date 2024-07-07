package CraftDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CraftDrivers implements WebDriver, TakesScreenshot, JavascriptExecutor {
    public WebDriver driver;
    private static final String DEFAULT_SCREENSHOT_PATH = "C:\\Users\\aksha\\git\\repository2\\TrivagoHotelSearch\\Screenshots";

    // Constructor to initialize the WebDriver
    public CraftDrivers(WebDriver driver) {
        this.driver = driver;
    }

    // Custom method to take a screenshot
    // public void takeCustomScreenshot(String filePath) {
    //     File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    //     try {
    //         FileUtils.copyFile(screenshotFile, new File("C:\\Users\\aksha\\OneDrive - Kirito\\Desktop\\My Project\\githubdemo\\Screenshots"));
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
    public void takeCustomScreenshot() {
        // Generate a unique file name based on timestamp
        String filePath = DEFAULT_SCREENSHOT_PATH + "\\screenshot_" + System.currentTimeMillis() + ".png";

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(filePath);
        try {
            // Create parent directories if they do not exist
            destinationFile.getParentFile().mkdirs();
            FileUtils.copyFile(screenshotFile, destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectDropdownByVisibleText(By by, String visibleText) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByVisibleText(visibleText);
    }

    // Custom method to select a dropdown value by index
    public void selectDropdownByIndex(By by, int index) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByIndex(index);
    }

    // Custom method to select a dropdown value by value attribute
    public void selectDropdownByValue(By by, String value) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByValue(value);
    }


    // Custom method to execute JavaScript
    public void executeCustomScript(String script) {
        ((JavascriptExecutor) driver).executeScript(script);
    }

    // Implement WebDriver methods
    @Override
    public void get(String url) {
        driver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }

    // Implement TakesScreenshot method
    @Override
    public <X> X getScreenshotAs(OutputType<X> target) {
        return ((TakesScreenshot) driver).getScreenshotAs(target);
    }

    // Implement JavascriptExecutor methods
    @Override
    public Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) driver).executeScript(script, args);
    }

    @Override
    public Object executeAsyncScript(String script, Object... args) {
        return ((JavascriptExecutor) driver).executeAsyncScript(script, args);
    }
}
