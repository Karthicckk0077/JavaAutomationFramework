package base;

import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static ThreadLocal<String> browserName = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static String getBrowser() {
        return browserName.get();
    }
}
