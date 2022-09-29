package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.asserts.SoftAssert;


public class GoogleHomeTest {
    WebDriver driver;
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

    @Test (description = "Is the Google Page Title correct")
    public void pageTitleTest() {
        driver.get("http://www.google.com"); //TODO move to base URL
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(driver.getTitle(),"Google");
        sa.assertAll();
    }
}