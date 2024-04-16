package practice;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*1. Launch Chrome browser
1. Go to https://www.ajio.com/ 
3. Mouse over on "Women" and mouse over on "Brands" 
4. Click the link that has most number of lower case characters 
5. Print and store number of items 
6. Expand Size and Fit and choose 'S' 
7. Confirm the number of items have reduced the previous results 
8. Sort by Discount and confirm results are sorted by higher discounts first*/
public class ajio {

	public static void main(String[] args) throws InterruptedException {
		// System.out.println("Start Execution");

		int max = 0, countPerWord = 0, count = 0;
		WebDriver driver = new ChromeDriver();
		// System.out.println("Hello Google...");
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com/ ");

		WebElement close = driver.findElement(By.xpath("//*[@id=\"closeBtn\"]"));
		close.click();
		Actions action = new Actions(driver);
		WebElement women = driver
				.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[1]/ul/li[2]/a"));

		WebElement brands = driver.findElement(
				By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[1]/ul/li[2]/div[1]/ul/li[2]/a"));
		action.moveToElement(women).moveToElement(brands).build().perform();
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		List<WebElement> brandsList = driver.findElements(By
				.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[1]/ul/li[2]/div[1]/ul/li[2]/div/div/div/div/div[2]/span/a"));


		String linkWithMostLowercaseCharacters = "";
		int maxLowercaseCount = 0;

    for (WebElement link : brandsList) {
        String text = link.getAttribute("innerText");
        int lowercaseCount = text.length() - text.replaceAll("[a-z]", "").length();
        if (lowercaseCount > maxLowercaseCount) {
            maxLowercaseCount = lowercaseCount;
            linkWithMostLowercaseCharacters = link.getAttribute("href");
        }
    }
    System.out.println(linkWithMostLowercaseCharacters);
		 driver.get(linkWithMostLowercaseCharacters);
    Thread.sleep(2000);
		 // driver.findElement(By.xpath("//*[@id='appContainer']/div[1]/div/header/div[3]/div[1]/ul/li[2]/div[1]/ul/li[2]/div/div/div/div/div[2]/span/a[text()="+linkWithMostLowercaseCharacters+"]")).click();

		 
		 WebElement products = driver.findElement(By.xpath("//*[@id=\"products\"]/div[2]/div/div[1]/strong"));
			 String p = products.getText();
			 int totalProducts = Integer.parseInt(p.split(" ")[0]);
			 System.out.println(totalProducts);
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,250)","");
		 WebElement sizeaAndFit = driver.findElement(By.xpath("//*[@id=\"facets\"]/div[2]/ul/li[8]/div/div/div/span[2]"));
		 
		 sizeaAndFit.click();
		 
		 WebElement smallSize = driver.findElement(By.xpath("//*[@id=\"facets\"]/div[2]/ul/li[8]/div/div/div[2]/ul/li[2]/div/div/label"));
		 smallSize.click();
		 
		 WebElement smallSizeProducts =driver.findElement(By.xpath("//*[@id=\"products\"]/div[3]/div/div[1]"));
		 System.out.println(smallSizeProducts.getAttribute("innerText"));
		 String s = smallSizeProducts.getText();
		 int smallProducts = Integer.parseInt(s.split(" ")[0]);
		 System.out.println(smallProducts);
		 if(smallProducts < totalProducts) {
			 System.out.println("the number of items have reduced the previous results ");
		 }
		 else
		 {
			 System.out.println("The number of Item have not changed");
		 }
		 
//		 WebElement discount = driver.findElement(By.xpath("//*[@id=\"facets\"]/div[2]/ul/li[6]/div"));
//		 discount.click();
		 
		 Select sortBy = new Select(driver.findElement(By.xpath("//*[@id=\"sortBy\"]")));
		 sortBy.selectByValue("discount-desc");
		// driver.findElement(By.xpath("//li[@data-test='li-WOMEN']//li[@class='catg
		// inactive-text'][2]//div[@class='items']/span/a[text()='Superdry']")).click();

		Thread.sleep(4000);
		driver.quit();
	}
}