package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ProductPage {

    private AppiumDriver driver;

    public ProductPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // Кнопка "Добавить в корзину" для второго товара по XPath
    private By addSecondProductToCart = By.xpath(
            "(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[2]"
    );

    // Кнопка иконка корзины для перехода в корзину
    private By cartIcon = By.id("com.androidsample.generalstore:id/appbar_btn_cart");

    // Метод для нажатия "Добавить в корзину" на втором товаре
    public void addSecondProductToCart() {
        driver.findElement(addSecondProductToCart).click();
    }

    // Метод для перехода в корзину
    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}
