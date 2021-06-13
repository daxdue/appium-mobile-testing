package ru.training.at.appium;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.training.at.appium.enums.PageObjectType;
import ru.training.at.appium.pageObjects.PageObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest <T extends PageObject> {

    private static AppiumDriver appiumDriver;
    protected PageObject pageObject;

    @BeforeSuite
    public void setUp() {
        setupAppiumDriver();
        pageObject = new PageObject(PageObjectType.NATIVE, appiumDriver);
    }

    @AfterSuite
    public void tearDown() {
        appiumDriver.closeApp();
    }

    private void setupAppiumDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "VCLNFC041811060");
        desiredCapabilities.setCapability("app",
                "/Users/sergeikochetkov/Documents/mobile_testing_hw/EPAMTestApp.apk");

        try {
            appiumDriver = new AppiumDriver(new URL(System.getProperty("ts.appium")), desiredCapabilities);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
