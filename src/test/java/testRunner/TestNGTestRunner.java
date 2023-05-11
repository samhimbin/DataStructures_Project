package testRunner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driverFactory.DriverSetUp;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:target/hima.html", // cucumber report
		                     // "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
                           }, // reporting purpose
		                  monochrome = false, // console output color
		                  tags = "@portal or @login or @dstruct", 
		                  features = { "src/test/resources/features" }, 
		                  glue = {"stepdefinitions", "HooksPkg" })

@Test
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

	@DataProvider(parallel=false)
	public Object[][]scenarios(){
		return super.scenarios();
	}
	@BeforeTest
	@Parameters({"browser"})
	public  void defineBrowser(String browser)throws Throwable{
		DriverSetUp.setBrowserType(browser);;
	}
}
