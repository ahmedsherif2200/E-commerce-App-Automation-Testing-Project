package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.example.pages.P03_homePage;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {

    P02_login loginPage = new P02_login(Hooks.driver);
    P03_homePage homePage = new P03_homePage(Hooks.driver);

    @Given("Click on Login tab")

    public void click_Login_Tab(){

        homePage.loginTab.click();
    }

    @When("^User enter \"(.*)\" and \"(.*)\"$")
    public void enter_Data(String email, String password){

        loginPage.enterLogin(email, password);
    }

    @And("Click on login button")
    public void Login_Button(){
        loginPage.loginButton.click();
        Hooks.rest();
    }

    @Then("User could login successfully")
    public void success_login(){

        SoftAssert loginAssertion = new SoftAssert();

        loginAssertion.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
        loginAssertion.assertTrue(homePage.myAccountTab.isDisplayed());
        loginAssertion.assertAll();
    }
    @Then("User could not login")
    public void wrong_login(){

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.wronglogin.getText().contains("Login was unsuccessful. Please correct the errors and try again."));

        softAssert.assertAll();
    }



}
