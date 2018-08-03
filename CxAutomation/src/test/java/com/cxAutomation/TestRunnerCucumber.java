package com.cxAutomation;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        format={"pretty", "html:target/cucumber"},
        tags={"@ActiveFeature","@Active", },
        //tags={"@Dev" },
        features="src/test/resource/FeatureFiles"
        )

public class TestRunnerCucumber{
	
}
