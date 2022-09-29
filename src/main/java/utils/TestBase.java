package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    public WebDriver driver;

    @BeforeSuite
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
    }
    @AfterClass
    void teardown() {
        driver.quit();
    }

}
