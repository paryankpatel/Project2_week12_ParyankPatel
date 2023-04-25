package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        try {
            List<WebElement> list = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
            for (WebElement listOfElement : list) {
                if (listOfElement.getText().equals(menu)) {
                    listOfElement.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            List<WebElement> list = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }

    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
         //Mouse hover on “Desktops” Tab and click
        mouseHoverToElementAndClick(By.linkText("Desktops"));
         //call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show AllDesktops");
         //Verify the text ‘Desktops’
        verifyFromElement(By.xpath("//h2[contains(text(),'Desktops')]"),"Desktops");

    }

    @Test
         //verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
         //Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[text()='Laptops & Notebooks']"));
         //call selectMenu method and pass the menu = “Show All Laptops & Notebooks”

        selectMenu("Show AllLaptops & Notebooks");
         //Verify the text ‘Laptops & Notebooks’
        verifyFromElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"),"Laptops & Notebooks");
    }
    @Test
          //verifyUserShouldNavigateToComponentsPageSuccessfully()
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
         //Mouse hover on “Components” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[text()='Components']"));
        //call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");
       //Verify the text ‘Components’
        verifyFromElement(By.xpath("//h2[contains(text(),'Components')]"),"Components");
    }
    @After
    public void tearDown() {
         closeBrowser();
    }

}
