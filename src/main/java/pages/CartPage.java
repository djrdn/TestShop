package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.StaleElementReferenceException;
import java.util.List;

public class CartPage {

    private AppiumDriver driver;

    public CartPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // Локатор для названий товаров в корзине
    private By productNames = By.id("com.androidsample.generalstore:id/productName");

    /**
     * Перевіряє наявність товару з певною назвою у кошику.
     * @param expectedName назва товару
     * @return true, якщо знайдено товар з такою назвою
     */
    public boolean isProductWithNameInCart(String expectedName) {
        // Получаем актуальный список элементов
        List<WebElement> productNameElements = driver.findElements(productNames);

        // Итерация по элементам и сравнение их текста с ожидаемым названием
        for (WebElement element : productNameElements) {
            try {
                // Получаем текст элемента и сравниваем
                String actualName = element.getText().trim();
                if (actualName.equalsIgnoreCase(expectedName.trim())) {
                    return true;
                }
            } catch (StaleElementReferenceException e) {
                // Если элемент стал устаревшим, перезагружаем список элементов
                productNameElements = driver.findElements(productNames);
                // Повторяем попытку с обновленным списком
                for (WebElement newElement : productNameElements) {
                    String actualName = newElement.getText().trim();
                    if (actualName.equalsIgnoreCase(expectedName.trim())) {
                        return true;
                    }
                }
            }
        }
        return false;  // Если не найден товар с нужным названием
    }
}
