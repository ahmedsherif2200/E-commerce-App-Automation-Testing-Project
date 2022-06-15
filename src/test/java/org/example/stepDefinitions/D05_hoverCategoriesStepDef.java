package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import org.example.pages.P03_homePage;

public class D05_hoverCategoriesStepDef {

    P03_homePage homePage = new P03_homePage(Hooks.driver);
    Actions hoverAction = new Actions(Hooks.driver);

    @Given("Hover the header menu and select random category then hover it")
        public void hover_menu() {
        hoverAction.moveToElement(homePage.headerMenu).perform();
        Hooks.rest();
        hoverAction.moveToElement(homePage.menuComputers).perform();
        Hooks.rest();
        }

    @When("Click on random sub-category")
    public void click_SubCategory() {

        //hoverAction.moveToElement(homePage.submenudesktops);
        hoverAction.moveToElement(homePage.submenunotebook);
        //hoverAction.moveToElement(homePage.submenuSoftware);
        Hooks.rest();
        hoverAction.click().build().perform();
        Hooks.rest();
    }

    @Then("User could open sub-category page")
    public void open_sub_category(){

        SoftAssert categoryAssertion = new SoftAssert();

      // categoryAssertion.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/desktops");
        categoryAssertion.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/notebooks");
       // categoryAssertion.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/software");

        categoryAssertion.assertAll();
    }

}
