package com.automation.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automation.utils.AutoScreenshotExtension;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(AutoScreenshotExtension.class)
public class BaseTest {

    protected static WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Register.html");
    }

    @AfterAll
    public void teardown() {
        driver.quit();
    }
}
