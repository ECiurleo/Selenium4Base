package tests;

import elements.BingHomeElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.asserts.SoftAssert;


public class BingHomeTest {
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
        driver.get("http://www.bing.com"); //TODO move to baseURL
        SoftAssert sa = new SoftAssert();

        sa.assertEquals(driver.getTitle(), "Bing","The page title for the page returned was " + driver.getTitle());

        //Perform a search
        driver.findElement(BingHomeElements.searchBox).sendKeys("Apple");
        driver.findElement(BingHomeElements.searchBox).sendKeys(Keys.RETURN);

        sa.assertEquals(driver.getTitle(), "Apple - Search","The page title for the page returned was " + driver.getTitle());

        //Assert it all
        sa.assertAll();
    }

}