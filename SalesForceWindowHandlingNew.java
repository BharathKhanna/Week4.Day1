package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceWindowHandlingNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Call the WDM for browser driver
		WebDriverManager.chromedriver().setup();
		//Launch the browser
		ChromeDriver driver = new ChromeDriver();
		//Load URL
		driver.get("https://login.salesforce.com/");
		//Maximize the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("(//span[@dir='ltr'])[2]")).click();
		//WindowHandles
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstWindowHandles = new ArrayList<String>(windowHandles);
		String secondWindowHandle = lstWindowHandles.get(1);
		//Switch to second window
		driver.switchTo().window(secondWindowHandle);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
        String title = driver.getTitle();
        System.out.println(title);
        driver.switchTo().window(lstWindowHandles.get(0));
        driver.close();
	}

}
