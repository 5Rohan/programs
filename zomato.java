package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/*1. Launch Chrome browser 
2. Go to "https://www.zomato.com/chennai" 
3. Select Velachery and Type 'A2B - Adyar Anada Bhavan' in the restaurant/cuisine textbox 
4. Choose the last listed option in auto suggested 
5. Click order online and print if the restaurant is open or closed for delivery 
6. Print the number of different items listed 
7. Print the costliest sweet in that page 
8. Click on photos and validate the number of photos listed matches the total number images displayed across the listed pages.*/
public class zomato {

	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.chromedriver().setup(); 
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.zomato.com/chennai");
		
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement location = driver.findElement(By.xpath("//img[@class='sc-yvzia9-6 hxTfPc']/following::input"));
		location.sendKeys("Velacherry");
//		driver.findElement(By.xpath("//img[@class='sc-yvzia9-6 hxTfPc']/following::input"));
		action.sendKeys(Keys.ENTER);
		
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search for restaurant, cuisine or a dish']"));
		search.click();
		search.sendKeys("A2B - Adyar Anada Bhavan");
		//driver.findElement(By.xpath("//img[@alt='Zomato']/following::input[1]")).sendKeys("Velachery");
		action.sendKeys(Keys.ENTER);
		
		
		WebElement restaurant = driver.findElement(By.xpath("//input[@class='sc-fxgLge jUPfKP']"));
		restaurant.click();
		restaurant.sendKeys("A2B-Adyar Ananda Bhavan");
 
		WebElement A2Boption = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Adyar Ananda Bhavan')]")));
		A2Boption.click();
		
		//WebElement searchResult = driver.findElement(By.xpath("//input[@class='sc-fxgLge jUPfKP']/following-sibling::div"));
//		searchResult.
		Thread.sleep(2000);
//		List<WebElement> result = driver.findElements(By.xpath("/html/body/div[1]/div/div[2]/header/nav/ul[2]/li[1]/div/div/div[3]/div[2]/div"));
//		int res = result.size();
//		System.out.println(res);
//		result.get(res-1).click();
//		
		
		WebElement orderOnline = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/article/div/section/section/div[2]/h2/a"));
		orderOnline.click();
		
		WebElement status = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/section[4]/section/section[2]/div[3]/div/div"));
		System.out.println(status.getText());
		
		WebElement leftSection = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/section[4]/section/section[1]"));
		
		
		List<WebElement> items = driver.findElements(By.xpath(" /html/body/div[1]/div/main/div/section[4]/section/section[2]/section[3]/div/div/div/div/div[2]/div/div/h4"));
		
		List<WebElement> sweet =driver.findElements(By.xpath("/html/body/div[1]/div/main/div/section[4]/section/section[2]/section[4]/div/div"));
		
		for(int i = 0; i< sweet.size(); i++) {
			System.out.println(sweet.get(i).getText());
		}
		
		Thread.sleep(10000);
		
		driver.quit();
		}
}
