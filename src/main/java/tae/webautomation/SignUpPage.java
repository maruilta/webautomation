package tae.webautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }
    public void setUpName(String name){
        driver.findElement(By.cssSelector("input[name=\"firstName\"]")).sendKeys(name);
    }
    public void setUpLastName(String lastName){
        driver.findElement(By.cssSelector("input[name=\"lastName\"]")).sendKeys(lastName);
    }
    public void setUpEmail(String email){
        driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys(email);
    }
    public void setUpPassword(String password){
        driver.findElement(By.cssSelector("input[name=\"newPassword\"]")).sendKeys(password);
    }
    public void moveToRegButton(){
        WebElement regButton = driver.findElement(By.cssSelector("button[ng-if=\"!vm.isSetPassword()\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",regButton);
        Actions action = new Actions(driver);
        action.moveToElement(regButton);
    }

    public void clickRegisterButton(){
        driver.findElement(By.cssSelector("button[ng-if=\"!vm.isSetPassword()\"]")).click();
    }
}
