package com.Mani_Maven_Project.Amazon;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	public static void main(String[] args) {
		ChromeOptions opt=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String expected="music";
		WebElement searchDropdownBox = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		searchDropdownBox.click();
		Select s=new Select(searchDropdownBox);
		List<WebElement> options = s.getOptions();
		ListIterator<WebElement> listIterator = options.listIterator();
		
		while(listIterator.hasNext()) {
			WebElement next = listIterator.next();
			if(expected.equalsIgnoreCase(next.getText())) {
				s.selectByVisibleText("Music");
				break;
			}
			String searchvalue="cd";
			
			
			
				
			}
		
		
		
		
		
		
		
		
	
	
	
	}

}
