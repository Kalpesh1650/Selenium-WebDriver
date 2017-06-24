package RoughWork;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium_Grid {

public static WebDriver grid_Driver = null;	
	
	
@Test
public void configure(){
	
	
	DesiredCapabilities dc = DesiredCapabilities.chrome();
	try {
		URL node_url = new URL("http://192.168.43.99:5555/wd/hub");
	
		
		grid_Driver = new RemoteWebDriver(node_url, dc);
		
		grid_Driver.navigate().to("https://www.google.com");
		
		Thread.sleep(5000);
		if(grid_Driver!=null)
			grid_Driver.quit();
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		
	}
	
}
	
	
	
}
