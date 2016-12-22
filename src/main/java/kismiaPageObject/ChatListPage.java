package kismiaPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static kismiaPageObject.MainPage.driver;

/**
 * Created by Администратор on 30.11.2016.
 */
public class ChatListPage {

// findRecipient():
// находит юзера в чат-листе по треду в xpath-е и кликает на ИМЯ.
// Чтоб поменять юзера над поменять тред в xpath.
// Если нет истории переписки, то не найдет юзера в чат-листе
// ОТКРЫВАЕТСЯ СТРАНИЦА ПЕРЕПИСКИ с этим юзером.

    public CorrespondencePage findRecipient() {
        driver.findElement(By.xpath(".//h2//a[@href='/thread22870911']")).click();
        return new CorrespondencePage();
    }

    public void sendRandomGift() {
        // ActionChainsGenerator builder = ((HasInputDevices) driver).actionsBuilder();

        Actions builder = new Actions(driver);

        builder
                .moveToElement(driver.findElement(By.xpath(".//li[4]//a[@href=" +
                        "'javascript:MessagesIndexAction.sendGift(22870911, true);']/../..")))
                .moveToElement(driver.findElement(By.xpath(".//*[@id='content']//ul/li[4]/a[@href=" +
                        "'javascript:MessagesIndexAction.sendGift(22870911, true);']")))
                .click().build().perform();


        //поп-ап. Сообщение: Подарок отправлен! Хотите получать уведомления..? ДА a[1] НЕТ a[2]
        if (driver.findElement(By.cssSelector("#dialog-form")).isDisplayed()) {
            driver.findElement(By.xpath(".//*[@id='dialog-form']/div/div/a[2]")).click();
        }

        List<WebElement> elements = new ArrayList<>
                (driver.findElements(By.xpath(".//div[@class='gifts']/div")));
        Random rand = new Random();
        int size = elements.size();
        int indGift;
        for (WebElement element : elements) {
            indGift = rand.nextInt(size);
            elements.get(indGift).click();
            driver.findElement(By.xpath
                    (".//*[@id='send_gift']//div/button[@type='submit']")).click();
            break;
        }

        //поп-ап. Сообщение: Подарок отправлен!
        if (driver.findElement(By.cssSelector("#dialog-form")).isDisplayed()) {
            driver.findElement(By.xpath
                    (".//*[@id='dialog-form']/div/div/a[contains(text(), 'OK')]")).click();
        }
    }
}