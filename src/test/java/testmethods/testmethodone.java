package testmethods;

import org.example.waitclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;



public class testmethodone {
     ChromeOptions chromeOptions;
     EdgeOptions edgeOptions;
     WebDriver driver;
     waitclass wait;

  @Parameters("browser")
  @BeforeMethod
  public void openbrowser(String browserName) throws MalformedURLException {
      System.out.println(" wer are executing on " + browserName);
      switch (browserName) {
             case "chrome":
                 chromeOptions = new ChromeOptions();
                 driver = new RemoteWebDriver(new URL("http://192.168.29.31:4444"), chromeOptions);
                 driver.get("https://chatgpt.com");
                 break;

              case "edge":
                   edgeOptions = new EdgeOptions();
                   driver = new RemoteWebDriver(new URL("http://192.168.29.31:4444"), edgeOptions);
                   driver.get("https://chatgpt.com");
                   break;

      }
  }
    @Test(priority = 2)
    public void locateAndClick(){

        wait = new waitclass(driver);
        By textField = By.xpath("//*[@id=\"prompt-textarea\"]/p");
        wait.fluentwait(textField,10,5);





    }

    @Test(priority = 1)
    public void locateAndGetText(){

        wait = new waitclass(driver);
        By maybelater = By.xpath("(//div[contains(text(),'What can I help with?')])[1]");
        wait.fluentwait(maybelater,10,5);
        Assert.assertEquals(driver.findElement(maybelater).getText(),"What can I help with?","tesxt does not match");
    }

    @AfterMethod
    public void closebrowser(){
        driver.quit();
        System.out.println("browser closed successfully");

    }




}
