package SeleniumHomeWorks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class testcase_1 {
    /*
    Step 1. Go to https://practicecybertekschool.herokuapp.com/
Step 2. Click on “Sign Up For Mailing List”
Step 3. Enter any valid name
Step 4. Enter any valid email
Step 5. Click on “Sign Up” button
           Expected result: Following message should be displayed: “Thank you for signing up.
           Click the button below to return to the home page.” Home button should be displayed.
     */
    public static void main(String[] args) {



        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.cssSelector("[name=\"full_name\"]")).sendKeys("Cybertek Batch12");
       driver.findElement(By.cssSelector("[name=\"email\"]")).sendKeys("Cybertekbatch@gmail.com");
       driver.findElement(By.cssSelector("[name=\"wooden_spoon\"]")).click();
        BrowserUtils.wait(3);
        String expectedResult= "Thank you for signing up. Click the button below to return to the home page.";
         if (driver.findElement(By.cssSelector("[name=\"signup_message\"]")).getText().equals(expectedResult) ) {
             System.out.println("Test Passed");
         }else {
             System.out.println("test failed");
         }




        driver.quit();


    }

}
