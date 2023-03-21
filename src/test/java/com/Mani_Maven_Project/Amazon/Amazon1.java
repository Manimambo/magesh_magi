package com.Mani_Maven_Project.Amazon;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazon1 extends BaseClass {

			public static String GetT1 = null;

			@BeforeClass
			public static void browserLaunch() throws Exception {
				browser_Launch("chrome");
				url_Launch("https://www.amazon.in/");
				
			}
			
			@Test(priority = 1)
			public  void subMenu() {
				
				
				WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
				Select DropdownList = new Select(dropdown);
			
				
				
				
				List<WebElement> allSelectedOptions = DropdownList.getOptions();
				
			
				
				ListIterator<WebElement> listIterator1 = allSelectedOptions.listIterator();
				
				String Expected = "Music";
				
				
				while (listIterator1.hasNext()) {
					WebElement next = listIterator1.next();
					
					
					if (Expected.equalsIgnoreCase(next.getText())) {
						DropdownList.selectByVisibleText(Expected);
						System.out.println("Expected Text in Submenu Bar:" + Expected);
						System.out.println("Actual Text in Submenu Bar:" + next.getText());
						break;
					}
				}

			}

			@Test(priority = 2)
			public static void SearchKeywords() throws InterruptedException {
				String SearchKeyword = "cd";
				driver.findElement(By.id("twotabsearchtextbox")).sendKeys(SearchKeyword);
				Thread.sleep(3000);

				List<WebElement> Searchsuggestions = driver.findElements(By.xpath("//div[@class='s-suggestion-container']"));
				for (int i = 1; i <= Searchsuggestions.size(); i++) {
					WebElement EachSearchsuggestions = driver
							.findElement(By.xpath("//div[@class='autocomplete-results-container']//child::div[" + i + "]"));
					if (SearchKeyword.equalsIgnoreCase(EachSearchsuggestions.getText())) {
						System.out.println("Expected Text in Search Bar: " + EachSearchsuggestions.getText());
						System.out.println("Actual Text in Search Bar: " + SearchKeyword);
						driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
						break;
					}

				}

				WebElement GetTitle1 = driver.findElement(
				By.xpath("//span[(text()='RESULTS')]//ancestor::div[4]//following-sibling::div[1]//child::h2"));
				GetT1 = GetTitle1.getText();
				System.out.println("Produc Name in Product List: " + GetT1);
//				driver.findElement(
//						By.xpath("//span[(text()='RESULTS')]//ancestor::div[4]//following-sibling::div[1]//child::h2/a"))
//						.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    WebElement row1 = driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base a-text-normal']//following::span[@class='a-size-medium a-color-base a-text-normal']"));
			    Thread.sleep(2000);
			    row1.click();
			
			
			}

			@Test(priority = 3)
			public static void windowHandles()  {
				System.out.println(GetT1);
				String AmazonwindowHandle = driver.getWindowHandle();
				Set<String> handle = driver.getWindowHandles();
				Iterator<String> iterator2 = handle.iterator();
				while (iterator2.hasNext()) {
					String handleID = (String) iterator2.next();

					if (!AmazonwindowHandle.equalsIgnoreCase(handleID)) {

						driver.switchTo().window(handleID);
						WebElement GetElements = driver.findElement(By.xpath("//div[@id='titleSection']/h1"));
						String GetT2 = GetElements.getText();
						System.out.println("Produc Name in unique page: " + GetT2);
						if (GetT1.equalsIgnoreCase(GetT2)) {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
						}
					}
				}

			}

			@Test(priority = 4)
			public static void screenshot() throws IOException {

				TakesScreenshot scrShot = ((TakesScreenshot) driver);
				File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
				File DestFile = new File("C:\\Users\\Manikandan P\\eclipse-workspace\\Amazon\\screenshot\\1.png");
				FileUtils.copyFile(SrcFile, DestFile);
			}

			@Test(priority = 5)
			public static void goToCart() throws InterruptedException {

				driver.findElement(By.xpath("(//a[contains(text(),'Go to Cart')])[2]")).click();
				Thread.sleep(2000);

			}

			@Test(priority = 6)
			public static void getTitlePage() throws IOException

			{
				List<WebElement> TitleName = driver
						.findElements(By.xpath("//li[@class='a-spacing-mini']//descendant::a[1]/span/span"));

				for (WebElement j2 : TitleName) {
					String GetT4 = j2.getText();
					System.out.println("Product Name in Cart Page: " + GetT4);
					if (GetT4==GetT1) {
						
					
					TakesScreenshot scrShot1 = ((TakesScreenshot) driver);
					File SrcFile1 = scrShot1.getScreenshotAs(OutputType.FILE);
					File DestFile1 = new File("C:\\Users\\Manikandan P\\eclipse-workspace\\Amazon\\screenshot\\2.png");
					FileUtils.copyFile(SrcFile1, DestFile1);
					
					driver.close();
					break;
					}
				}
			}
			
			@AfterClass
			public static void quit()
			{	
//				driver.quit();	
			}
		
	}
