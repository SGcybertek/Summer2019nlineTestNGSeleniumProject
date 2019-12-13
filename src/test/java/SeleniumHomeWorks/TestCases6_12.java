package SeleniumHomeWorks;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.BrowserFactory;
import utils.BrowserUtils;



public class TestCases6_12 {



    WebDriver driver;



    @BeforeTest
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }



    @AfterTest
    public void tearDown(){
        driver.close();

    }

    @Test(description = "")
    public void test6(){
        driver.get("https://www.tempmailaddress.com/");
        String emailTemp = driver.findElement(By.id("email")).getText();
        BrowserUtils.wait(3);

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href='/sign_up']")).click();

        driver.findElement(By.cssSelector("[name='full_name']")).sendKeys(Faker.instance().name().fullName());
        driver.findElement(By.cssSelector("[name='email']")).sendKeys(emailTemp, Keys.ENTER);
        BrowserUtils.wait(5);


        String actualRes = driver.findElement(By.name("signup_message")).getText();
        Assert.assertEquals(actualRes, "Thank you for signing up. Click the button below to return to the home page.");

        driver.navigate().to("https://www.tempmailaddress.com/");
        driver.findElement(By.cssSelector("[class='from']")).click();




        String emailFrom = driver.findElement(By.id("odesilatel")).getText();
        String emailSubject = driver.findElement(By.id("predmet")).getText();


        Assert.assertEquals(emailFrom, "do-not-reply@practice.cybertekschool.com");
        Assert.assertEquals(emailSubject,"Thanks for subscribing to practice.cybertekschool.com!");
        //[class='from']>[class='glyphicon glyphicon-envelope']
        BrowserUtils.wait(2);


    }

    @Test(description = "")
    public void test7(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href='/upload']")).click();
        String path = "C:/Users/Sanjar1987/OneDrive/Desktop/day 48 Abstraction";
        driver.findElement(By.id("file-upload")).sendKeys(path);

        driver.findElement(By.id("file-submit")).click();


        String resConf = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(resConf,"File Uploaded!");

        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName, path.substring(path.lastIndexOf("/")+1));

    }


    @Test(description = "")
    public void test8() {

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href='/autocomplete']")).click();

        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("[value='Submit']")).click();

        String resSelected = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(resSelected,"You selected: United States of America");

    }


    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod(){
        return new Object[][] {{"200"},{"301"}, {"404"}, {"500"}};

    }

    @Test(dataProvider = "data-provider", description = "")

    public void test9_12(String data){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href='/status_codes']")).click();
        driver.findElement(By.cssSelector("[href='status_codes/"+data+"']")).click();

        String message = driver.findElement(By.cssSelector("[class='example']>p")).getText();
        String actualResult = message.substring(0,message.indexOf("."));
        String expectedMessage = "This page returned a "+data+" status code";
        Assert.assertEquals(actualResult,expectedMessage);
    }
}