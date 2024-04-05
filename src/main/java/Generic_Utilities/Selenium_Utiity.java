package Generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

//import org.apache.commons.io.FileUtils;
//import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * class having selenium utility methods
 * @author dipta
 */
public class Selenium_Utiity {
	
	/**
	 * this method will launch the application
	 * @param driver
	 * @param URL
	 */
	public void launchApp(WebDriver driver,String URL) {
		driver.get(URL);
	}
	
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * this method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * this method will perform implicit wait
	 * @param driver
	 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * this method will perform explicit wait
	 * @param driver
	 * @param element
	 */
	public void explicitWait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * this method will perform fluent wait
	 * @param driver
	 * @param element
	 */
	public void addFluentWait(WebDriver driver, WebElement element) {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(10));
		wait.withTimeout(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * this method will handle drop down by index
	 * @param element
	 * @param no
	 */
	public void handleDropDown(WebElement element,int no) {
		Select se = new Select(element);
		se.selectByIndex(no);
	}
	
	/**
	 * this method will handle drop down by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element,String value) {
		Select se = new Select(element);
		se.selectByValue(value);
	}
	
	/**
	 * this method will handle drop down by visible text
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element) {
		Select se = new Select(element);
		se.selectByVisibleText(text);
	}
	
	/**
	 * this method will perform move to element
	 * @param driver
	 * @param element
	 */
	public void mouseHover (WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * this method will perform double click
	 * @param driver
	 * @param element
	 */
	public void doubleClick (WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * this method will perform right click
	 * @param driver
	 * @param element
	 */
	public void rightClick (WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * this method will drag one element and drop it in destination  
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragandDrop (WebDriver driver, WebElement src, WebElement dst) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}
	
	/**
	 * this method will perform scroll down to a particular web element
	 * @param driver
	 * @param element
	 */
	public void scrollToWebelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	/**
	 * this method will perform scroll down to 500 unit
	 * @param driver
	 */
	public void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(0,500);","");
	}
	
	/**
	 * this method will handle the frame by frame index
	 * @param driver
	 * @param no
	 */
	public void frameHandling(WebDriver driver,int frindex) {
		driver.switchTo().frame(frindex);
	}
	
	/**
	 * this method will handle the frame by frame name
	 * @param driver
	 * @param fname
	 */
	public void frameHandling(WebDriver driver,String frname) {
		driver.switchTo().frame(frname);
	}
	
	/**
	 * this method will handle the frame by frame id
	 * @param fid
	 * @param driver
	 */
	public void frameHandling(String frid,WebDriver driver) {
		driver.switchTo().frame(frid);
	}
	
	/**
	 * this method will handle the frame by frame webelement
	 * @param driver
	 * @param element
	 */
	public void frameHandling(WebDriver driver,WebElement frameelement) {
		driver.switchTo().frame(frameelement);
	}
	
	/**
	 * this method will return the control to parent frame
	 * @param driver
	 */
	public void frameHandling(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * this method will accept alert pop up
	 * @param driver
	 */
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method will dismiss alert pop up
	 * @param driver
	 */
	public void alertDissmiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * this method will capture text of alert and return it to caller
	 * @param driver
	 * @return
	 */
	public String alertGettext(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * this method will send text to alert pop up
	 * @param driver
	 * @param input
	 */
	public void alertInput(WebDriver driver,String input) {
		driver.switchTo().alert().sendKeys(input);
	}
	
	/**
	 * this method is to go backward
	 * @param driver
	 */
	public void window(WebDriver driver) {
		for(int i = 1;i<3;i++) {
		driver.navigate().back();
		}
	}
	
	/**
	 * this method is used to capture screenshot and return path to caller
	 * @param screenshotname
	 * @param driver
	 * @return
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public String screenshot(WebDriver driver, String screenshotname) throws IOException, InterruptedException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\"+screenshotname+".png");
		//FileUtils.copyFile(src, dst);
		Files.copy(src, dst);
		Thread.sleep(3000);
		return dst.getAbsolutePath();  //used in extent reports
	}
	
	public void quit(WebDriver driver) {
		driver.quit();
	}

}
