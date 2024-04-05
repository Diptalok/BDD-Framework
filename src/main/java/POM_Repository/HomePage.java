package POM_Repository;

import Generic_Utilities.Selenium_Utiity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Selenium_Utiity{
	
	@FindBy(linkText ="Contacts") private WebElement contact;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]") private WebElement snimg;
	
	@FindBy(linkText="Sign Out") private WebElement signout;
	
	//business logic
	public void contact() {
		contact.click();
	}
	public void mouseHover(WebDriver driver) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(snimg).perform();
		Thread.sleep(1000);
	}
	public void signout() {
		signout.click();
	}
	
}
