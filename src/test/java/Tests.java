import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;

public class Tests extends Utils {

    @Test
    public void fullUserJourneyTest() {
        // Экран авторизации / выбора страны
        LoginPage loginPage = new LoginPage(driver);
        loginPage.selectCountry("Afghanistan");
        loginPage.enterName("Дмитро");
        loginPage.clickLetsShop();

        // Экран товаров
        ProductPage productPage = new ProductPage(driver);
        productPage.addSecondProductToCart();   // ← добавляем второй товар
        productPage.goToCart();

        // Кошик
        CartPage cartPage = new CartPage(driver);
        assert cartPage.isProductWithNameInCart("Air Jordan 1 Mid SE")
                : "❌ 'Air Jordan 1 MID SE' не знайдено в кошику!";
    }
    }
