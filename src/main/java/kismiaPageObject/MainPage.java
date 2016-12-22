package kismiaPageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by Администратор on 29.11.2016.
 */
public class MainPage {

    public static WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }



    public void inputLogin(String email) {
        driver.findElement(By.xpath(".//*[@id='user-email']")).clear();
        driver.findElement(By.xpath(".//*[@id='user-email']")).sendKeys(email);
    }


    public void inputPass(String pass) {
        driver.findElement(By.xpath(".//*[@id='user-password']")).clear();
        driver.findElement(By.xpath(".//*[@id='user-password']")).sendKeys(pass);
    }


    public ProfilePage clickLogInBtn() {
        driver.findElement(By.xpath(".//*[@id='sign-in-form']/button")).click();
        return new ProfilePage();
    }
}
