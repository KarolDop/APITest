package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/Pet.feature", glue = "stepsDefinitions")
public class PetRunners extends  AbstractTestNGCucumberTests
{

}
