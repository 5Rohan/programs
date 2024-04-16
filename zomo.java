package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
public class zomo {

	

	
	    public static void main(String[] args) {
	        // Step 1: Launch Chrome browser
	        WebDriver driver = new ChromeDriver();

	        // Step 2: Go to "https://www.zomato.com/chennai"
	        driver.get("https://www.zomato.com/chennai");

	        // Wait for the page to load
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".zc-searchGeocomplete")));

	        // Step 3: Select Velachery and Type 'A2B - Adyar Anada Bhavan' in the restaurant/cuisine textbox
	        WebElement locationInput = driver.findElement(By.cssSelector(".zc-searchGeocomplete"));
	        locationInput.sendKeys("Velachery");

	        WebElement cuisineInput = driver.findElement(By.cssSelector(".zc-searchKeyword"));
	        cuisineInput.sendKeys("A2B - Adyar Anada Bhavan");

	        // Step 4: Choose the last listed option in auto-suggested
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-autocomplete li")));
	        List<WebElement> autoSuggestions = driver.findElements(By.cssSelector(".ui-autocomplete li"));
	        WebElement lastAutoSuggestion = autoSuggestions.get(autoSuggestions.size() - 1);
	        lastAutoSuggestion.click();

	        // Wait for the page to load
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".search-result-title")));

	        // Step 5: Click order online and print if the restaurant is open or closed for delivery
	        WebElement orderOnlineButton = driver.findElement(By.cssSelector(".r2i7.s5z7"));
	        orderOnlineButton.click();

	        WebElement deliveryStatus = driver.findElement(By.cssSelector(".search-box-cuisines .delivery-status"));
	        String deliveryText = deliveryStatus.getText();
	        System.out.println("Delivery status: " + deliveryText);

	        // Step 6: Print the number of different items listed
	        List<WebElement> itemsList = driver.findElements(By.cssSelector(".result-title"));
	        System.out.println("Number of different items listed: " + itemsList.size());

	        // Step 7: Print the costliest sweet in that page
	        List<WebElement> costElements = driver.findElements(By.cssSelector(".item-cost"));
	        List<Double> costs = costElements.stream()
	                .map(cost -> Double.parseDouble(cost.getText().replace("₹", "").trim()))
	                .collect(Collectors.toList());
	        double maxCost = costs.stream().mapToDouble(Double::doubleValue).max().orElse(0);
	        WebElement costliestItem = costElements.stream()
	                .filter(e -> Double.parseDouble(e.getText().replace("₹", "").trim()) == maxCost)
	                .findFirst()
	                .orElse(null);
	        System.out.println("Costliest sweet: " + costliestItem.getText());

	        // Step 8: Click on photos and validate the number of photos listed matches the total number of images displayed across the listed pages.
	        WebElement photosLink = driver.findElement(By.cssSelector("a[data-result-type='ResPhoto']"));
	        photosLink.click();

	        // Wait for the photos page to load
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".photo-list-container")));

	        // Count the number of photos in the current page
	        List<WebElement> photos = driver.findElements(By.cssSelector(".photo-container"));
	        int totalPhotosCount = photos.size();

	        // Iterate through the pagination and count photos in each page
	        List<WebElement> paginationLinks = driver.findElements(By.cssSelector(".photo-pagination a"));
	        for (WebElement paginationLink : paginationLinks) {
	            paginationLink.click();
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".photo-list-container")));
	            photos = driver.findElements(By.cssSelector(".photo-container"));
	            totalPhotosCount += photos.size();
	        }

	        System.out.println("Total number of photos listed: " + totalPhotosCount);

	        // Close the browser
	        driver.quit();
	    }
	}

