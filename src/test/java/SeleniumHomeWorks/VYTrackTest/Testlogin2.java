package SeleniumHomeWorks.VYTrackTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Testlogin2 {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://qa2.vytrack.com/user/login");
        WebElement IdInput = driver.findElement(By.name("_username"));
        IdInput.sendKeys("salesmanager110");
        BrowserUtils.wait(2);
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        BrowserUtils.wait(2);
        driver.findElement(By.name("_submit")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("href=/entity/Extend_Entity_VehicleContract")).click();








    }

}
