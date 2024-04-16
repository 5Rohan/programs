package practice;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*1. Access Myntra.com
2. Mouse hover Beauty
3. Select Perfume under Fragrances
4. Select Men option from filter radio buttons present right side.
5. Verify none of the check boxes options under BRAND filter section has number of products below 50.*/
public class myntra {

	final static String url = "https://www.myntra.com/";

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.navigate().to(url);

		WebElement beauty = driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/nav/div/div[5]/div/a"));
		WebElement perfume = driver.findElement(
				By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/nav/div/div[5]/div/div/div/div/li[3]/ul/li[11]/a"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Actions action = new Actions(driver);

		action.moveToElement(beauty).moveToElement(perfume).click().build().perform();
		WebElement men = driver.findElement(
				By.xpath("//*[@id=\"mountRoot\"]/div/main/div[3]/div[1]/section/div/div[2]/ul/li[1]/label"));
		System.out.println(men.getText());
		wait.until(ExpectedConditions.elementToBeClickable(men)).click();

		Thread.sleep(3000);
		List<WebElement> brandFilter = driver
				.findElements(By.xpath("//*[@id=\"mountRoot\"]/div/main/div[3]/div[1]/section/div/div[4]/ul"));
		for (int i = 0; i < brandFilter.size(); i++) {
			System.out.println(brandFilter.get(i).getText());
		}
		
		
		
//        boolean allBrandsHaveMoreThan50Products = true;
//
//		 for (WebElement brandCheckBox : brandFilter) {
//	            String brandName = brandCheckBox.getAttribute("value");
//	            String productCountText =  driver.findElement(By.xpath("//label[@for='" + brandName + "']/span"))
//                        .getText();
//	            int productCount = Integer.parseInt(productCountText);
//	            if (productCount < 50) {
//	                allBrandsHaveMoreThan50Products = false;
//	                System.out.println("Brand '" + brandName + "' has less than 50 products.");
//	            }
//	        }
//
//	        if (allBrandsHaveMoreThan50Products) {
//	            System.out.println("All brands have 50 or more products.");
//	        } else {
//	            System.out.println("Some brands have less than 50 products.");
//	        }
		
		Thread.sleep(4000);
		driver.quit();
	}
}
