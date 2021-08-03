package tae.webautomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteAccount {
    private WebDriver driver;
    public DeleteAccount(WebDriver driver){
        this.driver = driver;
    }
    public void deleteAccount(){
        WebDriverWait wait = new WebDriverWait(driver,35);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("a#cancel-account"),1));
        try
        {driver.findElement(By.cssSelector("a#cancel-account")).click();
        }catch(org.openqa.selenium.StaleElementReferenceException ex)
        {driver.findElement(By.cssSelector("a#cancel-account")).click();
        }
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("button[ng-click=\"vm.confirm()\"]"),1));
        driver.findElement(By.cssSelector("button[ng-click=\"vm.confirm()\"]")).click();
        driver.switchTo().defaultContent();
    }
}
