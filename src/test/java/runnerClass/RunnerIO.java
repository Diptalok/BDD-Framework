package runnerClass;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".\\src\\test\\java\\featureFiles\\LogInToApp.feature",
		glue = "stepdefinitions",
		dryRun = false  //browser not launch but step definitions generated
		
		
		)

public class RunnerIO extends AbstractTestNGCucumberTests {
	
	

}
