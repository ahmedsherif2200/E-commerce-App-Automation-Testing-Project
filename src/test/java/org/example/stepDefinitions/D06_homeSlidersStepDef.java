package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import org.example.pages.P03_homePage;

public class D06_homeSlidersStepDef {

    P03_homePage homePage = new P03_homePage(Hooks.driver);

    @Given("Click on Nokia banner controller")
    public void nokia_Controller(){

        homePage.controllerNokia.click();
    }

    @When("Click on Nokia banner")
    public void nokia_Banner(){

        homePage.bannerNokia.click();
        Hooks.rest();
    }

    @Then("User could click on the banner and redirect to the Nokia link")
    public void slider_Nokia(){
        SoftAssert slidersAssertion = new SoftAssert();

        slidersAssertion.assertEquals(homePage.bannerNokia.getAttribute("href"), "https://demo.nopcommerce.com/nokia-lumia-1020");
        //slidersAssertion.assertEquals(homePage.bannerNokia.getAttribute("href"), "http://demo.nopcommerce.com/");
        slidersAssertion.assertAll();
    }

    @Given("Click on IPhone banner controller")
    public void iPhone_Controller(){

        homePage.controllerIPhone.click();
    }

    @When("Click on IPhone banner")
    public void iPhone_Banner(){

        homePage.bannerIPhone.click();
    }

    @Then("User could click on the banner and redirect to the IPhone link")
    public void slider_IPhone(){

        SoftAssert slidersAssertion = new SoftAssert();

        slidersAssertion.assertEquals(homePage.bannerIPhone.getAttribute("href"), "https://demo.nopcommerce.com/iphone-6");
        //slidersAssertion.assertEquals(homePage.bannerIPhone.getAttribute("href"), "http://demo.nopcommerce.com/");
        slidersAssertion.assertAll();
    }

}
