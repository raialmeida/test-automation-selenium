package com.automation.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.automation.base.BaseTest;
import com.automation.pages.RegisterPage;

import io.qameta.allure.Feature;

@Feature("Register")
public class RegisterTest extends BaseTest {

    @Test
    @DisplayName("Validate register successful")
    public void registerUser() {
        RegisterPage.typeFullName();
        RegisterPage.typeAdress();
        RegisterPage.typeEmail();
        RegisterPage.typePhone();
        RegisterPage.typeGender();
        RegisterPage.typeHobbies();
        RegisterPage.typeLanguages();
        RegisterPage.typeSkills();
        RegisterPage.typeSelectCountry();
        RegisterPage.typeSelectDateOfBirth();
        RegisterPage.typePassword();
        RegisterPage.typeConfirmPassword();
        RegisterPage.clickButtonSubmit();
    }
}
