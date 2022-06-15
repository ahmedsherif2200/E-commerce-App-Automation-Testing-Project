package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P04_productPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class D08_WishlistStepDef {
    int number;
    P04_productPage productPage = new P04_productPage(Hooks.driver);

    @When("user add product to wishlist")
    public void add_Product() throws InterruptedException {
        productPage.wishlistBts().get(2).click();
        Thread.sleep(1000);
    }

    @Then("after adding the product to wishlist  success message appeared")
    public void success_Message(){

        Assert.assertTrue(Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]")).isDisplayed());

    }

    @And("user get the of wishlist items after adding product")
    public void wishlist_items(){

        String text =Hooks.driver.findElement(By.cssSelector("span[class=\"wishlist-qty\"]")).getText();

        text = text.replaceAll("[^0-9]","");
         number =Integer.parseInt((text));

    }
    @Then("number of wishlist items increased")
    public void items_increased(){

        Assert.assertTrue(number>0);
    }
}
