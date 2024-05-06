package StepDefination;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Feature",
glue={"StepDefination"},
plugin= {"pretty","html:target/results.html"},
dryRun=false,
tags= "@regression or @smoke"
)
public class TestRunner {

}
