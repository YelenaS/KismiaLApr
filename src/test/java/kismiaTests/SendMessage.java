package kismiaTests;

import kismiaPageObject.ChatListPage;
import kismiaPageObject.CorrespondencePage;
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
public class SendMessage {

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
    public void sendMessage() {
        ProfilePage profile = new ProfilePage();
        CorrespondencePage correspondence = new CorrespondencePage();
        ChatListPage chatList = profile.toChatList();
        chatList.findRecipient();
        String message = "Some text. TEST: try sendMessage() ";
        correspondence.writeMessage(message);
        correspondence.clickSendMsgBtn();

        //ПРОВЕРКА отправленного сообщения в Исходящих
        List<String> messages = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath(".//*[@id='list']"));

        for (WebElement element : elements) {
            message = element.getText();
            messages.add(message);
        }

        for (String element : messages) {
            assertTrue(element.contains("TEST"));
            if (true) {
                System.out.println("Сообщение успешно отправлено");
                break;
            }
        }
    }
}


