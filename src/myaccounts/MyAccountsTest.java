package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {
        try {
            List<WebElement> list = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu dropdown-menu-right']//li"));
            for (WebElement listOfElement : list) {
                if (listOfElement.getText().equals(option)) {
                    listOfElement.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            List<WebElement> list = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu dropdown-menu-right']//li"));
        }
    }



    @Test
        //Test name verifyThatUserRegisterAccountSuccessfully()
    public void verifyThatUserRegisterAccountSuccessfully() {
        //Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //Enter First Name
        sendTextToElement(By.name("firstname"), "Chancy");
        //Enter Last Name
        sendTextToElement(By.name("lastname"), "Shah");
        //Enter Email
        sendTextToElement(By.name("email"), "cshah12@gmail.com");
        //Enter Telephone
        sendTextToElement(By.name("telephone"), "1234567890");
        //Enter Password
        sendTextToElement(By.id("input-password"), "cs@123");
        //Enter Password Confirm
        sendTextToElement(By.id("input-confirm"), "cs@123");
        //Select Subscribe Yes radio button
        clickOnElement(By.xpath("(//input[@type='radio'])[2]"));
        //Click on Privacy Policy check box
        clickOnElement(By.name("agree"));
        //Click on Continue button
        clickOnElement(By.xpath("//input[@type='submit']"));
        //Verify the message “Your Account Has Been Created!”
        verifyFromElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"), "Your Account Has Been Created!");
        //Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
         //Click on My Account Link.
        clickOnElement(By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'])[3]"));
         //Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
         //Verify the text “Account Logout”
        verifyFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");
         //Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
         //Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
         //Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
         //Enter Email address
        sendTextToElement(By.id("input-email"), "cshah12@gmail.com");
         //Enter Password
        sendTextToElement(By.name("password"), "cs@123");
         //Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
         //Verify text “My Account”
        verifyFromElement(By.xpath("//h2[contains(text(),'My Account')]"), "My Account");
         //Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
         //Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
          //Verify the text “Account Logout”
        verifyFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");
         //Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @After
    public void tearDown() {
        closeBrowser();
        }

    }

