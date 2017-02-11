package com.testng.automation;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/*import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions*/
import org.testng.annotations.Test;

public class WebTablesDemo {

	WebDriver driver;
	TestSetup mainClass = new TestSetup();
	int row,column;
	WebElement element;

	int Found=0;
	
	/*@Test
	public void HTMLTables() throws Exception 
	{
		driver = mainClass.setUp();
		
		
		element = driver.findElement(By.xpath("///tbody/tr[2]/td[1]"));
		System.out.println(element.getText() + " ");
		
				
		Thread.sleep(5000);
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		mainClass.tearDown();
	}
	*/
	@Test
	public void DynamicWebTables() throws Exception
	{
		driver = mainClass.setUp();
		List<WebElement> row_count = driver.findElements(By.tagName("tr"));
		//List<WebElement> column_count = driver.findElements(By.tagName("td"));
		//System.out.println(row_count.size());
		
		for(WebElement row : row_count)
		{
			
			List<WebElement> cells = row.findElements(By.tagName("td"));
			
			for(WebElement cell :cells)
			{
				//System.out.println(cell.getText());
				if("Eve2".equalsIgnoreCase(cell.getText()))
				{
					System.out.println("Eve2 found in web table");
					Found = 1;
					break;
					
				}
//				if(Found == 1)
					break;
				
				
			}
			
			
			
		}
		
		mainClass.tearDown();
		
	}
	
}
