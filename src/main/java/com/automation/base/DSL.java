package com.automation.base;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Allure;

/**
 * DSL (Domain Specific Language) class that provides simplified
 * methods for interacting with web elements in Selenium WebDriver.
 * <p>
 * All actions performed through this class are automatically logged
 * into Allure reports for better traceability.
 */
public class DSL extends BaseTest {

    /**
     * Sends input into a web element identified by a Selenium {@link By} locator.
     * 
     * @param locator The Selenium {@link By} locator of the element (e.g., By.id,
     *                By.cssSelector, By.xpath).
     * @param value   The value or keys to send to the element (text, numbers, or
     *                {@link CharSequence} like {@link org.openqa.selenium.Keys}).
     */
    public static void type(By locator, CharSequence value) {
        WebElement element = driver.findElement(locator);
        // Generate readable description from By object for Allure
        String locatorDescription = locator.toString(); // Ex: "By.cssSelector: #username"
        Allure.step("Type '" + value + "' into element: " + locatorDescription, () -> {
            element.sendKeys(value);
        });
    }

    /**
     * Clicks on a web element identified by a Selenium {@link By} locator.
     * 
     * @param locator The Selenium {@link By} locator of the element.
     */
    public static void click(By locator) {
        WebElement element = driver.findElement(locator);
        String locatorDescription = locator.toString();
        Allure.step("Click on element: " + locatorDescription, element::click);
    }

    /**
     * Gets text from a web element identified by a Selenium {@link By} locator.
     * 
     * @param locator The Selenium {@link By} locator of the element.
     * @return The text content of the element.
     */
    public static String getText(By locator) {
        WebElement element = driver.findElement(locator);
        String locatorDescription = locator.toString();
        final String[] result = new String[1];
        Allure.step("Get text from element: " + locatorDescription, () -> result[0] = element.getText());
        return result[0];
    }

    /**
     * Clicks a web element from a group by its value.
     * 
     * @param locator The Selenium {@link By} locator for the radio buttons group.
     * @param value   The value attribute of the element to click.
     */
    public static void click(By locator, String value) {
        List<WebElement> elements = driver.findElements(locator);
        boolean found = false;
        for (WebElement element : elements) {
            if (value.equalsIgnoreCase(element.getAttribute("value"))) {
                Allure.step("Click radio button with value: " + value, element::click);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new RuntimeException("Element with value '" + value + "' not found using locator: " + locator);
        }
    }

    /**
     * Selects a value from a custom multi-select dropdown.
     *
     * @param containerLocator The locator for the multi-select container (the
     *                         clickable div).
     * @param optionText       The visible text of the option to select.
     */
    public static void selectFromMultiSelect(By containerLocator, String optionText) {
        // Step 1: Click the container to open the dropdown
        WebElement container = driver.findElement(containerLocator);
        Allure.step("Open multi-select dropdown: " + containerLocator, container::click);

        // Step 2: Find all options inside the container's sibling dropdown
        WebElement dropdown = container.findElement(By.xpath("./following-sibling::div/ul"));
        List<WebElement> options = dropdown.findElements(By.tagName("a"));

        // Step 3: Find option by text
        WebElement option = options.stream()
                .filter(o -> o.getText().equals(optionText))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Option '" + optionText + "' not found in multi-select"));

        // Step 4: Click the option
        Allure.step("Select option '" + optionText + "' from multi-select", option::click);
    }

    /**
     * Selects an option from a standard HTML element.
     *
     * @param selectLocator The Selenium {@link By} locator of the element.
     * @param value         The visible text of the option to select.
     */
    public static void selectByVisibleText(By selectLocator, String value) {
        WebElement selectElement = driver.findElement(selectLocator);
        Select select = new Select(selectElement);

        Allure.step("Select '" + value + "' from dropdown: " + selectLocator, () -> {
            select.selectByVisibleText(value);
        });
    }

    /**
     * Select an option from a custom dropdown (e.g., Select2) by visible text.
     *
     * @param dropdownLocator The locator to open the dropdown.
     * @param optionText      The visible text of the option to select.
     */
    public static void selectFromCustomDropdown(By dropdownLocator, String optionText) {
        WebElement dropdown = driver.findElement(dropdownLocator);
        Allure.step("Open custom dropdown: " + dropdownLocator, dropdown::click);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> options = wait.until(d -> d.findElements(By.cssSelector(".select2-results__option")));

        Optional<WebElement> match = options.stream()
                .filter(e -> optionText.equals(e.getText()))
                .findFirst();

        if (match.isPresent()) {
            Allure.step("Select option '" + optionText + "' from custom dropdown", match.get()::click);
        } else {
            throw new RuntimeException("Option '" + optionText + "' not found in custom dropdown");
        }
    }
}
