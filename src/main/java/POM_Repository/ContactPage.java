package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Generic_Utilities.Selenium_Utiity;

public class ContactPage extends Selenium_Utiity {
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname") private WebElement lstnm;
	
	public void lastname(String VAL) {
		lstnm.sendKeys(VAL);
	}
	
	@FindBy(name="leadsource") private WebElement drp;
	
	public void handleDropDown(String text) {
		Select se = new Select(drp);
		se.selectByVisibleText(text);
	}
	
	@FindBy(xpath="//input[@value=\"  Save  \"]") private WebElement save;
	public void save() {
		save.click();
	}
	
	

}
