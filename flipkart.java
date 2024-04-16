package practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class flipkart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.flipkart.com");
		
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement fashion = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div[1]"));
		action.moveToElement(fashion).click().build().perform();
		
		WebElement womenFootWear = driver.findElement(By.xpath("//a[@class='_1BJVlg'][4]"));
		action.moveToElement(womenFootWear).build().perform();
		
		Thread.sleep(3000);
		WebElement womenSneaker = driver.findElement(By.xpath("//a[text()='Women Sneakers']"));
		action.moveToElement(womenSneaker).click().build().perform();
		
		
		WebElement brand = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div/div/section[8]/div/div"));
		brand.click();
		
		js.executeScript("window.scrollBy(0,300)", "");
		WebElement skechers =driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div/div/section[8]/div[2]/div[1]/div[5]/div/label/div[2]"));
		skechers.click();
		
		
		Thread.sleep(3000);
		String shoeTitle = driver.findElement(By.xpath("//div[@class='_13oc-S']/div/div/div/div[2]")).getText();
		WebElement shoePrice = driver.findElement(By.xpath("//div[@class='_13oc-S']//div[@class='_2B099V']//a[@class='_3bPFwb']//div[@class='_30jeq3']"));
		
		
		List<WebElement> Title = driver.findElements(By.xpath("//div[@class='_13oc-S']/div/div/div/div[2]"));
		List<WebElement> Price = driver.findElements(By.xpath("//div[@class='_13oc-S']//div[@class='_2B099V']//a[@class='_3bPFwb']//div[@class='_30jeq3']"));
		
		
		for(WebElement T : Price)
		{
			String s = T.getText().replaceAll("[^0-9]", "");
			int a = Integer.parseInt(s);
			System.out.println(a);
		}
		
		Map<String,WebElement> maps= new HashMap<>();
		
		maps.put(shoeTitle, shoePrice);

		   for (Entry<String, WebElement> entry : maps.entrySet())  {
	            System.out.println("Key = " + entry.getKey() + 
	                             ", Value = " + entry.getValue()); 
	    } 
//		for(WebElement m : maps)
//		{
//			String s = T.getText().replaceAll("[^0-9]", "");
//			int a = Integer.parseInt(s);
//			System.out.println(a);
//		}
	
		Thread.sleep(4000);
		driver.quit();
	}

}
