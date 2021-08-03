package tae.webautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalTrigger {
    private WebDriver driver;
    //Const.
    public GlobalTrigger(WebDriver driver){
        this.driver = driver;
    }
    public int logOutButtons(){
        return driver.findElements(By.cssSelector("ul.tools>li.user>div.global-user>div.global-user-container>ul>li>a[onclick*=logout]")).size();
    }
    public void returnToMain(){
        driver.switchTo().defaultContent();
    }
    public void clickLogOut(){
        driver.findElement(By.cssSelector("ul.tools>li.user>div.global-user>div.global-user-container>ul>li>a[onclick*=logout]")).click();
        driver.switchTo().defaultContent();
    }
    public DeleteAccount clickProfile(){
        driver.findElement(By.cssSelector("ul.tools>li.user>div.global-user>div.global-user-container>ul>li>a[tref=\"/members/v3_1/modifyAccount\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver,35);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe#disneyid-iframe[title=\"Account Dialog\"]")));
        return new DeleteAccount(driver);
    }
}