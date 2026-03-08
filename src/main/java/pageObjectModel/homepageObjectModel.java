package pageObjectModel;

import org.example.waitclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class homepageObjectModel {
    WebDriver driver;
    waitclass wait;

    public homepageObjectModel(WebDriver driver) {
        this.driver = driver;
    }

    private String itemListLocator = "//div[@class='product__list__item product__list__item__grid']/..//h3[contains(text(),'test')]";

    public void scrollAndClickItem(String itemName) {

        By itemLocator = By.xpath(String.format(itemListLocator, itemName));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(itemLocator)
        );

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }


}
