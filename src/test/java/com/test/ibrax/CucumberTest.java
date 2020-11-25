package com.test.ibrax;

import io.cucumber.testng.CucumberOptions;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */

@CucumberOptions(features = "src/test/resources/features",
        plugin = {"pretty", "html:target/cucumber/subscriber"},
        glue = "com.test.ibrax")
public class CucumberTest extends AbstractTestNGSpringContextTests {
}
