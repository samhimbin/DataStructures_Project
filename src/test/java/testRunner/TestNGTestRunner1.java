package testRunner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = {"pretty", "html:target/ds_algo.html",
                           // "rerun:target/rerun.txt"  ,//mandatory for capture failures 
                          //  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                          //  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
                         },				
		                   monochrome=false,
							tags="@portal or @home or @register",
							//tags="@tag1",
							features={"src/test/resources/features"},
							glue = {"stepdefinitions","HooksPkg"})

public class TestNGTestRunner1 extends AbstractTestNGCucumberTests{

}
