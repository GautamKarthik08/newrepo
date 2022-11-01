import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/code/RS_Test/src/test/resources/features/Registration.feature"},
        plugin = {"json:C:/code/RS_Test/target/cucumber-reports/9.json"},
        monochrome = false,
        tags = {},
        glue = {"com.tata.cliq"})
public class Parallel09IT {
}
