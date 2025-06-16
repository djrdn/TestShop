package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPage {
    private AppiumDriver driver;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    private By countryDropdown = By.id("android:id/text1");
    private By nameField = By.id("com.androidsample.generalstore:id/nameField");
    private By letsShopButton = By.id("com.androidsample.generalstore:id/btnLetsShop");
    private By maleRadioButton = By.id("com.androidsample.generalstore:id/radioMale");
    private By femaleRadioButton = By.id("com.androidsample.generalstore:id/radioFemale");

    public void selectCountry(String countryName) {
        driver.findElement(countryDropdown).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + countryName + "\"))"
        )).click();
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void clickLetsShop() {
        driver.findElement(letsShopButton).click();
    }

    // Метод для выбора пола
    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(maleRadioButton).click();
        } else if (gender.equalsIgnoreCase("female")) {
            driver.findElement(femaleRadioButton).click();
        } else {
            throw new IllegalArgumentException("Invalid gender: " + gender);
        }
    }
}