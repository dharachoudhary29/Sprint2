package TestRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resource\\Features",
glue="StepDefinition",tags="@birthday")
//  plugin= {"pretty", 
//   "html:target/HTMLReports/LinkedinReport.html",	
//   "json:target/JSONReports/LinkedinReport.json",
//    "junit:target/JUNITReports/LinkedinReport.xml",
//   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class Runner extends AbstractTestNGCucumberTests {

}