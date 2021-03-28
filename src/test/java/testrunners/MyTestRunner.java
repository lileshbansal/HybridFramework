package testrunners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"stepdefinitions"},
		plugin = {"pretty",	"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",	"timeline:test-output-thread/"},
		tags= "@logintest"
		
		)

public class MyTestRunner extends AbstractTestNGCucumberTests{

}
