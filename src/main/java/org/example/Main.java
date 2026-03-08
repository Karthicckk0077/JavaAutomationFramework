package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.net.MalformedURLException;

public class Main {
    static WebDriver driver;
    static waitclass wait;
    // I have added the driver and wait instance globally //




    public static void main(String[] args) throws MalformedURLException {

        openBrowser();
        wait = new waitclass(driver); // object instance of wait assigned to same driver and the waitclass so i can use the wait methods//
        System.out.println("Browser opened successfully!");
        verifythetext();
        System.out.println("expected string found");
        clickthetext();
        System.out.println("the text is clicked ");



    }

    public static void openBrowser() {

        ChromeOptions chromeOptions = new ChromeOptions();
        try {
             driver = new RemoteWebDriver(new URL("http://192.168.29.31:4444"),chromeOptions);
             driver.get("https://chatgpt.com");

//            driver.findElement(By.xpath("//div[contains(text(),'Maybe later')]")).click();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public static void verifythetext(){

        By maybelater = By.xpath("//div[contains(text(),'Maybe later')]");
        wait.fluentwait(maybelater,10,5);
//        driver.findElement(maybelater).click();

    }
    public static void clickthetext(){
        By maybelater = By.xpath("//div[contains(text(),'Maybe later')]");
        driver.findElement(maybelater).click();

    }
}
