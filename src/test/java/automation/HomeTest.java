package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import tae.webautomation.Home;

public class HomeTest {
    private WebDriver driver;
    protected Home home;

    @BeforeTest
    public void configuration() {
        System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.espn.com/?src=com&amp;_adblock=true"); //url
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver; //to manage the dom
        home = new Home(driver);
        //Close ads
        int adCounter = driver.findElements(By.cssSelector("iframe[src*=\"banner\"]")).size();
        while (adCounter != 0) {
            driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src*=\"banner\"]")));
            WebElement closeAd = driver.findElement(By.cssSelector("div[class*=\"Close\"][class*=\"Banner\"]"));
            closeAd.click();
            driver.switchTo().defaultContent();
            adCounter = driver.findElements(By.cssSelector("iframe[src*=\"banner\"]")).size();
        }
    }
    //Modify the configuration() using a switch case, one for chrome one for firefox, and configure the suite for the browser.

    //Close browser
    @AfterTest
    public void closeWindow(){
        driver.close();
    }

    //Main
    public static void main(String[] args) {
        HomeTest test = new HomeTest();
        test.configuration();
    }
}
