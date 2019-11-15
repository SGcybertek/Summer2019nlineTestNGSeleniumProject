package Test.VYTrackTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NegativeTest {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
         driver.navigate().to("https://yandex.ru/");
         BrowserUtils.wait(3);
         driver.get("https://qa2.vytrack.com/user/login");
        WebElement IdInput = driver.findElement(By.name("_username"));
        IdInput.sendKeys("salesmanager110");
        BrowserUtils.wait(2);
        driver.findElement(By.name("_password")).sendKeys("1234");
        driver.findElement(By.name("_submit")).click();


        WebElement name = driver.findElement
                (By.xpath("//div[@class='alert alert-error']//div"));
        System.out.println(name.getText());


        BrowserUtils.wait(3);


        driver.quit();





    }


}
