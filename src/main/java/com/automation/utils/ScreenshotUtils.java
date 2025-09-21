package com.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Attachment;

public class ScreenshotUtils {

    @Attachment(value = "Screenshot", type = "image/jpeg")
    public static byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Element Screenshot", type = "image/jpeg")
    public static byte[] takeScreenshot(WebElement element) {
        return element.getScreenshotAs(OutputType.BYTES);
    }
}
