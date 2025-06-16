package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ProductPage {

    private AppiumDriver driver;

    public ProductPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // Кнопка "Добавить в корзину" для первого товара
    private By addToCartButton = AppiumBy.androidUIAutomator(
            "new UiSelector().resourceId(\"com.androidsample.generalstore:id/productAddCart\").instance(0)"
    );

    // Кнопка иконка корзины для перехода в корзину
    private By cartIcon = By.id("com.androidsample.generalstore:id/appbar_btn_cart");

    // Метод для нажатия "Добавить в корзину" на первом товаре
    public void addFirstProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    // Метод для перехода в корзину
    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}