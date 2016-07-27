package Hello;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewTest1 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.get(NewTest2.baseURL);
		try {
			WebElement Uelement = driver.findElement(By.name("uid"));
			WebElement Pelement = driver.findElement(By.name("password"));
			
			Uelement.clear();
			Pelement.clear();
			
			XSSFWorkbook workbook = new XSSFWorkbook("C:/Selenium/AMercury.xlsx");
			XSSFSheet s1 = workbook.getSheet("Input");
			
			Uelement.sendKeys(s1.getRow(4).getCell(0).getStringCellValue());
			Pelement.sendKeys(s1.getRow(4).getCell(1).getStringCellValue());
			
			workbook.close();
			
			driver.findElement(By.name("btnLogin")).click();
			
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(NewTest2.opFile));
			
			driver.findElement(By.linkText("Log out")).click();
			
			Alert alert = driver.switchTo().alert();
			alert.accept();
			
			String currentURL = driver.getCurrentUrl();
			if(NewTest2.baseURL.equals(currentURL)) {
				System.out.println("Test Case Passed");
			}
			else {
				System.out.println("Test Case Failed");
			}
		}catch(Exception e)	{
			e.getMessage();
		}
		driver.close();
	}
}