package com.automation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Allure;

public class DSL extends BaseTest {

    /**
     * Types value into an element located by CSS selector.
     *
     * @param css   The CSS selector of the element.
     * @param value The value to type into the element.
     */
    public static void typeByCss(String css, String value) {
        WebElement element = driver.findElement(By.cssSelector(css));
        Allure.step("Type '" + value + "' into element with CSS: " + css);
        element.sendKeys(value);
    }

    /**
     * Types value into an element located by ID.
     *
     * @param id    The ID of the element.
     * @param value The value to type into the element.
     */
    public static void typeById(String id, String value) {
        driver.findElement(By.id(id)).sendKeys(value);
    }

    /**
     * Types value into an element located by XPath.
     *
     * @param xpath The XPath of the element.
     * @param value The value to type into the element.
     */
    public static void typeByXpath(String xpath, String value) {
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    /**
     * Types value into an element located by tag name.
     *
     * @param tag   The tag name of the element.
     * @param value The value to type into the element.
     *
     * @note This method will type into the first element found with the specified
     *       tag.
     */
    public static void typeByTag(String tag, String value) {
        driver.findElement(By.tagName(tag)).sendKeys(value);
    }
}