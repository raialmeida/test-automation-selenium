package com.automation.utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import com.automation.base.BaseTest;

public class AutoScreenshotExtension extends BaseTest implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        if (driver != null) {
            ScreenshotUtils.takeScreenshot(driver);
        }
    }
}
