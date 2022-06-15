package org.example.stepDefinitions;

import org.example.pages.P01_register;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class D01_registerStepDef {

    P01_register registerPage = new P01_register(Hooks.driver);

    @Given("Click on Register tab")
    public void click_Register_Tab(){
        P03_homePage P03 = new P03_homePage(Hooks.driver);
        P03.registerTab.click();
    }

    @When("Click on any radio button to chose gender")
    public void chose_Gender(){

        registerPage.gender.click();
    }

    @And("User enter First name and Last name")
    public void fill_Name(){
        registerPage.firstName.sendKeys("Ahmed");
        registerPage.lastName.sendKeys("Sherif");
    }

    @And("User Select Date of Birth: Select [Day, Month, Year]")
    public void pick_Date(){


        WebElement birthDay = Hooks.driver.findElement(By.name("DateOfBirthDay"));
        Select select = new Select(birthDay);
        select.selectByIndex(1);

        WebElement birthMonth = Hooks.driver.findElement(By.name("DateOfBirthMonth"));
        select = new Select(birthMonth);
        select.selectByValue("7");

        WebElement birthYear = Hooks.driver.findElement(By.name("DateOfBirthYear"));
        select = new Select(birthYear);
        select.selectByVisibleText("1994");

    }

    @And("^User enter email: \"(.*)\"$")
    public void enter_Email(String email){

        registerPage.email.sendKeys(email);
    }

    @And("Fill Company name")
    public void fill_CompanyName(){

        registerPage.company.sendKeys("Egypt");
    }

    @And("^User enter Password and Confirm it: \"(.*)\"$")
    public void enter_Password(String password){
        registerPage.password.sendKeys(password);
        registerPage.confirmPassword.sendKeys(password);
    }

    @And("Click on REGISTER button")
    public void click_Register_Button(){
        registerPage.registerButton.click();
        Hooks.rest();
    }

    @Then("User could register successfully")
    public void success_Registration(){

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(registerPage.registrationComplete.getText().contains("Your registration completed"));
        softAssert.assertEquals(registerPage.registrationComplete.getCssValue("color"), "rgba(76, 177, 124, 1)");

        softAssert.assertAll();
    }


    @And("Click on CONTINUE button")
    public void clickContinue(){
        registerPage.continueButton.click();
        Hooks.rest();
    }

}
