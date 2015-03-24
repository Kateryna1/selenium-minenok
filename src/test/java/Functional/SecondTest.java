package Functional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SecondTest {

    private By searchField;

    @DataProvider
    public Object[][] searchRule() {
        return new Object[][]{
                 {"word", "lst-ib", "_Rm", "office.live.com", "https://www.google.com.ua"},
                 {"word", "lst-ib", "bc", "www.gcflearnfree.org", "https://www.google.com.ua"},
                 {"word", "lst-ib", "_Rm", "convertonlinefree.com", "https://www.google.com.ua"},
        };
    }

    @Test(dataProvider = "searchRule")
    public void secondTest(String keyWord, String searchId, String searchClass, String resultUrl, String url)  {
        WebDriver driver = new FirefoxDriver();
        int i=1;
        driver.get(url);
        searchField = By.id(searchId);
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(keyWord);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        boolean found = false;
        while (!found && i++<=3) {
            try {
                found = driver.findElement(By.cssSelector("." + searchClass)).getText().contains(resultUrl);
            } catch (Exception e) {
                // do nothing, we expect it
            }
            if (!found) {
                driver.findElement(By.linkText(String.valueOf(i))).click();
                driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            }
        }
        driver.quit();
        Assert.assertTrue(found);
    }
}
