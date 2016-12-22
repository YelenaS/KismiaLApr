package kismiaTests;

import kismiaPageObject.ChatListPage;
import kismiaPageObject.MainPage;
import kismiaPageObject.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static kismiaPageObject.MainPage.driver;
import static org.testng.Assert.assertTrue;

/**
 * Created by Администратор on 30.11.2016.
 */
public class SendGift {
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

    @Test(dependsOnMethods = "login")
    public void sendGift() {
        ProfilePage profile = new ProfilePage();
        ChatListPage chatList = profile.toChatList();
        chatList.sendRandomGift();

        //Проверка
        chatList.findRecipient();

        List<WebElement> elements = new ArrayList<>
                (driver.findElements(By.xpath(".//*[@id='list']")));
        /*for (element )

        int lastInd = elements.size() - 1;
        System.out.println("Всего сообщений в переписке : " + lastInd);
        System.out.println("Так выглядит elements.get(lastInd): " + elements.get(lastInd));*/
        //System.out.println();
        /*assertTrue(elements.get(lastInd).getLocation().toString().contains
                ("./*//*[@id='list']/li[17]/p/span/img or img"));
        System.out.println("Подарок успешно отправлен!");*/
    }
}




