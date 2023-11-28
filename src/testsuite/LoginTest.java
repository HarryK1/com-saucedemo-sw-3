package testsuite;
/*
 * 4. Write down the following test into ‘LoginTest’
 * class
 * 1. userSholdLoginSuccessfullyWithValid
 *
 * Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 *
 * 2. verifyThatSixProductsAreDisplayedOnPage
 *
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed
 * on page
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter “standard_user” username
        sendTextToElements(By.id("user-name"), "standard_user");
        //Enter “secret_sauce” password
        sendTextToElements(By.id("password"), "secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        //Verify the text “Products”
        String expectedText = "Products";
        String actualText = getTextFromElement(By.cssSelector(".title"));
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” username
        sendTextToElements(By.id("user-name"), "standard_user");
        //Enter “secret_sauce” password
        sendTextToElements(By.id("password"), "secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        //Verify that six products are displayed on page
        List<WebElement> productList = driver.findElements(By.className("inventory_item"));
        System.out.println("Total products: " + productList.size());
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
