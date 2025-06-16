import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class Utils {
    protected AppiumDriver driver;

    @BeforeClass
    public void setup() {
        try {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName("android")
                    .setPlatformVersion("16.0")
                    .setDeviceName("emulator-5554")
                    .setApp("C:\\Users\\shef\\Desktop\\AutoTestsMaven\\untitled1\\src\\test\\resources\\app\\unknown.apk")
                    .setNoReset(true);

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Appium server URL", e);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}