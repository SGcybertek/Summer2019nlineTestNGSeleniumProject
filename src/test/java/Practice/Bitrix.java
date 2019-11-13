package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Bitrix {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk37@cybertekschool.com");
        driver.findElement(By.xpath(" //*[@placeholder='Password']")).sendKeys("UserUser");
        WebElement header =driver.findElement(By.xpath("//*[@value='Log In']"));
        driver.findElement(By.xpath("//input[starts-with(@value, 'Log')]")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("span[class='feed-add-post-form-link feed-add-post-form-link-active']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("body[style='min-height: 184px;']")).sendKeys("Finally i can type ha ha ");
        BrowserUtils.wait(3);

    }

}
