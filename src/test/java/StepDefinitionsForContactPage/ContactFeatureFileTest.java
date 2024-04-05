package StepDefinitionsForContactPage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Generic_Utilities.ExcelFileUtility;
import Generic_Utilities.PropertyFileUtility;
import Generic_Utilities.Selenium_Utiity;
import POM_Repository.ContactPage;
import POM_Repository.Create_ContactPage;
import POM_Repository.DeleteContactPage;
import POM_Repository.HeaderCapturePage;
import POM_Repository.HomePage;
import POM_Repository.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactFeatureFileTest {

	WebDriver driver;
	PropertyFileUtility putil = new PropertyFileUtility();
	Selenium_Utiity sutil = new Selenium_Utiity();
	ExcelFileUtility eutil = new ExcelFileUtility();

	@Given("I want to launch the browser")
	public void i_want_to_launch_the_browser() {
		driver = new ChromeDriver();
	}

	@Given("Load the URl")
	public void load_the_u_rl() throws IOException {
		String URL = putil.ReadDataProp("url");
		sutil.launchApp(driver, URL);
		sutil.maximizeWindow(driver);
		sutil.implicitWait(driver);
	}

	@When("Log in page is displayed enter the username and password and click on the log in button")
	public void log_in_page_is_displayed_enter_the_username_and_password_click_login_button() throws IOException {
		String USER = putil.ReadDataProp("user");
		String PASS = putil.ReadDataProp("pass");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USER, PASS);
		System.out.println("Log in successful");
	}
	
	@Then("Validate for Homepage")
	public void validate_for_homepage() throws Exception {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
		System.out.println("Homepage is reached");
		sutil.screenshot(driver, "validation for visibility of homepage");
		//Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM
	}

	@When("Homepage is visible click on contact link")
	public void homepage_is_visible_click_on_contact_link() {
		HomePage hp = new HomePage(driver);
		hp.contact();
	}

	@Then("validate contact page is visible")
	public void validate_contact_page_is_visible() throws Exception {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM");
		System.out.println("Contact page is reached");
		sutil.screenshot(driver, "validation for visibility of contact page");
	}

	@When("contact page is visible click on Add contact picture")
	public void contact_page_is_visible_click_on_add_contact_picture() {
		Create_ContactPage ccp = new Create_ContactPage(driver);
		ccp.create();
	}

	@Then("validate create new contact page is visible")
	public void validate_create_new_contact_page_is_visible() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM");
		System.out.println("new Contact page is reached");
	}

	@When("new contact page is visible fill up the mandatory fields in create contact page and save it")
	public void new_contact_page_is_visible_fill_up_the_mandatory_fields_in_create_contact_page() throws EncryptedDocumentException, IOException {
		ContactPage cp = new ContactPage(driver);
		String LASTNAME = eutil.ReadDataExcel("Sheet1", 0, 0);
		String LEAD = eutil.ReadDataExcel("Sheet1", 0, 1);
		cp.lastname(LASTNAME);
		cp.handleDropDown(LEAD);
		cp.save();
	}
	
	@Then("validate a new contact is created")
	public void validate_a_new_contact_is_created() throws Exception {
		HeaderCapturePage hcp = new HeaderCapturePage(driver);
		System.out.println(hcp.header());
		sutil.screenshot(driver, "validation for new contact");
	}

	@When("going backward twice contact page is visible")
	public void going_backward_twice_contact_page_is_visible() {
		sutil.window(driver);
	}

	@Then("click on delete contact")
	public void click_on_delete_contact() {
		DeleteContactPage dp = new DeleteContactPage(driver);
		dp.checkbox();
	}

	@When("alert asking for confirmation")
	public void alert_asking_for_confirmation() {
		DeleteContactPage dp = new DeleteContactPage(driver);
		dp.delete();	
	}

	@Then("accept the alert")
	public void accept_the_alert() {
		DeleteContactPage dp = new DeleteContactPage(driver);
		dp.alertAccept(driver);
	}

	@Then("take a screenshot for validation")
	public void take_a_screenshot_for_validation() throws Exception{
		sutil.screenshot(driver, "Validation of deletion");
	}

	@When("homepage is displayed move to adminstrator")
	public void homepage_is_displayed_move_to_adminstrator() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		Thread.sleep(2000);
		hp.mouseHover(driver);
	}

	@When("Click on sign out")
	public void click_on_sign_out() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.signout();
	}

	@Then("validate for signout")
	public void validate_for_signout() throws Exception {
			String title = driver.getTitle();
			Assert.assertEquals(title, "vtiger CRM 5 - Commercial Open Source CRM");
			System.out.println("sign out successful");
			sutil.screenshot(driver, "validation for visibility of log in page");
		}

	@Then("close the browser")
	public void close_the_browser() {
		driver.close();
	}

}
