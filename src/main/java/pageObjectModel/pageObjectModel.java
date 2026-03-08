package pageObjectModel;

import org.example.waitclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class pageObjectModel {
    WebDriver driver;
    waitclass wait;

    public pageObjectModel(WebDriver driver) {
        this.driver = driver;
    }

    By userName = By.xpath("//input[@id='field-email']");
    By Password = By.xpath("//input[@id='field-password']");
    By ClickButton = By.xpath("//button[contains(text(),'Sign In')]");
    By product = By.xpath("//*[@id=\"app\"]/div/main/div[3]/div/div[2]/div/div[1]/div/a/div[1]/img");
    By productName = By.xpath("//h1[contains(text(),'Modern Ceramic Vase - White')]");


    public void enterCredsandLogin(){
        driver.findElement(userName).sendKeys("ragadijavi@gmail.com");
        driver.findElement(Password).sendKeys("Password");
        driver.findElement(ClickButton).click();
    }

    public String scrollAndClickProduct() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(product));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        return element.getText();





    }
}
