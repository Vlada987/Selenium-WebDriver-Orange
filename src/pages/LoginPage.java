package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base {

public LoginPage(WebDriver driver) {
super(driver);
}

String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
By loginPageLogo=By.xpath("//div[@class='orangehrm-login-branding']");
By userName=By.xpath("//input[@name='username']");
By password=By.xpath("//input[@name='password']");
By loginButton=By.xpath("//button[@type='submit']");
By leftButton=By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/div/div/button");

public LoginPage openUrl() {

driver.get(url);
return this;
}

public LoginPage PageVerification(Boolean logoPresenceExp){

Boolean logoPresenceAct = displayedElement(loginPageLogo);
assertBoolean(logoPresenceAct, logoPresenceExp);
return this;
}

public LoginPage login(String uname,String pwd){

writeText(userName, uname);
writeText(password, pwd);
driver.findElement(loginButton).click();
return this;
} 

public LoginPage loginVerification(Boolean leftButtonPresenceExp){

Boolean leftButtonPresenceAct = displayedElement(leftButton);
assertBoolean(leftButtonPresenceAct, leftButtonPresenceExp);
return this;
}
    
}
