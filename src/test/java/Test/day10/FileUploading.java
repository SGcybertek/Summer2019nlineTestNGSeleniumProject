package Test.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FileUploading {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @Test(description = "Verify that file was uploaded")
    public void test1(){
        driver.findElement(By.linkText("File Upload")).click();
        //provide path to the file
        //insert your path to the file into sendKeys() method
        driver.findElement(By.id("file-upload")).sendKeys("C:/Users/Sanjar1987/OneDrive/Desktop/day 48 Abstraction");
        //click submit
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(4);
        String expectedFileName = "day 48 Abstraction";
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName, expectedFileName);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}