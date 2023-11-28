package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseURL = "https://www.saucedemo.com/";

    @Before
    public void setUp(){openBrowser(baseURL);}

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //* Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@name='user-name']"), "standard_user");
        //* Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //* Verify the text “Products”
        verifyText("error","Products",By.xpath("//span[@class='title']"));
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //* Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        //* Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //*  Verify that six products are displayed on page
        List<WebElement> productList = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        System.out.println("Product Total : " + productList.size());

    }

    @After
    public void tearDown(){closeBrowser();}
}



