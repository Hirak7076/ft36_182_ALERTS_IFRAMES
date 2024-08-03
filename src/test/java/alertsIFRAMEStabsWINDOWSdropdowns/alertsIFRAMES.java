package alertsIFRAMEStabsWINDOWSdropdowns;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class alertsIFRAMES {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html#google_vignette");
		
		driver.findElement(By.cssSelector("[id='alertBox']")).click();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("confirmBox")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.findElement(By.id("confirmBox")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.id("promptBox")).click();
		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys("Hirak");
		Thread.sleep(2000);
		prompt.accept();
		
		String outputTEXT = driver.findElement(By.id("output")).getText();
		if (outputTEXT.contains("Hirak")) {
			System.out.println("Test Passed");
		}
		Thread.sleep(2000);
		driver.close();
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html#google_vignette");
		
		Actions actions = new Actions(driver);
		
		WebElement drop = driver.findElement(By.xpath("//a[@href='#' and text()='Selenium Practice']"));
		actions.moveToElement(drop).build().perform();
		
		WebElement option = driver.findElement(By.xpath("//a[text()='Frames Practice']"));
		option.click();
		
		WebElement frame1 = driver.findElement(By.id("frm1"));
		driver.switchTo().frame(frame1).findElement(By.xpath("//a[@href='https://www.hyrtutorials.com/']")).click();
		driver.switchTo().defaultContent();
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,1000)");
		
		WebElement frame2 = driver.findElement(By.id("frm2"));
		driver.switchTo().frame(frame2).findElement(By.xpath("//a[@href='https://www.hyrtutorials.com/']")).click();
		driver.switchTo().defaultContent();
		
		driver.navigate().back();
		driver.close();
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
}
