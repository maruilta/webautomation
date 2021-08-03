package automation;
import org.testng.annotations.Test;
import tae.webautomation.LogInPage;
import tae.webautomation.GlobalTrigger;

public class LogOut extends HomeTest {
    @Test (dataProvider = "Credentials",dataProviderClass = DataProvider.class)
    private void testLogout(String email, String pass) {
        GlobalTrigger menu = home.globalIconClick();
        boolean logged = menu.logOutButtons()==1;
        if(!logged){
            LogInPage login = home.clickLoginButton();
            login.setKeys(email,pass);
        }else{
            menu.returnToMain();
        }
        menu = home.globalIconClick();
        menu.clickLogOut();
        menu = home.globalIconClick();
    }
}
