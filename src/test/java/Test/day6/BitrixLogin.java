package Test.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class BitrixLogin {

    public static void main(String[] args) {
        // getDriver() method returns object of webdriver
        //we need webdriver object to send commands to the browser
        // left side is a reference variable to reuse this object
        // object can be created and used without referance variable,
        // but it's gonna be impossible to use that objct more than once
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //go to Bitrix
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        // enter email
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk37@cybertekschool.com");
        //enter password
        // * matches any element
        //it's better to specify tag name, to avoid
        driver.findElement(By.xpath(" //*[@placeholder='Password']")).sendKeys("UserUser");

       WebElement header =driver.findElement(By.xpath("//*[@value='Log In']"));
         driver.findElement(By.xpath("//input[starts-with(@value, 'Log')]")).click();
         //driver.findElement(By.xpath("//*theme-dialog-item theme-dialog-item-selected")).click();
         BrowserUtils.wait(2);
         driver.findElement(By.cssSelector("span[class='feed-add-post-form-link feed-add-post-form-link-active']")).click();
         // click on login button
        //driver.quit();


    }

}
