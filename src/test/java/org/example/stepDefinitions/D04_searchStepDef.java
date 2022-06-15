package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import org.example.pages.P03_homePage;

public class D04_searchStepDef {

    P03_homePage homePage = new P03_homePage(Hooks.driver);
    String searchedProduct;

    @Given("^Type \"(.*)\" on search text box$")
    public void search_Product(String product){
        homePage.search.sendKeys(product);
        searchedProduct = product;
    }

    @When("Click on SEARCH button")
    public void clickSearch(){
        homePage.searchButton.click();
        Hooks.rest();
    }

    @Then("User could find Apple products")
    public void apple_Product(){
        SoftAssert searchAssertion = new SoftAssert();
        searchAssertion.assertEquals(homePage.searchKeyword.getAttribute("value"),searchedProduct);
        searchAssertion.assertAll();
    }

    @Then("User could find Apple product")
    public void sku_apple_Product(){
        SoftAssert searchAssertion = new SoftAssert();
        searchAssertion.assertEquals(homePage.searchKeyword.getAttribute("value"),searchedProduct);
        searchAssertion.assertAll();
    }

}
