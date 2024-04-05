package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name="user_name") private WebElement useredt;
	@FindBy(name="user_password") private WebElement passedt;
	@FindBy(id="submitButton") private WebElement logbtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUseredt() {
		return useredt;
	}
	public WebElement getPassedt() {
		return passedt;
	}
	public WebElement getLogbtn() {
		return logbtn;
	}
	
	//business library (optional)
	/**
	 * This method is used to log in
	 * @param user
	 * @param pass
	 */
	public void loginToApp(String user,String pass) {
		useredt.sendKeys(user);
		passedt.sendKeys(pass);
		logbtn.click();
	}
	
}
