package com.automation.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.automation.utils.AutoScreenshotExtension;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(AutoScreenshotExtension.class)
public class BaseTest {

    protected static WebDriver driver;

    @BeforeAll
    public void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        String headlessParam = System.getProperty("headless", System.getenv("HEADLESS"));
        boolean headless = headlessParam != null && headlessParam.equalsIgnoreCase("true");
        if (headless) {
            options.addArguments("--headless=new");
        }

        driver = new ChromeDriver(options);
        driver.get("https://demo.automationtesting.in/Register.html");
    }

    @AfterAll
    public void teardown() {
        driver.quit();
    }
}
