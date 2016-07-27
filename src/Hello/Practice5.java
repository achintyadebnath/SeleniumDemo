package Hello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Practice5 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.online.citibank.co.in/");
		
		driver.findElement(By.xpath(".//*[@id='container']/div[2]/div[2]/div/div[1]/div[1]/p[2]/a[1]/img")).click();
		
		for(String child_window : driver.getWindowHandles())
		{
			driver.switchTo().window(child_window);
			driver.findElement(By.xpath(".//*[@id='User_Id']")).sendKeys("abcd");
		}
		
	}
}