package browsertesting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {
    //1. Open the URL https://www.amazon.co.uk/
    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyDellLaptopIsDisplayedAndQuantity() throws InterruptedException{
        //2. Type "Dell Laptop" in the search box and press enter or click on search
        //   Button.
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");
        clickOnElement(By.xpath("//input[@id='sp-cc-accept']"));
        System.out.println("Accept Cookies");
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));
        //3. Click on the checkbox brand dell on the left side.
        setCheckBoxElement(By.xpath("//li[@id='p_89/Dell']"));
        //4. Verify that the  30(May be different) products are displayed on the page.
        productsDisplayed(By.xpath("//div[@data-component-type='s-search-result']"),22 , "Error Message");
        //5. Print all product names in the console.
        productsList(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
    }
    @After

    public void tearDown() {
        closeBrowser();
    }
}
