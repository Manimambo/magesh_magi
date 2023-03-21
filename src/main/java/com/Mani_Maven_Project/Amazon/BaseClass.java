package com.Mani_Maven_Project.Amazon;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass {

	public static WebDriver driver;

	public static WebDriver browser_Launch(String name) {

		if (name.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Manikandan P\\eclipse-workspace\\Amazon\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (name.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"F:\\sana_workspace\\Demo_Maven_Project\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		} else {
			System.out.println("Invalid browser");
		}
		return driver;
	}
	public static void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	public static void url_Launch(String url) {
		driver.get(url);
	}

	public static void implicit_Wait() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public static void explicit_Wait(WebElement element) {
		WebDriverWait wb = new WebDriverWait(driver, 20);
		wb.until(ExpectedConditions.visibilityOf(element));
	}

	public static void input(WebElement element, String name) {
		element.sendKeys(name);
	}

	public static void click(WebElement element) {
		element.click();
	}
	public static String scanner_Method() {
		Scanner sc=new Scanner(System.in);
		String number = sc.next();
		return number;
	}
	public static void getTitle() {
		driver.getTitle();
	}

	public static void getCurrentUrl() {
		driver.getCurrentUrl();
	}

	public static void getText(WebElement element) {
		element.getText();
	}

	public static void getAttribute(WebElement element, String value) {
		element.getAttribute(value);
	}

	public static void navigateTo(String value) {
		driver.navigate().to(value);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	public static void screenShot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("F:\\Demo_Maven_Project\\Screenshot" + name + ".png");
		FileUtils.copyFile(src, dest);
	}

	public static void isEnabled(WebElement element) {
		element.isEnabled();
	}

	public static void isDisplayed(WebElement element) {
		element.isDisplayed();
	}

	public static void isSelected(WebElement element) {
		element.isSelected();
	}

	public static void dropDown(WebElement element,String type, String value) {
		Select s = new Select(element);
		if (type.equals("value")) {
			s.selectByValue(value);	
		}else if (type.equals("index")) {
			int parseInt = Integer.parseInt(value);
			s.selectByIndex(parseInt);
		}else if (type.equals("text")) {
			s.selectByVisibleText(value);
		}
	}

	public static void dropDownGetOptions(WebElement element) {
		Select s = new Select(element);
		s.getOptions();
	}

	public static void dropDownGetFirstSelectedOption(WebElement element) {
		Select s = new Select(element);
		s.getFirstSelectedOption();
	}

	public static void dropDownGetAllSelectedOption(WebElement element) {
		Select s = new Select(element);
		s.getAllSelectedOptions();
	}

	public static void isMultiple(WebElement element) {
		Select s = new Select(element);
		s.isMultiple();
	}

	public static void javascriptExecutorMethod(WebElement element,String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (value.equalsIgnoreCase("scroll")) {
			js.executeScript("arguments[0].scrollIntoView();", element);
		}else if (value.equalsIgnoreCase("click")) {
			js.executeScript("arguments[0].click();", element);
		}
	}
	
	public static void javascriptExecutorInput(WebElement element) { //////////////////////////////
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('twotabsearchtextbox').value='toys';");
	}

	public static void frame_Method(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}

	public static void defaultContentFrame() {
		driver.switchTo().defaultContent();
	}

	public static void robot_DownArrow(String value) throws AWTException {
		Robot r = new Robot();
		if (value.equalsIgnoreCase("downarrow")) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}else if (value.equalsIgnoreCase("uparrow")) {
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
		}else if (value.equalsIgnoreCase("enter")) {
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}	
	}
	public static void actions_Method(WebElement element,String value) {
		Actions ac = new Actions(driver);
		if (value.equalsIgnoreCase("click")) {
			ac.click(element).build().perform();
		}else if (value.equalsIgnoreCase("doubleclick")) {
			ac.doubleClick(element).build().perform();	
		}else if (value.equalsIgnoreCase("contextclick")) {
			ac.contextClick(element).build().perform();
		}else if (value.equalsIgnoreCase("movetoelement")) {
			ac.moveToElement(element).build().perform();
		}else if (value.equalsIgnoreCase("clickandhold")) {
			ac.clickAndHold(element).build().perform();
		}
	}
	public static void actionsDragAndDrop(WebElement element1,WebElement element2) {
		Actions ac = new Actions(driver);
		ac.dragAndDrop(element1, element2).build().perform();
	}

	public static void windowHandle() {
		String windowHandle = driver.getWindowHandle();
		driver.switchTo().window(windowHandle);
	}

	public static void windowHandles() {	
		Set<String> windowHandles = driver.getWindowHandles();
		for (String win : windowHandles) {
			driver.switchTo().window(win);
		}
	}

	public static void alertAccept(String value) {
		if (value.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();	
		}else if (value.equalsIgnoreCase("dismiss")) {
			driver.switchTo().alert().dismiss();
		}
		}
			
	public static void alertPrompt(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public static void clear(WebElement element) {
		element.clear();
	}

	public static void quit() {
		driver.quit();
	}

	public static void close() {
		driver.close();
	}
	public static void sleep() throws InterruptedException {
Thread.sleep(2000);
	}
}
