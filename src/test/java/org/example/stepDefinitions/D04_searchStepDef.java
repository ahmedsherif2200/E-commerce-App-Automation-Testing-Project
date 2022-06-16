package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {
    public int productList(){
        int size=Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).size();
        return size;
    }

    @When("User Search For Apple Products in the Search field")
    public void search_Product(){

        Hooks.driver.findElement(By.cssSelector("input[id=\"small-searchterms\"]")).sendKeys("Apple");
        Hooks.driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
    }


    @Then("User could find Apple products")
    public void apple_Product(){
        SoftAssert searchAssertion = new SoftAssert();
        searchAssertion.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/search?q=Apple");
        int size = Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).size();
        searchAssertion.assertTrue(size>0);
        searchAssertion.assertAll();
    }
    @When("User Search For Products With Sku in the Search field")
    public void Sku_Search(){
        Hooks.driver.findElement(By.cssSelector("input[id=\"small-searchterms\"]")).sendKeys("AP_MBP_13");
        Hooks.driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        Hooks.driver.findElement(By.cssSelector("h2 a[href=\"/apple-macbook-pro-13-inch\"]")).click();
    }

    @Then("Product With the Same Sku is Displayed")
    public void sku_apple_Product(){
//        Hooks.driver.findElement(By.cssSelector("h2 a[href=\"/apple-macbook-pro-13-inch\"]")).click();
//        String sku = Hooks.driver.findElement(By.cssSelector("span[id=\"sku-4\"]")).getText();
//        System.out.println(sku);
//        SoftAssert Sure = new SoftAssert();
//        Sure.assertEquals(sku,"AP_MBP_13");
//        Sure.assertAll();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/apple-macbook-pro-13-inch"),"URL after search");
        int size =productList();
        softAssert.assertTrue(size>0,"Search result size");
        softAssert.assertAll();

    }



}
