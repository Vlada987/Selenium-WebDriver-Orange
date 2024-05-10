package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
import java.awt.event.KeyEvent;

public class HomePage extends Base {

String leaveButtonXP="/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a/span";
String applyButtonXP="/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[1]/a";
String calendarXp="/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div/input";
String calendar2Xp="/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div/input";
String dropDownXp="/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i";
String commentXp="/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div/div/div[2]/textarea";
String applyButton2Xp="/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[5]/button";
String nameXp="//p[@class='oxd-userdropdown-name']";
String myLeaveButtonXp="/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a";
String name="";
String startDate="2024-24-12";
String endDate="2024-26-12";
String comment0="My leave test";
String dateVerXp="/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[1]/div/div[2]";
String commentVerXp="/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div[7]/div/div[2]";


public HomePage(WebDriver driver) {
super(driver);
}

public String getTheName(){

name=driver.findElement(By.xpath(nameXp)).getText();
return name;
}


//Testing the leave section by taking the leave and testing
//values in My leave section

public HomePage applyForLeave() throws InterruptedException, AWTException{

waiting(By.xpath(leaveButtonXP));
driver.findElement(By.xpath(leaveButtonXP)).click();
waiting(By.xpath(applyButtonXP));
driver.findElement(By.xpath(applyButtonXP)).click();
Thread.sleep(100);
waiting(By.xpath(dropDownXp));
driver.findElement(By.xpath(dropDownXp)).click();
Robot robot=new Robot();
robot.keyPress(KeyEvent.VK_DOWN);
robot.keyRelease(KeyEvent.VK_DOWN);
robot.keyPress(KeyEvent.VK_ENTER);
robot.keyRelease(KeyEvent.VK_ENTER);
Thread.sleep(3000);
waiting(By.xpath(calendarXp));
driver.findElement(By.xpath(calendarXp)).sendKeys(startDate);
driver.findElement(By.xpath(calendar2Xp)).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
driver.findElement(By.xpath(calendar2Xp)).sendKeys(endDate);
driver.findElement(By.xpath(commentXp)).sendKeys(comment0);
driver.findElement(By.xpath(applyButton2Xp)).click();
Thread.sleep(8000);
System.out.println(getTheName());
return this;
}


public HomePage verifyLeaveRequest(Boolean dateAndcommentVerExp ){

Boolean dateAndcommentVer=false;
driver.findElement(By.xpath(myLeaveButtonXp)).click();
waiting(By.xpath(dateVerXp));
String date= driver.findElement(By.xpath(dateVerXp)).getText();
String comment=driver.findElement(By.xpath(commentVerXp)).getText();
System.out.println(date+" "+comment);
if(date.contains(startDate)&&comment0.equals(comment)){
dateAndcommentVer=true; 
}
else{
dateAndcommentVer=false;
}
assertBoolean(dateAndcommentVer, dateAndcommentVerExp);
System.out.println("Boolean Value is "+dateAndcommentVer); 
return this;
}






    
}
