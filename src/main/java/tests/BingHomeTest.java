package tests;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import testdata.BingHomeData;
import pageelements.BingHomeElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.asserts.SoftAssert;

import java.util.List;


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

    @Test (description = "Is the Bing Search Result Page Title correct?")
    public void pageTitleTest() {
        driver.get(BingHomeData.bingHomeURL);
        SoftAssert sa = new SoftAssert();

        sa.assertEquals(driver.getTitle(), BingHomeData.bingHomeTitle,"The page title for the page returned was " + driver.getTitle());

        //Perform a search
        driver.findElement(BingHomeElements.searchBox).sendKeys(BingHomeData.bingHomeSearch);
        driver.findElement(BingHomeElements.searchBox).sendKeys(Keys.RETURN);

        sa.assertEquals(driver.getTitle(), BingHomeData.bingHomeSearchResult,"The page title for the page returned was " + driver.getTitle());

        //Output any console errors
        LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> Logs = entry.getAll();
        for (LogEntry log : Logs){
            System.out.println("Error Level \n" +log.getLevel());
            System.out.println("Message in console \n" +log.getMessage());
        }
        sa.assertEquals(Logs.size(), 0, "Errors present in console");

        //Assert it all
        sa.assertAll();
    }

}