package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.Selenium_Utiity;

public class DeleteContactPage extends Selenium_Utiity {
	
	public DeleteContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="selectall") private WebElement chkbx;
	@FindBy(xpath="//input[@value=\"Delete\"]") private WebElement delete;
	
	public void checkbox() {
		chkbx.click();
	}
	public void delete() {
		delete.click();
	}
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	
	
	
	
}
