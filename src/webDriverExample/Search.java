package webDriverExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Search {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  public static void main(String[] args) throws InterruptedException {
		  	System.setProperty("webdriver.gecko.driver", "/Users/tween5/Documents/workspace/geckodriver");
			WebDriver driver = new FirefoxDriver();
			driver.get("http://www.mercadolibre.com.ar/");
			Thread.sleep(15);
			driver.findElement(By.name("as_word")).clear();
			driver.findElement(By.name("as_word")).sendKeys("iphone");
			driver.findElement(By.cssSelector("button.nav-search-btn")).click();
			driver.findElement(By.xpath("//h2/a")).click();
	  }
}