package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContactWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//Call the WDM for the browser driver
WebDriverManager.chromedriver().setup();
//Launch the browser
ChromeDriver driver = new ChromeDriver();
//Load URL
driver.get("http://leaftaps.com/opentaps/control/login");
//Maximize the browser
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//Enter username and password using id locator
driver.findElement(By.id("username")).sendKeys("demosalesmanager");
driver.findElement(By.id("password")).sendKeys("crmsfa");
//Click on Login Button using Class Locator
driver.findElement(By.className("decorativeSubmit")).click();
//Click on CRM/SFA Link
driver.findElement(By.linkText("CRM/SFA")).click();
//Click on contacts Button
driver.findElement(By.linkText("Contacts")).click();
//Click on Merge Contacts using Xpath Locator
driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
//Click on Widget of From Contact
driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
//Window Handles
Set<String> windowHandles = driver.getWindowHandles();
List<String> lstWindowHandles = new ArrayList<String>(windowHandles);
String secondWindowHandle = lstWindowHandles.get(1);
//Switch to second window
driver.switchTo().window(secondWindowHandle);
//Click on First Resulting Contact
driver.findElement(By.xpath("(//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first')]/div/a)[1]")).click();
//Switch to first window
driver.switchTo().window(lstWindowHandles.get(0));
//Click on Widget of To Contact
driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
//Window Handles
Set<String> windowHandles2 = driver.getWindowHandles();
List<String> lstWindowHandles2 = new ArrayList<String>(windowHandles2);
String secondWindowHandle2 = lstWindowHandles2.get(1);
//Switch to second window
driver.switchTo().window(secondWindowHandle2);
//Click on Second Resulting Contact
driver.findElement(By.xpath("(//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first')]/div/a)[2]")).click();
//Switch to first window
driver.switchTo().window(lstWindowHandles2.get(0));
//Click on Merge button using Xpath Locator
driver.findElement(By.xpath("//a[text()='Merge']")).click();
//Handle the alert
Alert alert = driver.switchTo().alert();
String text = alert.getText();
//Accept the alert
alert.accept();
//Verify the title of the page
String title = driver.getTitle();
System.out.println(title);

	}

}
