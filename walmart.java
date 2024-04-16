package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriverService;
/*1. Go to https://www.walmart.com/ 
2. Click on menu in the left top corner 
3. Mouse over on Clothing, Shoes & Accessories under Departments 
4. Click on Shoes in Women 
5. Click Comfort Shoes and click on Sneakers 
6. Get the shoes title and price in to Map, if the brand is Skechers 
7. Get the 2nd Lowest price shoe from the map and click on it 
8. Print the Rating and number of Ratings 
9. Select the Shoe Size and print the price 
10. Select if any other options exists. 
11. Click on FeedBack icon, give rating as 5, enter a message and click Submit 
12.Click on Add To Cart and close the browser	*/
public class walmart {

	public static void main(String[] args) throws InterruptedException {
		
		 ChromeOptions options = new ChromeOptions();
	        options.addArguments("start-maximized");
	        options.addArguments("--disable-blink-features=AutomationControlled");

		WebDriver driver = new ChromeDriver(options);
		System.out.println("Hello Google...");
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("Walmart.com");
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a")).click();
		
//		driver.get("https://www.walmart.com/");
		Actions action = new Actions(driver);

//		WebElement departments = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/span/header/section[1]/div/button"));
//		departments.click();
		Thread.sleep(5000);
		WebElement roh = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/p"));
		action.clickAndHold(roh).perform();
		WebElement departments1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/span/header/section[1]/div/a"));
		departments1.click();
		WebElement csa = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/span/header/section[1]/div/div/div/div/div/ul/li[5]/button"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		action.moveToElement(csa).click().build().perform();
		
		WebElement shoeWoman = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/span/header/section[1]/div/div/div/div/section/div/ul/div[1]/li[5]/ul/li[5]/a"));
		js.executeScript("arguments[0].scrollIntoView();",shoeWoman);
		shoeWoman.click();
		
		WebElement comfort = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/main/div/div[2]/div/div/section[2]/div[1]/ul/li[7]/a"));
		comfort.click();
		
		WebElement sneakers = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/main/div/div[2]/div/div/section[2]/div[1]/ul/li[5]/a"));
		sneakers.click();
		
		Thread.sleep(4000);
		driver.quit();
		
		
		
	}
}
