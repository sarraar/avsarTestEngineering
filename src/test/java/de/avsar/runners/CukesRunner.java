package de.avsar.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "json:target/cucumber-reports/cucumber.json"},
        features = "src/test/resources/features",
        glue = "de/avsar/step_definitions",
        dryRun = false,
        tags = "@test"

)
public class CukesRunner {

}
