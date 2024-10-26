package com.fashionhub.fwk.web;

import org.junit.platform.suite.api.*;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "com.fashionhub.fwk.web"
)
@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "json:reports/cucumber-report/web-report.json," +
                "html:reports/cucumber-report/web-report.html," +
                "timeline:reports/cucumber-report/web-timeline-report"
)
public class RunnerWebTests {
}
