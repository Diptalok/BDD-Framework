package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderCapturePage {
	
	public HeaderCapturePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(.,\"[\")]") private WebElement header;
	
	public String header() {
		String htext = header.getText();
		System.out.println(htext);
		if(htext.contains("Sahoo")) {
		}
		String pass="New contact is created";
		return pass;
	}
	
}
