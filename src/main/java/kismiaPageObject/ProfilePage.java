package kismiaPageObject;

import org.openqa.selenium.By;

import static kismiaPageObject.MainPage.driver;


/**
 * Created by Администратор on 29.11.2016.
 */
public class ProfilePage {



    public String getUrl() {
        return "u21697770";
    }

    public ChatListPage toChatList() {

        driver.findElement(By.xpath(".//*[@id='aside']//a[@href='/messages']")).click();
       // By locator = By.xpath(" локатор элемента, который мешает");

       // WebDriverWait wait = new WebDriverWait(driver, 10);

       // wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

        return new ChatListPage();


    }
}
