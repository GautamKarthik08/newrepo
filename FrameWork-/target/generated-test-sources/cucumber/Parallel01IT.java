import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/code/RS_finsl2/FrameWork-/src/test/resources/features/RSValidation.feature"},
        plugin = {"json:C:/code/RS_finsl2/FrameWork-/target/cucumber-reports/1.json"},
        monochrome = false,
        tags = {},
        glue = {"com.tata.cliq"})
public class Parallel01IT {
}
