package automation;

import tae.webautomation.SignUpPage;

public class DataProvider extends HomeTest {
    @org.testng.annotations.DataProvider(name = "Credentials")
    public static Object[][] getCredentials(){
        Object[][] data = new Object[1][2];
            data[0][0]="marinacaviola@hotmail.com";
            data[0][1]="TAEglobant!";
        return data;
    }

    public void signUp(String name, String lastname, String email, String pass){
        SignUpPage signup = home.clickSignUpBtn();
        signup.setUpName(name);
        signup.setUpLastName(lastname);
        signup.setUpEmail(email);
        signup.setUpEmail(pass);
        signup.moveToRegButton();
        signup.clickRegisterButton();
    }

    public static void main(String[] args) {
        DataProvider signup = new DataProvider();
        signup.configuration();
        Object[][] keys = signup.getCredentials();
        signup.signUp("Maru", "Ilta",keys[0][0].toString(),keys[0][1].toString());
        signup.closeWindow();
    }
}
