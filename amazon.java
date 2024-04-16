package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class amazon {
/*"1. Access Amazon.com
2. Select Mobiles option in main menu
3. MouseHover over Laptops and Accessories
4. Click on Samsung under Shop By brand option
5. Check Results are loaded
6. Verify Samsung option is selected under left side Brands section
7. Verify all the results of page 1 is of Samsung products only and not from other brands"*/
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String url = "https:www.amazon.in";
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.navigate().to(url);
		Actions action = new Actions(driver);
		WebElement all = driver.findElement(By.xpath("//a/span[text()='All']"));
		action.moveToElement(all).click().build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)","");
		//WebElement hideMenu = driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]"));
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//*[text()='Shop by Category']")));
		
	
		
		WebElement mobiles = driver.findElement(By.xpath("//div[@id='hmenu-content']/ul[1]/li[15]/a"));
		action.moveToElement(mobiles).click().build().perform();
		
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//*[text()='Computers & Accessories']")));
		
		WebElement laptop = driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[8]/li[17]"));
		action.moveToElement(laptop).click().build().perform();
		
		WebElement laa = driver.findElement(By.xpath("//span[text()[normalize-space()='Laptops & Accessories']]"));
		action.moveToElement(laa);
		
		
		Thread.sleep(10000);
		driver.quit();
	}

}
