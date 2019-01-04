import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue= {"StepDefinitions"},
        tags= {"@SmokeTests,@RegressionTests"},
        //plugin= {"html:Test Results/cucumber-html-report"})
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:cucumber-reports/report.html"})

public class TestRunner {

}
