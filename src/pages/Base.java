package pages;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

public WebDriver driver;
public WebDriverWait wait;


public Base(WebDriver driver){
this.driver=driver;
wait=new WebDriverWait(driver, Duration.ofSeconds(10));
}

public void waiting(By element){

wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
}

public void writeText(By element, String text){

waiting(element);
driver.findElement(element).sendKeys(text);
}  

public Boolean displayedElement(By element){

waiting(element);
boolean displayed = driver.findElement(element).isDisplayed();
return displayed;
}

public void assertBoolean(Boolean act,Boolean exp){

Assert.assertEquals(exp, act);
}



}
