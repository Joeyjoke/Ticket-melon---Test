package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature/Test.feature",
		format = {"json:target/cucumber.json"},
		//tags = "@Test",
		glue= {"stepdefinition"},
		monochrome = true
		)
public class TestRunner {

}
