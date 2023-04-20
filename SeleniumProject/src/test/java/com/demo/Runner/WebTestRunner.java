package com.demo.Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features/gui",
        glue = {"classpath:com.demo", "com/Demo/gui/utils"},
        tags = "@Test_3",
        plugin = {"pretty","html:reports/cucumber-reports.html"},
        monochrome = true
)
public class WebTestRunner extends AbstractTestNGCucumberTests {

}
