package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphabeticalOrder(){
        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElement(By.xpath("//nav/div/ul/li/a[contains(text(), 'Desktops')]"));
        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        //1.4 Verify the Product will arrange in Descending order
        String expText = "Name (Z - A)";//a[contains(text(),'Show AllDesktops')]
        String actText = getTextFromElement(By.xpath("//select/option[contains(text(), 'Name (Z - A)')]"));
        Assert.assertEquals("Not Matching", expText, actText);

    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        // Mouse hover on Desktops Tab. and click
        mouseHoverToElementAndClick(By.linkText("Desktops"));
       // Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
      // Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.cssSelector("#input-sort"), "Name (A - Z)");
        // Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        // Verify the Text "HP LP3065"
        verifyFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]"), "HP LP3065");
       //  Select Delivery Date "2022-11-30"
        String year = "2022";
        String month = "November";
        String date = "30";

        clickOnElement(By.xpath("(//button[@class='btn btn-default'])[3]"));
        while (true) {
            String monthYear = driver.findElement(By.xpath("(//th[@class='picker-switch'])[1]")).getText();
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("(//th[normalize-space()='›'])[1]"));
            }
        }

        List<WebElement> allDate = driver.findElements(By.xpath("//div[@class='datepicker-days']//table//td"));
        for (WebElement dateList : allDate) {
            if (dateList.getText().equalsIgnoreCase(date)) {
                dateList.click();
                break;
            }
        }
            // Enter Qty "1” using Select class.

           //  Click on “Add to Cart” button
        clickOnElement(By.id("button-cart"));
          // Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        verifyFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"),"Success: You have added HP LP3065 to your shopping cart!\n" + "×");
          // Click on link “shopping cart” display into success message
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[text()='shopping cart']"));
          // Verify the text "Shopping Cart"
        verifyFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]//h1[starts-with(text(),'Shopping Cart')]"),"Shopping Cart  (1.00kg)");
         //Verify the Product name "HP LP3065"
        clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        clickOnElement(By.xpath("//button[contains(text(),'£Pound Sterling')]"));
        verifyFromElement(By.xpath("(//a[text()='HP LP3065'])[2]"),"HP LP3065");
        // Verify the Delivery Date "2022-11-30"
        Thread.sleep(2000);
        verifyFromElement(By.xpath("//small[text()='Delivery Date:2022-11-30']"),"Delivery Date:2022-11-30");
        // Verify the Model "Product21"
        verifyFromElement(By.xpath("//td[contains(text(),'Product 21')]"),"Product 21");
       //  Verify the Todat "£74.73"
        verifyFromElement(By.xpath("(//td[text()='£74.73'])[4]"),"£74.73");


    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
