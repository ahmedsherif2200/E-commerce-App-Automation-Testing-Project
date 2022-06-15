package org.example.stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


import java.time.Duration;

public class Hooks {
    public static WebDriver driver=null;
   @Before
    public void openBrowser() throws InterruptedException {
       //String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
       //System.setProperty("webdriver.chrome.driver", chromePath);
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.navigate().to("https://demo.nopcommerce.com/");
       driver.manage().window().maximize();
       Thread.sleep(2000);

   }
   @After
    public static void close_Browser() throws InterruptedException {
       Thread.sleep(3000);
       driver.quit();
   }
    public static void rest(){

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

}
