package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirstTestCase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*System.setProperty("webdriver.gecko.driver", "/Users/tween5/Documents/workspace/geckodriver");
		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.store.demoqa.com");

        System.out.println("Successfully opened the website www.Store.Demoqa.com");

		Thread.sleep(15);

        driver.quit();*/
		int n = 6;
		String out = "#";
		for(int i=1 ; i<n ; i++ ){
			out = " "+ out;
		}
		for(int i=1 ; i<=n ; i++ ){
			System.out.println(out);
			out=out.substring(1);
			out = out+"#";
		}
	}
}
