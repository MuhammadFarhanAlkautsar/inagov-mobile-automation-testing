package inadigital.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        plugin = {
                "pretty",
                "html:report/automation-report.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        glue = {
                "inadigital.steps_definition", // Specify the package for step definitions
                "inadigital.hooks" // Specify the package for hooks
        },
        features = {
                "classpath:features"
        }
)
public class TestRunner {
}
