package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AmazonSearch {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // get  some url
        driver.get("https://www.amazon.com");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String search = "charger";
        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys("charger"+ Keys.ENTER);
        String actual = driver.findElement(By.id("twotabsearchtextbox") )
                .getAttribute("value");

        if(search.equals(actual) ){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
            System.out.println("actual = "+ actual);
            System.out.println("search= "+ search);
        }

        driver.close();

    }
}
