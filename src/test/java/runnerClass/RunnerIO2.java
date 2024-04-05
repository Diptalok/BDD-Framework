package runnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".\\src\\test\\java\\ContactFeatureFile\\CreateContact.feature",
		glue = "StepDefinitionsForContactPage" ,
		dryRun = false
		
		)

public class RunnerIO2 extends AbstractTestNGCucumberTests {
	
	

}
