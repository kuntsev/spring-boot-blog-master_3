package com.kuntsev;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/features/login.feature"},
        glue = {"stepdefs"}
)
public class LoginTestRunner {
}
