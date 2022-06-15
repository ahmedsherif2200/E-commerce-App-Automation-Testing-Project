package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P04_productPage {

    WebDriver driver;

    public P04_productPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement>wishlistBts(){
       return Hooks.driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]")) ;
    }


    @FindBy(id = "add-to-cart-button-4")
    public WebElement addCart;


    public List<WebElement>wishlisticns(){
        return Hooks.driver.findElements(By.id("add-to-cart-button-4") ) ;
    }

}
