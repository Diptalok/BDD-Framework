package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LogInToAppTest {
    WebDriver driver;
	
	@Given("I want to launch the browser")
	public void i_want_to_launch_the_browser() {
		driver=new ChromeDriver();
	}
	
	@Given("Load the URl")
    public void load_the_u_rl() {
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@When("Log in page is displayed enter the username and password")
    public void log_in_page_is_displayed_enter_the_username_and_password() {
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
	}
	
	@When("click on the log in button")
    public void click_on_the_log_in_button() {
		driver.findElement(By.id("submitButton")).click();
	}
	@Then("Validate for Homepage")
	public void validate_for_homepage() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
		System.out.println("homepage is accessed");
	}
	@When("homepage is displayed move to adminstrator")
	public void homepage_is_displayed_move_to_adminstrator() {
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
	    act.moveToElement(ele).perform();
	}
	@When("Click on sign out")
	public void click_on_sign_out() throws InterruptedException {
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("Sign Out")).click();
	}
	@Then("validate for signout")
	public void validate_for_signout() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "vtiger CRM 5 - Commercial Open Source CRM");
		System.out.println("sign out successful");
	}
	@Then("close the browser")
	public void close_the_browser() {
	    driver.close();
	}
	
}
