package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CartPage {
    private AppiumDriver driver;

    public CartPage(AppiumDriver driver) {
        this.driver = driver;
    }

    private By termsCheckbox = By.className("android.widget.CheckBox");

    public void acceptTerms() {
        driver.findElement(termsCheckbox).click();
    }
}

