package Functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by Kateryna.Minenok on 13.03.2015.
 */
public class FirstTest {

    @Test
    public void firstTest(){
       WebDriver driver = new FirefoxDriver();
        driver.get("http://bash.im/");
        driver.quit();

    }
}
