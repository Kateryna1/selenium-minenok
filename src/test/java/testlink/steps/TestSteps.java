package testlink.steps;

import org.openqa.selenium.WebDriver;
import testlink.pages.LoginPage;

/**
 * Created by Kateryna.Minenok on 20.03.2015.
 */
public class TestSteps {
    protected WebDriver driver;

    public boolean login(String login, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        return loginPage.login(login,password).isOpened();

    }
}
