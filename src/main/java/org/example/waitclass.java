package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waitclass {

    WebDriver driver;

    public waitclass(WebDriver driver){
        this.driver=driver;

    }


    public void implicitwait(int timeoutsecs){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutsecs));


    }

    public  void explicitwait(By locator,int timeoutsecs){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutsecs));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public  void fluentwait(By locator,int timeoutsecs,int pollsecs){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutsecs))
                .pollingEvery(Duration.ofSeconds(pollsecs))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
