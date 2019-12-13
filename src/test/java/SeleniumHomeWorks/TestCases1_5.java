package SeleniumHomeWorks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class TestCases1_5 {

    /*Please create test scripts from 1 through 5 in the same class,
    with implementing @Before method for driver setup, and @After method
    for driver close. Also, do the same thing  for tests cases from 9 through 12.
     */

     private  WebDriver driver;

    @BeforeMethod
   public void setup() {
       driver = BrowserFactory.getDriver("chrome");
       driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Registration Form")).click();


    }


       @Test
      public void Test1(){
        driver.findElement(By.cssSelector("[name=\"birthday\"]")).sendKeys("wrong_dob");
        String actualResult = driver.findElement(By.cssSelector("[data-bv-result=\"INVALID\"]")).getText();
        Assert.assertEquals(actualResult,"The date of birth is not valid");
    }

    @Test
    public void Test2(){
        List<WebElement> languages = driver.findElements(By.cssSelector("[class=\"form-check-label\"]"));
        for (WebElement select:languages) {
             System.out.println("Select programming languages: "+select.getText());
        }
    }

    @Test
    public void Test3(){
        driver.findElement(By.cssSelector("[placeholder=\"first name\"]")).sendKeys("S");
        BrowserUtils.wait(2);
        String actualResult = driver.findElement(By.cssSelector("[data-bv-result=\"INVALID\"]")).getText();
        Assert.assertEquals(actualResult,"first name must be more than 2 and less than 64 characters long");
    }


    @Test
    public void Test4(){
        driver.findElement(By.cssSelector("[placeholder=\"last name\"]")).sendKeys("G");
        BrowserUtils.wait(2);
        String actualResult = driver.findElement(By.cssSelector("[data-bv-result=\"INVALID\"]")).getText();
        Assert.assertEquals(actualResult,"The last name must be more than 2 and less than 64 characters long");
    }

    @Test
    public void Test5(){
        driver.findElement(By.cssSelector("[placeholder=\"first name\"]")).sendKeys("cristioano");
        driver.findElement(By.cssSelector("[placeholder=\"last name\"]")).sendKeys("ben affleck");
        driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys("karapuzik");
        driver.findElement(By.cssSelector("[name=\"email\"]")).sendKeys("karzina@mail.ru");
        driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys("12345678");
        driver.findElement(By.cssSelector("[name=\"phone\"]")).sendKeys("123-456-7890");
        driver.findElement(By.cssSelector("[value=\"male\"]")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[placeholder=\"MM/DD/YYYY\"]")).sendKeys("12/12/2012");
        WebElement department= driver.findElement(By.cssSelector("[name=\"department\"]"));
        department.click();
        Select select = new Select(department);
        select.selectByVisibleText("Department of Engineering");
        BrowserUtils.wait(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Department of Engineering");
        WebElement Jobtitle= driver.findElement(By.cssSelector("[name=\"job_title\"]"));
        Jobtitle.click();
        Select select1= new Select(Jobtitle);
        select1.selectByVisibleText("SDET");
        BrowserUtils.wait(2);
        Assert.assertEquals(select1.getFirstSelectedOption().getText(),"SDET");
        driver.findElement(By.cssSelector("[for=\"inlineCheckbox2\"]")).click();
        driver.findElement(By.id("wooden_spoon")).click();
        String result = driver.findElement(By.xpath("//div[@class='alert alert-success']//p")).getText();
        Assert.assertEquals(result,"You've successfully completed registration!");


        }





    @AfterMethod
    public void teardown() {
      driver.quit();


    }

}
