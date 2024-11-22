package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        features = "src/test/java/features/GetProducts.feature",
        features = "src/test/java/features",
        glue = {"stepdefinitions"},
        plugin = {"json:target/cucumber.json"},
//        tags = "@Products",
        monochrome = true
)
public class testRunner {

}
