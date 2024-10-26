package com.fashionhub.fwk.web.hook;

import com.fashionhub.fwk.web.utils.ScreenshotUtil;
import io.cucumber.java.*;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Hooks {

    private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @After
    public void tearDown(Scenario scenario) {
        byte[] sourcePath = ScreenshotUtil.saveScreenshotFile(testContext.getPage(), UUID.randomUUID().toString());
        scenario.attach(sourcePath, "image/png",  scenario.getName());

        testContext.getBrowser().close();
        testContext.getPage().close();
    }
}
