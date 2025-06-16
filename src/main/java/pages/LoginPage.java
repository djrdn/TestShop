package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private AppiumDriver driver;
    private WebDriverWait wait;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Локатор, который открывает список стран (например, поле выбора страны)
    private By countryDropdown = By.id("com.androidsample.generalstore:id/spinnerCountry");
    // Локатор стран внутри списка
    // Элемент списка будет найден динамически через UiScrollable, поэтому не надо заранее указывать id для стран

    private By nameField = By.id("com.androidsample.generalstore:id/nameField");
    private By letsShopButton = By.id("com.androidsample.generalstore:id/btnLetsShop");
    private By maleRadioButton = By.id("com.androidsample.generalstore:id/radioMale");
    private By femaleRadioButton = By.id("com.androidsample.generalstore:id/radioFemale");

    public void selectCountry(String countryName) {
        // Кликаем по элементу, который открывает выпадающий список стран
        wait.until(ExpectedConditions.elementToBeClickable(countryDropdown)).click();

        // Скроллим и кликаем по нужной стране
        By countryLocator = AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + countryName + "\"))"
        );

        wait.until(ExpectedConditions.elementToBeClickable(countryLocator)).click();
    }

    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
    }

    public void clickLetsShop() {
        wait.until(ExpectedConditions.elementToBeClickable(letsShopButton)).click();
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            wait.until(ExpectedConditions.elementToBeClickable(maleRadioButton)).click();
        } else if (gender.equalsIgnoreCase("female")) {
            wait.until(ExpectedConditions.elementToBeClickable(femaleRadioButton)).click();
        } else {
            throw new IllegalArgumentException("Invalid gender: " + gender);
        }
    }
}
