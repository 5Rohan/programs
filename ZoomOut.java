package practice;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ZoomOut {



	    public static void main(String[] args) throws InterruptedException {
	       // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

	        ChromeOptions options = new ChromeOptions();

	        WebDriver driver = new ChromeDriver(options);

	        // Open a webpage
	        driver.get("https://www.google.com");

	        // Zoom in (e.g., 1.5x)
	        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '0.7'");

	        // Continue with your interactions or testing
Thread.sleep(5000);
	        // Close the browser
	        driver.quit();
	    }
	}

