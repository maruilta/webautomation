package automation;

import org.testng.annotations.Test;
import tae.webautomation.DeleteAccount;
import tae.webautomation.LogInPage;
import tae.webautomation.GlobalTrigger;
//import static org.testng.Assert.assertEquals;

public class Delete extends HomeTest {
    @Test(dataProvider = "Credentials",dataProviderClass = DataProvider.class)
    public void deleteAccount(String email, String pass) {
        if(!home.checkLogged()){
            LogInPage login = home.clickLoginButton();
            login.setKeys(email,pass);
        }
        GlobalTrigger menu = home.globalIconClick();
        DeleteAccount delete = menu.clickProfile();
        delete.deleteAccount();
        LogInPage logIn = home.clickLoginButton();
        String check = logIn.checkDeletion(email,pass);
        System.out.println(check);
        //assertEquals(check,"Account Deactivated","Account Deleted Successfully");
    }
}