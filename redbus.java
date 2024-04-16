package practice;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*1.Launch URL: https://www.redbus.in 
2. Enter 'from' place as 'Chennai(All Locations)' 
3.Enter 'to' place as 'Bangalore(All Locations)' 
4.Pick onward date as today 
5.Click on 'Search Buses' 
6.Check 'After 6 pm' under 'DEPARTURE TIME' 
7.Check 'Sleeper' under 'BUS TYPE' 
8.Click on 'Seats Available' to sort 
9.Get the number of seats available in the (extract the value alone) first result 
10.Click on 'VIEW SEATS' 
11.Take a screenshot of the Seat Map for the highest seats available bus*/
public class redbus {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		System.out.println("Hello Google...");
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in");
		
		WebElement from = driver.findElement(By.xpath("//*[@id=\"src\"]"));
		from.sendKeys("Chennai(All Locations)");
		
		WebElement to = driver.findElement(By.xpath("//*[@id=\"dest\"]"));
		to.sendKeys("Bangalore(All Locations)");
		
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		Date today = Calendar.getInstance().getTime();
//		String date = dateFormat.format(today);
//		System.out.println(date);
		Actions action = new Actions(driver);
		driver.findElement(By.id("onwardCal")).click();
		int dat = java.time.LocalDate.now().getDayOfMonth();
		System.out.println(dat);
		driver.findElement(By.xpath("//span[text()="+dat+"]")).click();
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.id("search_button"));
		action.moveToElement(search).click().build().perform();
		//searchBus.click();

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[2]/div[3]/div/div[3]/div[2]")));
		//closeBanner.click();
		Thread.sleep(2000);
		WebElement closeBanner = driver.findElement(By.xpath("/html/body/section/div[2]/div[3]/div/div[3]/div[2]"));
		action.moveToElement(closeBanner).click().perform();
		

		WebElement afterSix = driver.findElement(By.xpath("//*[@id='filter-block']/div/div[2]/ul[2]/li[4]"));
		afterSix.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)","");
		
		
		WebElement sleeper = driver.findElement(By.xpath("//*[@id=\"filter-block\"]/div/div[2]/ul[3]/li[2]/label[2]"));
		sleeper.click();
		
		WebElement seatAvaliable = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/div[7]/a"));
		seatAvaliable.click();
		
		js.executeScript("window.scrollBy(0,250)","");
		WebElement numberOfSeatAvaliable = driver.findElement(By.xpath("//div[@class='seat-left m-top-30']"));
		System.out.println(numberOfSeatAvaliable.getText());
		String s = numberOfSeatAvaliable.getText();
		int avaliable = Integer.parseInt(s.split(" ")[0]);
		System.out.println(avaliable);
		
		WebElement viewSeats = driver.findElement(By.xpath("//*[@id=\"result-section\"]/div[2]/ul/div[1]/li/div/div[2]/div[1]"));
		viewSeats.click();
		
		System.out.println("user.dir");
		takeSnapShot(driver,System.getProperty("user.dir") +"\\screenshots" + System.currentTimeMillis()+".png");
		
		
		
		
		Thread.sleep(3000);
		driver.quit();
	}
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		}

}

