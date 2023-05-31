package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/TestEn.feature",
        glue = "StepsDefinitions",
        tags = {"@Login,@Buy_Product"},
        snippets = SnippetType.CAMELCASE
)
public class MyRunner {

}
