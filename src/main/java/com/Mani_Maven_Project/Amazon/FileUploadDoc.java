package com.Mani_Maven_Project.Amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadDoc {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("https://the-internet.herokuapp.com/upload");
	//we want to import selenium-snapshotfile.
	driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Manikandan P\\eclipse-workspace\\Selenium_project\\screenshots\\Adactin.png");
	driver.findElement(By.id("file-submit")).submit();
	if(driver.getPageSource().contains("File Uploaded!")) {
		System.out.println("File uploaded");
		
	}else {
		System.out.println("file not uploaded");
	}
	
	
	
}
}
