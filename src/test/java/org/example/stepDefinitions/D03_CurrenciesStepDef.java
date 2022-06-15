package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.example.pages.P03_homePage;

public class D03_CurrenciesStepDef {
    P03_homePage homePage = new P03_homePage(Hooks.driver);


    @When("User Select “Euro” from currency dropdown list")
    public void change_currency() throws InterruptedException {

        Select selectCurrency = new Select(Hooks.driver.findElement(By.xpath("//*[@id=\"customerCurrency\"]")));
        selectCurrency.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");

            Thread.sleep(2000);
        }
        @Then("user check if action done successfully")
    public void check_Action(){

        int count= Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")).size() ;


        for (int x=0; x< count; x++){
            String text =Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")).get(x).getText();
            Assert.assertTrue(text.contains("€"));

        }

        }

    }