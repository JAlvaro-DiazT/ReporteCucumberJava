package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    private WebDriver driver;
    private WebDriverWait ewait;
    public Base(WebDriver driver){
        this.driver = driver;
        ewait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }
    public void type(String inputText, By locator){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(inputText);
    }
    public void click(By locator){
        ewait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }
    public Boolean isDisplayed(By locator){
        try{
            ewait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
}
