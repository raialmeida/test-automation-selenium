package com.automation.pages;

import com.automation.base.DSL;

import io.qameta.allure.Step;

public class RegisterPage extends DSL {

    @Step("Type fullname")
    public static void typeFullName() {
        typeByCss("input[ng-model='FirstName']", "Paulo");
        typeByCss("input[ng-model='LastName']", "Santos");
    }

    @Step("Type adress")
    public static void typeAdress() {
        typeByCss("textarea[ng-model='Adress']", "Rua");
    }
}
