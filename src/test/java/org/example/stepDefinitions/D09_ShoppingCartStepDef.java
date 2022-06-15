package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.example.pages.P04_productPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class D09_ShoppingCartStepDef {

    @Given("Scroll down and choose a random product and click on it")
    public void choose_Product() throws InterruptedException {
        Actions action = new Actions(Hooks.driver);
        action.sendKeys(Keys.chord(Keys.PAGE_DOWN,Keys.PAGE_DOWN));
        Thread.sleep(1000);
        P03_homePage P03 = new P03_homePage(Hooks.driver);
        P03.macbookPicture.click();
        Hooks.rest();
    }

    @When("Click on ADD TO CART button")
    public void add_Cart() throws InterruptedException {
        P04_productPage productPage = new P04_productPage(Hooks.driver);
        productPage.addCart.click();
        Hooks.rest();
        Thread.sleep(1000);
    }

    @Then("the product is added to the user's shopping cart and message appears says The product has been added to your shopping cart")
    public void cartAssertion(){
        P03_homePage homePage = new P03_homePage(Hooks.driver);
        SoftAssert wishlistAssertion = new SoftAssert();
        wishlistAssertion.assertEquals(homePage.successNotificationContent.getText(),"The product has been added to your shopping cart");
        wishlistAssertion.assertEquals(homePage.successNotification.getCssValue("background-color"), "rgba(75, 176, 122, 1)");
        wishlistAssertion.assertAll();
    }

}
