package pom;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hook {
    private static WebDriver driver;

    @Before
    public void setUp()  {
        driver = chromeDriverConnection();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://localhost:8080");
        driver.manage().window().maximize();
    }

    private WebDriver chromeDriverConnection() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    @After
    public void tearDown(){
        driver.quit();
    }
    public static WebDriver getDriver() {
        return driver;
    }
}
