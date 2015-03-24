package testlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Kateryna.Minenok on 20.03.2015.
 */
public class HomePage {

    protected WebDriver driver;
    private static final By headerFrame = By.name("titlebar");
    private static final By version =By.xpath("//div[@class='menu_title']/span[contains(text(),'TestLink')]");

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public boolean isOpened(){
        driver.switchTo().frame(driver.findElement(headerFrame));
        Wait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(version));
        // return driver.findElement(version).isDisplayed();
        return !driver.findElements(version).isEmpty();


    }
}
