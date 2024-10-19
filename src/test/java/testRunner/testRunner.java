package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/GetProducts.feature",
        glue = {"stepdefinitions"},
        plugin = {"json:target/cucumber.json"},
        tags = "@getProducts",
        monochrome = true
)
public class testRunner {

}
