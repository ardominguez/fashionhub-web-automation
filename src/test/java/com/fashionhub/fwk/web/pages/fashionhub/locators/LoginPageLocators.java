package com.fashionhub.fwk.web.pages.fashionhub.locators;

public class LoginPageLocators {


    private LoginPageLocators() {}

    public static final String LOGIN_ID_FORM = "//form[@id='loginForm']";
    public static final String USERNAME_INPUT = "//input[@id='username']";
    public static final String PASSWORD_INPUT = "//input[@id='password']";
    public static final String LOGIN_INPUT_BUTTON = "//form[@id='loginForm']/input[@type='submit']";
    public static final String INVALID_CREDENTIALS_ERROR_MESSAGE_DIV = "//form[@id='loginForm']/div[@id='errorMessage']" ;
}
