package testlink.tests.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import testlink.steps.TestSteps;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kateryna.Minenok on 20.03.2015.
 */
public class CreateSuiteTest extends TestSteps {
    By testSpecification = By.xpath("html/body/div[3]/a[3]/img");
    By testSuiteOptions = By.xpath("//img[@title='Actions']");
    By testSuiteCreate = By.xpath(".//*[@id='new_testsuite']");
    By testSuiteNameFld = By.id("name");
    By SaveButton = By.name("add_testsuite_button");
    By frameMainFrame = By.xpath("//frame[@name='mainframe']");
    By frameWorkFrame = By.xpath("//frame[@name='workframe']");
    By frameTreeFrame = By.xpath("//frame[@name='treeframe']");
    String testSuiteName = "Test Suite 5";

    private WebElement find(By what) {
        return driver.findElement (what);
    }

    void findAndClick(By what) {
        find (what).click();
    }

    @BeforeSuite
    public void initEnv(){
        driver = new FirefoxDriver();
    }


    @Test
    public void createSuit(){

        Assert.assertTrue(login("admin", "admin"),"Login failed");
        findAndClick(testSpecification);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(find(frameMainFrame));
        driver.switchTo().frame(find(frameWorkFrame));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        findAndClick(testSuiteOptions);
        findAndClick(testSuiteCreate);
        find(testSuiteNameFld).sendKeys(testSuiteName);
        findAndClick(SaveButton);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(find(frameMainFrame));
        driver.switchTo().frame(find(frameTreeFrame));
        Assert.assertTrue(driver.getPageSource().contains(testSuiteName), "Test Suite is not created");




    }



    @AfterSuite
    public void shutEnv(){
        if (driver != null)
            driver.quit();
    }
}
