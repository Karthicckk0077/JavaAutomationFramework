package demoTestPage;

import Utils.FileRenamer;
import Utils.ScreenshotUtil;
import base.BaseTest;
import org.example.waitclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectModel.pageObjectModel;
import pageObjectModel.homepageObjectModel;




import java.net.MalformedURLException;
import java.net.URL;

public class demoTestLogin extends BaseTest {


    ChromeOptions chromeOptions;
    EdgeOptions edgeOptions;
    WebDriver driver;



//    @Parameters({"browser"})
//    @BeforeMethod
//    public void afterMethod(String browserName) throws MalformedURLException {
//        System.out.println("We are executing it on " + browserName);
//
//        switch (browserName) {
//            case "chrome":
//                chromeOptions = new ChromeOptions();
//                driver = new RemoteWebDriver(new URL("http://192.168.29.31:4444"), chromeOptions);
//                driver.get("https://demo.evershop.io/account/login");
//                break;
//
//            case "edge":
//                edgeOptions = new EdgeOptions();
//                driver = new RemoteWebDriver(new URL("http://192.168.29.31:4444"), edgeOptions);
//                driver.get("https://demo.evershop.io/account/login");
//                break;
//        }
//    }
@Parameters({"browser"})
@BeforeMethod
public void setUp(String browserName) throws Exception {

    boolean useGrid = Boolean.parseBoolean(System.getProperty("grid", "false"));
    String gridUrl = System.getProperty("gridUrl", "http://localhost:4444/wd/hub");

    System.out.println("Executing on browser: " + browserName);
    System.out.println("Grid execution: " + useGrid);

    if(useGrid){

        switch (browserName){

            case "chrome":
                chromeOptions = new ChromeOptions();
                driver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
                break;

            case "edge":
                edgeOptions = new EdgeOptions();
                driver = new RemoteWebDriver(new URL(gridUrl), edgeOptions);
                break;

            default:
                throw new RuntimeException("Browser not supported: " + browserName);
        }

    } else {

        switch (browserName){

            case "chrome":
                driver = new ChromeDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Browser not supported: " + browserName);
        }
    }

    driver.manage().window().maximize();
    driver.get("https://demo.evershop.io/account/login");
}

    @Test
    public void successLogin() throws MalformedURLException {

        pageObjectModel l = new pageObjectModel(driver);
//        homepageObjectModel h = new homepageObjectModel(driver);


        l.enterCredsandLogin();
        ScreenshotUtil.capture(driver, "login_raw");
        String folderPath = System.getProperty("user.dir") + "/screenshots";
        FileRenamer.renameFiles(folderPath, "LoginTest");
//        h.scrollAndClickItem("Modern Ceramic Vase - White");
    }







}


