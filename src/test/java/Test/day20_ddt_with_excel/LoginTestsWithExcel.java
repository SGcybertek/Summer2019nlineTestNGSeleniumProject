package Test.day20_ddt_with_excel;


import Test.TestBase;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Driver;
import utils.ExcelUtil;

public class LoginTestsWithExcel extends TestBase {

    //username	password	firstname	lastname	result
    @Test(dataProvider = "credentials", description = "Login with different credentials")
    public void loginTest(String username, String password, String firstName, String lastName, String result) {
        //is must because we will ge null pointer exception
        extentTest = extentReports.createTest("Login as "+username);
        if(username.equals("username")){
            //will make test skipped
            //it will not fail
            //because first row is dedicated to column names
            throw new SkipException("Test was skipped because it's first row!");
        }else{
            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password);
            //put here wait for title to be "Dashboard"
            Assert.assertEquals(Driver.get().getTitle(), "Dashboard");
            extentTest.pass("Login test passed for user "+username);
        }
    }

    //is a test data supplier
    //as many sets of data it returns
    //as many times exactly same test will run
    @DataProvider(name = "credentials")
    public static Object[][] credentials() {
        ExcelUtil qa2 = new ExcelUtil("vytrack_testusers.xlsx", "QA2-short");
        return qa2.getDataArray();
    }


//    public static void main(String[] args) {
//        ExcelUtil qa2 = new ExcelUtil("vytrack_testusers.xlsx", "QA2-short");
//        System.out.println("Row count: " + qa2.rowCount());
//        System.out.println(qa2.getColumnsNames());
//        //map is a data structure
//        //in map, every value is referenced by key
//        //when we retrieve data from map, we don't specify index, we specify key name
//        //keys must be unique
//        //keys are represented by column names
//        //like in properties file key=value
//        for (Map<String, String> map : qa2.getDataList()) {
//            System.out.println(map.get("username"));
//        }
//    }


}