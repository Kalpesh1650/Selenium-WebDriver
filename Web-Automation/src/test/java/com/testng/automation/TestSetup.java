package com.testng.automation;

//import org.junit.Test;
//import org.openqa.selenium.By;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TestSetup {
	
	private WebDriver driver;
	TestConfiguration configuration = new TestConfiguration();
	
	@BeforeTest
	public WebDriver setUp() throws Exception 
	{
		/*String IEPath = configuration.getIEDriverEXEPath();*/
		//String URL = configuration.getURL();
		//System.out.println(URL);
		System.setProperty("webdriver.chrome.driver","D:\\Languages\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.navigate().to("D:\\Languages\\EclipseLunaWorkspace\\Web-Automation\\WebTables.html");
		return driver;
	}
	@BeforeTest
	public String getTestDataSheet()
	{
		String filePath = "D:\\Languages\\EclipseLunaWorkspace\\Web-Automation\\src\\test\\resources\\EmployeeSheet.xlsx";
		return filePath;
	}
	
/*	@Test(enabled = false)
	public void findXPath()
	{
		
		
		String actual_Title  =  driver.getTitle();
		System.out.println(actual_Title);
		try{
		Assert.assertEquals(actual_Title, "Facebook - Log In or Sign Up1");
		}catch(Error err)
		{
			System.out.println("Test Failed");
			System.out.println(err.getMessage());
			//Take screenshot if test fails
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			try {
				FileUtils.copyFile(src, new File("D:\\Languages\\EclipseLunaWorkspace\\Web-Automation\\Screenshot\\FacebookScreenshot.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.close();
		
		
	}
*/	
	/*@Test
	public void museHover()
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Test Pages")));
		
		
		Actions act = new Actions(driver);
		WebElement element = driver.findElement(By.linkText("Test Pages"));
		act.moveToElement(element).build().perform();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	*/
	
	/*@Test
	public void click()
	{
		driver.findElement(By.linkText("Shop")).click();
	}*/
	
	/*@Test
	public void Login()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("My Account")).click();
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("testuser1");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
	}*/

	@Test
	
	@AfterTest
	public void tearDown()
	{
				
		try 
	    {
	        driver.close();
	        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");

	    }
	    catch (Exception anException) 
	    {
	        anException.printStackTrace();
	    }
	}

}
