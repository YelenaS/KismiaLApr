package kismiaPageObject;


import org.openqa.selenium.By;

import static kismiaPageObject.MainPage.driver;

public class CorrespondencePage {

    public void writeMessage(String message) {
        driver.findElement(By.xpath(".//*[@id='form-compose']/textarea")).clear();
        driver.findElement(By.xpath(".//*[@id='form-compose']/textarea")).sendKeys(message);

    }

    public void clickSendMsgBtn() {
        driver.findElement(By.xpath(".//*[@id='form-compose']/div/div[1]/button")).click();


    }
}
