package com.example.pages;

import com.example.core.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By inventoryContainer = By.id("inventory_container");
    private final By error = By.cssSelector("[data-test='error']");

    public LoginPage openApp() {
        openBaseUrl();
        return this;
    }

    public LoginPage enterUsername(String user) {
        type(username, user);
        return this;
    }

    public LoginPage enterPassword(String pass) {
        type(password, pass);
        return this;
    }

    public LoginPage clickLogin() {
        click(loginBtn);
        return this;
    }

    public boolean isLoggedIn() {
        try {
            return !driver.findElements(inventoryContainer).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public String getError() {
        try {
            return text(error);
        } catch (Exception e) {
            return null;
        }
    }
}
