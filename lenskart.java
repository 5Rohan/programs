package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class lenskart {

	public static void main(String args[]) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		System.out.println("Hello Google...");
		driver.manage().window().maximize();
		driver.get("https://www.lenskart.com/");
		
		WebElement cglass = driver.findElement(By.xpath("//a[contains(text(),'Computer Glasses')]"));
		
		//System.out.println(str);
		//WebElement menSubMenu = driver.findElement(By.xpath("//span[text()='Men']"));
		WebElement menSubMenu = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div[1]/div[2]/div/div/div[3]/div[1]/span"));
		
		WebElement bluCompglass = driver.findElement(By.xpath("//span[text()='Blu 0 Computer Glasses']")); 
		Actions action = new Actions(driver);
		action.moveToElement(cglass).moveToElement(menSubMenu).moveToElement(bluCompglass).click().build().perform();
		
		WebElement round = driver.findElement(By.xpath("//span[text()='Round']"));
		round.click();
		
		WebElement frameColor = driver.findElement(By.xpath("//span[text()='FRAME COLOR']"));
		
		action.moveToElement(frameColor).click().build().perform();
		//driver.findElement(By.xpath("//span[text()='']"))
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//span[text()='FRAME COLOR']")));
 
		

		WebElement highestCountColor = driver.findElement(By.xpath("//*[@id=\"frame_color_id\"]/div[2]/div/div[1]"));
		String colorhighest = highestCountColor.getText();
		System.out.println(colorhighest);
		//*[@id="frame_color_id"]/div[2]/div/div[1]/label/span
		highestCountColor.click();
 
		
		 //js.executeScript("window.scrollBy(0,750)", "");
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//span[text()='FRAME COLOR']")));
		WebElement result = driver.findElement(By.xpath("//*[@id=\"next\"]/div[2]/div/div/div[2]/div/div[1]/div/div[2]/span[4]"));
		//System.out.println(result.getAttribute("innerText"));
		List<WebElement> frameSize = driver.findElements(By.xpath("//*[@id=\"frame_size_id\"]/div[2]/div/div"));
		System.out.println("Number of different of framesize count "+frameSize.size());
//		for(int i =0; i < frameSize.size(); i++) {
//			System.out.println(frameSize.get(i).getAttribute("innerText"));
//		}
		
		Thread.sleep(5000);
		driver.quit();
	}
}
