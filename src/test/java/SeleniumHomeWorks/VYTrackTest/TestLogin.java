package SeleniumHomeWorks.VYTrackTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestLogin {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("Chrome");
        driver.get("https://qa2.vytrack.com/user/login");

        WebElement idInputBox = driver.findElement(By.name("_username"));
        idInputBox.sendKeys("salesmanager110");
        BrowserUtils.wait(2);

        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        BrowserUtils.wait(2);
        driver.findElement(By.name("_submit")).click();
        BrowserUtils.wait(5);
        driver.findElement(By.className("fa-caret-down")).click();
        driver.findElement(By.xpath("//a[@href='/user/logout' and text()='Logout']")).click();
        BrowserUtils.wait(1);
        driver.close();

    }
}
