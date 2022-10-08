package Synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.get("https://demo.actitime.com/login.do");
		
		driver.findElement(By.id("username")).sendKeys("admin");
		
		driver.findElement(By.name("pwd")).sendKeys("manager");
		
		driver.findElement(By.id("loginButton")).click();
		
		String expectedtitle = "actiTIME - Enter Time-Track";               
		
		wait.until(ExpectedConditions.titleIs(expectedtitle));               //until - non-static method
		
		String actualtitle = driver.getTitle();
		
		System.out.println(actualtitle);
		
		if(actualtitle.contains(expectedtitle))
		{
			System.out.println("PASS: Title is same");
		}
		else
		{
			System.out.println("FAIL: Title is different");
		}	
	}
}
