package TESTCASES;

import com.qa.crm.base.Baseclass;
import com.qa.crm.pages.Homepage;
import com.qa.crm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Loginpagetest extends Baseclass {
    LoginPage loginPage;
    Homepage homePage;
 public Loginpagetest(){
     super();
 }
    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new LoginPage();
    }


    @Test(priority=1)
    public void loginPageTitleTest(){
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
    }

    @Test(priority=2)
    public void crmLogoImageTest(){
        boolean flag = loginPage.validateCRMImage();
        Assert.assertTrue(flag);
    }

    @Test(priority=3)
    public void loginTest(){
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }
}
