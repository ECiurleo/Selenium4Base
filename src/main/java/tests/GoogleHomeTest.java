package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.TestBase;


public class GoogleHomeTest extends TestBase {

    //URL to start everything off from
    public void gotoBaseURL() {
        driver.get("http://www.google.com");
    }

    //Test start here
    @Test (description = "Is the Google Page Title correct")
    public void pageTitleTest() {
        gotoBaseURL();
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(driver.getTitle(),"Google");
        sa.assertAll();
    }
}