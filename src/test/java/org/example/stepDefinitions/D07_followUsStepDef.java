package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import org.example.pages.P03_homePage;


public class D07_followUsStepDef {

    P03_homePage homePage = new P03_homePage(Hooks.driver);
    Actions action = new Actions(Hooks.driver);
    SoftAssert sAssert = new SoftAssert();



    @Given("Scroll down to the bottom")
    public void scroll_Down(){
        JavascriptExecutor executor = (JavascriptExecutor) Hooks.driver;
        executor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Hooks.rest();

    }

    @When("Click on facebook icon")
    public void click_Facebook() throws InterruptedException {
        homePage.facebook.click();
        Thread.sleep(2000);
        action.sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.TAB));
    }

    @When("Click on twitter icon")
    public void click_Twitter() throws InterruptedException {
        homePage.twitter.click();
        Thread.sleep(3000);
        action.sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.TAB));
    }

    @When("Click on rss icon")
    public void click_RSS() throws InterruptedException {

        action.keyDown(Keys.LEFT_CONTROL).click(homePage.rss).keyUp(Keys.LEFT_CONTROL).build().perform();
        Thread.sleep(3000);
        action.sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.TAB));
    }

    @When("Click on youtube icon")
    public void click_Youtube() throws InterruptedException {
        homePage.youtube.click();
        Thread.sleep(6000);
        action.sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.TAB));
    }

    @Then("User could open facebook page")
    public void facebook_Open(){
        sAssert.assertEquals(homePage.facebook.getAttribute("href"),"http://www.facebook.com/nopCommerce");
        sAssert.assertAll();
    }

    @Then("User could open twitter page")
    public void twitter_Open(){
        sAssert.assertEquals(homePage.twitter.getAttribute("href"),"https://twitter.com/nopCommerce");
        sAssert.assertAll();
    }

    @Then("User could open rss page")
    public void rss_Open(){
        //sAssert.assertEquals(homePage.rss.getAttribute("href"),"https://demo.nopcommerce.com/news/rss/1");
        sAssert.assertEquals(homePage.rss.getAttribute("href"),"https://demo.nopcommerce.com/new-online-store-is-open");

        sAssert.assertAll();
    }

    @Then("User could open youtube page")
    public void youtube_Open(){
        sAssert.assertEquals(homePage.youtube.getAttribute("href"),"http://www.youtube.com/user/nopCommerce");
        sAssert.assertAll();
    }

}
