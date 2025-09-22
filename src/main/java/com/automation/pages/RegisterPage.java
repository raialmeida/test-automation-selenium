package com.automation.pages;

import org.openqa.selenium.By;

import com.automation.base.DSL;

import io.qameta.allure.Step;

public class RegisterPage extends DSL {

    @Step("Type fullname")
    public static void typeFullName() {
        type(By.cssSelector("input[ng-model='FirstName']"), "Paulo");
        type(By.cssSelector("input[ng-model='LastName']"), "Santos");
    }

    @Step("Type adress")
    public static void typeAdress() {
        type(By.cssSelector("textarea[ng-model='Adress']"), "Rua do Teste 545");
    }

    @Step("Type Email")
    public static void typeEmail() {
        type(By.cssSelector("input[ng-model='EmailAdress']"), "testesx@hotmail.com");
    }

    @Step("Type Phone")
    public static void typePhone() {
        type(By.cssSelector("input[ng-model='Phone']"), "1198765432");
    }

    @Step("Select Gender")
    public static void typeGender() {
        click(By.cssSelector("input[name='radiooptions']"), "Male");
    }

    @Step("Select Hobbies")
    public static void typeHobbies() {
        click(By.cssSelector("input[type='checkbox']"), "Movies");
    }

    @Step("Select Languages")
    public static void typeLanguages() {
        selectFromMultiSelect(By.id("msdd"), "English");
    }

    @Step("Select Skills")
    public static void typeSkills() {
        selectByVisibleText(By.id("Skills"), "Java");
    }

    @Step("Select Country")
    public static void typeSelectCountry() {
        selectFromCustomDropdown(By.cssSelector(".select2-selection"), "United States of America");
    }

    @Step("Select Date Of Birth")
    public static void typeSelectDateOfBirth() {
        selectByVisibleText(By.id("yearbox"), "1994");
        selectByVisibleText(By.cssSelector("select[ng-model='monthbox']"), "February");
        selectByVisibleText(By.id("daybox"), "12");
    }

    @Step("Type Password")
    public static void typePassword() {
        type(By.id("firstpassword"), "ertrgrvs21544");
    }

    @Step("Type Confirm Password")
    public static void typeConfirmPassword() {
        type(By.id("secondpassword"), "ertrgrvs21544");
    }

    @Step("Click button submit")
    public static void clickButtonSubmit() {
        click(By.id("submitbtn"));
    }
}
