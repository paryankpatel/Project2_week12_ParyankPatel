package utilities;

import basetest.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    public void sendTextToElement(By by,String text){
        driver.findElement(by).sendKeys(text);
    }
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    public void switchToAlert(){
        driver.switchTo().alert();
    }
    public void accept(){
        driver.switchTo().alert().accept();
    }
    public void dismiss(){
        driver.switchTo().alert().dismiss();
    }
    public void alertGetText(){
        driver.switchTo().alert().getText();
    }
    public void alertSendText(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // Select by visible text
        select.selectByVisibleText(text);
    }
    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    public void selectByIndexFromDropDown(By by, int index) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }
    public void verifyFromElement(By by, String text){
        String expextedMessage = text;
        WebElement actualElement = driver.findElement(by);
        String actualMessage = actualElement.getText();
        Assert.assertEquals(expextedMessage,actualMessage);
    }
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
}
