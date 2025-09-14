package com.example.tests;

import com.example.pages.LoginPage;
import com.example.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Valid login should land on inventory page")
    public void validLogin() {
        String user = ConfigReader.get("username");
        String pass = ConfigReader.get("password");
        boolean ok = new LoginPage()
                .openApp()
                .enterUsername(user)
                .enterPassword(pass)
                .clickLogin()
                .isLoggedIn();

        Assert.assertTrue(ok, "User should be logged in");
    }

    @Test(description = "Invalid login should show error")
    public void invalidLogin() {
        String user = "locked_out_user"; // known invalid in saucedemo
        String pass = "wrong_pass";
        LoginPage page = new LoginPage()
                .openApp()
                .enterUsername(user)
                .enterPassword(pass)
                .clickLogin();

        Assert.assertFalse(page.isLoggedIn(), "Should not log in with invalid creds");
        Assert.assertNotNull(page.getError(), "Error message should appear");
    }
}
