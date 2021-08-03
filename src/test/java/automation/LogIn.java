package automation;

import org.testng.annotations.Test;
import tae.webautomation.LogInPage;
import tae.webautomation.GlobalTrigger;
//import static org.testng.Assert.*;

public class LogIn extends HomeTest {
    @Test (dataProvider = "Credentials",dataProviderClass = DataProvider.class)
    public void login (String email, String pass){
        LogInPage logIn = home.clickLoginButton();
        logIn.setKeys(email,pass);
        GlobalTrigger menu = home.globalIconClick();
        //assertTrue(menu.logOutButtons()==1,"Log In was successful!");
    }
}
