package Utils;

import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtil {

    public static void capture(WebDriver driver, String fileName) {

        try {
            // Create screenshots folder inside project
            File folder = new File(System.getProperty("user.dir") + "/screenshots");
            if (!folder.exists()) {
                folder.mkdir();
            }

            // Take screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Save file
            File destination = new File(folder + "/" + fileName + ".png");

            Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved: " + destination.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
