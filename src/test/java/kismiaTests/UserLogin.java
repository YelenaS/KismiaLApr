package kismiaTests;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertTrue;
import kismiaPageObject.MainPage;
import kismiaPageObject.ProfilePage;
import static kismiaPageObject.MainPage.driver;



/**
 * Задачи по Java:
 * Написать пачку тестов с использованием Page Object паттерна. https://kismia.com
 * Для всех тестов создать suite.xml
 * Логин
 * Отправка сообщений
 * Отправка “Подарка”
 * Отправка “Улыбки”
 * Отправка “Приветсвия”
 * Смена языка
 * Удаление \ Восстановление аккаунта
 */
public class UserLogin {

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://kismia.com");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }


    @Test
    public void login() {
        String email = "anis.lena27@gmail.com";
        String password = "230922";
        MainPage main = new MainPage(driver);
        main.inputLogin(email);
        main.inputPass(password);
        ProfilePage profile = main.clickLogInBtn();
        assertTrue(profile.getUrl().contains("u21697770"));

        if (driver.findElement(By.cssSelector("#dialog")).isDisplayed()) {
            driver.findElement(By.cssSelector("#dialog-form > span")).click();
        }
    }
}



