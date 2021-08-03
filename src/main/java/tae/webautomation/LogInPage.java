package tae.webautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
    private WebDriver driver;

    public LogInPage(WebDriver driver){
        this.driver = driver;
    }

    public void setKeys(String email, String pass) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[placeholder=\"Username or Email Address\"]")));
        driver.findElement(By.cssSelector("input[placeholder=\"Username or Email Address\"]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[placeholder=\"Password (case sensitive)\"]")).sendKeys(pass);
        driver.findElement(By.cssSelector("button[ng-click=\"vm.submitLogin()\"]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#global-user-trigger")));
        driver.switchTo().defaultContent();
        }

    public String checkDeletion(String email, String pass) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[placeholder=\"Username or Email Address\"]")));
        driver.findElement(By.cssSelector("input[placeholder=\"Username or Email Address\"]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[placeholder=\"Password (case sensitive)\"]")).sendKeys(pass);
        driver.findElement(By.cssSelector("button[ng-click=\"vm.submitLogin()\"]")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("h2[class=\"title title-primary ng-isolate-scope\"]")));

        return driver.findElement(By.cssSelector("h2[class=\"title title-primary ng-isolate-scope\"]")).getText();
    }
}
