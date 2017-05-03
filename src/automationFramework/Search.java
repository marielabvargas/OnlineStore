package automationFramework;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Search {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tween5/Documents/workspace/geckodriver");
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.mercadolibre.com.ar/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testSearch() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.className("nav-search-input")).click();
	    //driver.findElement(By.cssSelector("li.chs-autocomplete-item.chs-autocomplete-highlighted")).click();
	    driver.findElement(By.linkText("Iphone 5s 16gb Retina 4g 8mp Touch Id Sellado Libre Garantía")).click();
	    try {
	      assertEquals("(1) Iphone 5s 16gb Retina 4g 8mp Touch Id Sellado Libre Garantía - $ 7.499,00 en Mercado Libre", driver.getTitle());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    try {
	      assertTrue(isElementPresent(By.id("BidButtonTop")));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("$ 7.49900".equals(driver.findElement(By.cssSelector("strong")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Reputación como vendedor".equals(driver.findElement(By.cssSelector("p.card-subtitle.section-subtitle")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}