package com.example.tests;

import com.example.core.DriverFactory;
import com.example.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {

    @Parameters({ "browser", "headless" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, @Optional("false") String headless) {
        // Allow suite parameters to override config file
        System.setProperty("browser", browser);
        System.setProperty("headless", headless);
        DriverFactory.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
