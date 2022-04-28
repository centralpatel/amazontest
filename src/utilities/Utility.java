package utilities;

import browsertesting.BaseTest;
import com.beust.jcommander.internal.Nullable;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
    /**
     * *This method will click on element
     */
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }
    /**
     * *This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    /**
     * *This method will send text element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    //***************************************  Alerts Methods ****************************//

    /**
     * This method will switch to alert
     */
    public void switchToAlert(){
        driver.switchTo().alert();
    }

    /**
     * This method will accept the alert
     */
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    //This method for dismiss alert
    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    //This method will get text from alert
    public String getTextFromAlert() {
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        System.out.println(textOnAlert);
        return textOnAlert;
    }

    //*************************** Select class methods **************************************//
    /**
     * This method will select the option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    public void selectByIndexFromDropDown(By by, int indexNo) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(indexNo);
    }

//    public void mouseClick(By by) {
//        Actions actions = new Actions(driver);
//        WebElement mouseClickOnly = driver.findElement(by);
//        actions.moveToElement(mouseClickOnly).click().build().perform();
//    }
//    public void mouseHover(By by){
//        Actions actions = new Actions(driver);
//        WebElement mouseHoverOnly = driver.findElement(by);
//        actions.moveToElement(mouseHoverOnly).build().perform();
//
//    }

    public void verifyText(String exceptedMessage, String actualMessage, @Nullable String errorMessage) {
        Assert.assertEquals(errorMessage == null ? "" : errorMessage, exceptedMessage, actualMessage);
    }

    public void mouseClick(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        Thread.sleep(2000);
        actions.moveToElement(mouseHoover).click().build().perform();
    }

    public void mouseHover(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        Thread.sleep(2000);
        actions.moveToElement(mouseHoover).build().perform();
    }

    public void scrolldown (By by) throws InterruptedException{
        Actions actions = new Actions(driver);
        WebElement mouseScrollDown = driver.findElement(by);
        Thread.sleep(2000);
        actions.moveToElement(mouseScrollDown).build().perform();
    }
    public void scrollup (By by) throws InterruptedException{
        Actions actions = new Actions(driver);
        WebElement mouseScrollDown = driver.findElement(by);
        Thread.sleep(2000);
        actions.moveToElement(mouseScrollDown).build().perform();
    }
    // This method will drag an element and drop it onto another
    public void dragAndDrop(By drag, By drop) {
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(drag);
        WebElement droppable = driver.findElement(drop);
        actions.dragAndDrop(draggable, droppable).build().perform();
    }

    // This method is for keyboard events on elements
    public void sendKeysToElement(By by, CharSequence keys) {
        driver.findElement(by).sendKeys(keys);
    }
    // This method is for keyboard events (e.g. CTRL + A, CTRL + C, CTRL + V)
    public void sendKeys(@Nullable CharSequence precedingKeys, CharSequence keys) {
        new Actions(driver).keyDown(precedingKeys).sendKeys(keys).build().perform();
    }
    public void verifyText(String expectedMessage, By by, String displayMessage) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }
    // this method click in=on the menu what ever name is pass as a parameter
    public void selectMenu(String menu)
    {
        clickOnElement(By.linkText(menu));
    }
    //verify method -2
    public void messageValidation(String ExpMsg, String ActMsg)
    {
        Assert.assertEquals("Message is not as per Project Requirement:", ExpMsg, ActMsg);
    }
    /**
     * Validate Checkbox isSelected method and click
     */
    public void setCheckBoxElement(By by) {
        WebElement checkBoxElement = driver.findElement(by);
        boolean isSelected = checkBoxElement.isSelected();
        if (isSelected == false) {
            checkBoxElement.click();
        }
    }
    public void verifyUrl (String text){
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "" );
    }//Validate Radio button using isSelected() method
    public void setRadioElement(By by) {
        WebElement radioElement = driver.findElement(by);
        boolean selectState = radioElement.isSelected();
        if (selectState == false) {
            radioElement.click();
        }
    }
    public void productsDisplayed (By by, long actualQuantity, String displayedMessage) {
        List<WebElement> elementList = driver.findElements(by);
        long expectedQuantity = elementList.size();
        Assert.assertEquals(displayedMessage, actualQuantity, expectedQuantity);
    }
    public void productsList(By by){
        List<WebElement> productName = driver.findElements(by);
        for (WebElement name:productName) {
            System.out.println(name.getText());
        }
    }
}
