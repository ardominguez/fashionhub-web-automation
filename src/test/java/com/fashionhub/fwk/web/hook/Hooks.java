package com.fashionhub.fwk.web.hook;

import com.fashionhub.fwk.web.utils.FileUtils;
import com.fashionhub.fwk.web.utils.ScreenshotUtil;
import io.cucumber.java.*;
import lombok.Getter;

@Getter
public class Hooks {

    private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @After
    public void tearDown(Scenario scenario) {
        String imageName = FileUtils.formatScenarioName(scenario.getName());
        byte[] sourcePath = ScreenshotUtil.saveScreenshotFile(testContext.getPage(), imageName);
        scenario.attach(sourcePath, "image/png",  scenario.getName());

        testContext.getBrowser().close();
    }
}
