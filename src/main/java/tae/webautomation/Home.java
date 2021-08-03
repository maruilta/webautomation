package tae.webautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Home {
    private WebDriver driver;

    //Const.
    public Home(WebDriver driver){
        this.driver = driver;
    }

    public GlobalTrigger globalIconClick(){
        driver.findElement(By.cssSelector("a#global-user-trigger")).click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("TV Provider")));
        return new GlobalTrigger(driver);
    }

    public SignUpPage clickSignUpBtn(){
        driver.findElement(By.cssSelector("article#sideLogin-left-rail>button:nth-Child(2)")).click();
        WebDriverWait wait = new WebDriverWait(driver,25);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe#disneyid-iframe[title=\"Account Dialog\"]")));
        return new SignUpPage(driver);
    }
     public boolean checkLogged(){
        if (driver.findElements(By.linkText("Log In")).size()==0){
            return true;
        }else{
            WebElement loginButton = driver.findElement(By.linkText("Log In"));
            return !loginButton.isDisplayed();
        }
    }

    public LogInPage clickLoginButton(){
        driver.findElement(By.cssSelector("article#sideLogin-left-rail>button[tref=\"/members/v3_1/login\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver,25);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe#disneyid-iframe[title=\"Account Dialog\"]")));
        return new LogInPage(driver);
    }
}
