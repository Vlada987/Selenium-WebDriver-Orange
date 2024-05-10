package tests;
import java.awt.AWTException;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class Test_class extends BaseTest{

LoginPage loginPage;
HomePage homePage;


//@Test
public void test_01_open_LoginPage(){

loginPage=new LoginPage(driver);
loginPage.openUrl();
loginPage.PageVerification(true);
}

//@Test
public void test_02_login(){

loginPage=new LoginPage(driver);
loginPage.openUrl();
loginPage.login("Admin", "admin123");
loginPage.loginVerification(true);
}

//@Test
public void test_03_applyLeave() throws InterruptedException, AWTException{

loginPage=new LoginPage(driver);
homePage=new HomePage(driver);
loginPage.openUrl();
loginPage.login("Admin", "admin123");
homePage.applyForLeave();
homePage.verifyLeaveRequest(true);
}  
}
