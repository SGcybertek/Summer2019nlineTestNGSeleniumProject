package Practice;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class PracticeBitrixTestNG {
    @Test
    public void Practice() {

        WebDriver driver= BrowserFactory.getDriver("FireFox");
        driver.get("https://www.brown.edu/");
        String expected = "Brown UniversityJ";
        String actual= driver.getTitle();
        Assert.assertEquals(actual,expected);
        BrowserUtils.wait(2);
        driver.close();
    }

}
