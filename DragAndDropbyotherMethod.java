// 06/08/22

package ActionsClass;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropbyotherMethod {
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.get("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/index.html");
		
		WebElement source= driver.findElement(By.xpath("//h1[text()='Block 1']"));
		WebElement destination = driver.findElement(By.xpath("//div[@class='column blocks']"));
		
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.clickAndHold(source).moveToElement(destination).release().perform();
	}
}
