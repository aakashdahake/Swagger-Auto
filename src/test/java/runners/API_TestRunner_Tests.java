package runners;


import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features/API-Tests.feature", 
		glue = "stepDefinitions", 
		plugin = { "pretty", "json:test-output/cucumber.json","testng:test-output/cucumber.xml", "html:test-output/Accounts.html" }, 
		publish = false, 
		monochrome = true, 
		dryRun = false
		//tags = "@test3"
		)

@Test
public class API_TestRunner_Tests extends AbstractTestNGCucumberTests{

}
