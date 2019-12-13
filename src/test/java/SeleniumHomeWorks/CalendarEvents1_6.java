package SeleniumHomeWorks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarEvents1_6 {
         private WebDriver driver;
         private WebDriverWait wait;


    @BeforeMethod
    public void setup(){
      driver = BrowserFactory.getDriver("chrome");
      wait= new WebDriverWait(driver,10);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      driver.get("https://qa1.vytrack.com/user/login");
      driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123",Keys.ENTER);


        WebElement loaderMask= null;
        if(driver.findElements(By.cssSelector("div[class='loader-mask shown']")).size()>0) {
            loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        }
            WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
            wait.until(ExpectedConditions.visibilityOf(activitiesElement));
            wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
            activitiesElement.click();
            WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
            wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
            wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
            calendarEventsElement.click();
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));

    }

    @Test(description = "Verify that page subtitle Options is displayed")
    public void test1(){
        String expectedsubtitle = "Options";
        String actualsubtitle= driver.findElement(By.cssSelector("div[class=\"btn btn-link dropdown-toggle\"]")).getText();
        Assert.assertEquals(actualsubtitle, expectedsubtitle, "Subtitle is wrong!");


    }

    @Test(description = "Verify that page number is equals to \"1\" ")
    public  void test2(){
        String expectednum= "1";
        String actualnumber=driver.findElement(By.cssSelector(" [type=\"number\"]")).getAttribute("value");
        Assert.assertEquals(actualnumber,expectednum,"Wrong page number");

    }

    @Test(description = " Verify that view per page number is equals to \"25\"\n")
    public  void  test3(){
        String pagenumber = driver.findElement(By.cssSelector("[class=\"btn dropdown-toggle \"]")).getText();
        Assert.assertEquals(pagenumber,"25","Page number is wrong");
    }
    @Test(description = "  Verify that number of calendar events (rows in the table) is equals to number of records")
    public  void test4(){
        List<WebElement> row= driver.findElements(By.cssSelector("tr[class=\"grid-row row-click-action\"]"));row.size();
        int count= row.size();
        String actualnumber= driver.findElement(By.cssSelector("[class=\"dib\"]:nth-of-type(3)")).getText();
        System.out.println("Row Count: "+count);
        System.out.println("Actual number is: "+actualnumber);
        Assert.assertTrue(actualnumber.contains(count+""));

    }
    @Test(description = "Verify that all calendar events were selected")
    public  void test5(){
         int Allcheckboxes = driver.findElements(By.cssSelector("tr[class='grid-row row-click-action']")).size();
         driver.findElement(By.cssSelector("[class='btn btn-default btn-small dropdown-toggle']>input")).click();
         int  selected = driver.findElements(By.cssSelector("[class='grid-row row-click-action row-selected']")).size();
         Assert.assertEquals(selected,Allcheckboxes);
    }
    @Test(description = "Verify that following data is displayed")
    public  void test6(){
        WebElement tester = driver.findElement(By.xpath("//table//tr[14]//td[2]"));
        tester.click();

    }




    @AfterMethod
    public void teardown(){
      driver.quit();
    }

}