package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/java/Features/Flipkart.feature",
		glue = {"StepDefinitions"},
		plugin = {"pretty", "json:target/MyReports/report.json", "junit:target/MyReports/report.xml"},
		monochrome = true,
		strict = true,
		dryRun = false
		
		)

public class TestRunner 
{
	

}
