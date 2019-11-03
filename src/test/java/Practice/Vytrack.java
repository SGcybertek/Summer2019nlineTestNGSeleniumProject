package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserUtils;

public class Vytrack {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // open a website
        //  go to login page
        //enter credentila + click login buttn
        //verify that user login successfully
        driver.get("https://qa3.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user2");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        //another way of find login bat and click ,

        //verify login by title
        BrowserUtils.wait(2);
        String expectedTitle  = "Dashboard";
        String actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected Result --> "  +expectedTitle);
            System.out.println("Actual result -->" + actualTitle);
        }
        //verify login by URL
        String expectedURL = "https://qa3.vytrack.com/";
        String actualURL = driver.getCurrentUrl();
        if(expectedURL.equals(actualURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected URL --> "  +expectedURL);
            System.out.println("Actual URL -->" + actualURL);
        }
         driver.close();
    }




}
