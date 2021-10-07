package MyRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/Feature"},
        glue = {"StepDefinition"}
)
public class MyRunner extends AbstractTestNGCucumberTests {

    //@Override
    //@DataProvider(parallel = true)
    //public Object[][] scenarios() {
    //    return super.scenarios();
    //}
}
