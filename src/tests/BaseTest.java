package tests;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

public WebDriver driver;

@Before
public void open(){

System.setProperty("webdriver.gecko.driver","C:\\Users\\zikaz\\OneDrive\\Desktop\\projects\\Orange\\Orange\\lib\\geckodriver.exe");
driver=new FirefoxDriver();
driver.manage().window().maximize();
}

@After
public void close(){

driver.quit();
}


    
}
