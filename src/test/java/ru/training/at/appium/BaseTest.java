package ru.training.at.appium;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ru.training.at.appium.constants.AppParameters;
import ru.training.at.appium.constants.Errors;
import ru.training.at.appium.enums.PageObjectType;
import ru.training.at.appium.pageObjects.NativePageObject;
import ru.training.at.appium.pageObjects.PageObjectInterface;
import ru.training.at.appium.pageObjects.WebPageObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static ru.training.at.appium.constants.AppiumDesiredCapabilities.*;

public class BaseTest {

    protected AppiumDriver appiumDriver;
    protected PageObjectInterface pageObject;

    @BeforeSuite
    @Parameters({APP_TYPE, PLATFORM_NAME, DEVICE_NAME, APP, BROWSER_NAME})
    public void setUp(String appType, String platformName, String deviceName,
                      @Optional("") String app, @Optional("") String browserName)
            throws Exception {

        PageObjectType pageObjectType = Stream.of(PageObjectType.values())
                .filter(pot -> pot.getValue().equals(appType))
                .findFirst()
                .orElseThrow(() -> new Exception(Errors.UNKNOWN_PAGE_OBJECT_TYPE));

        setupAppiumDriver(pageObjectType, platformName, deviceName, app, browserName);

        switch (pageObjectType) {
            case NATIVE:
                pageObject = new NativePageObject(appiumDriver);
                break;

            case WEB:
                pageObject = new WebPageObject(appiumDriver);
                break;
        }
    }

    @AfterSuite
    public void tearDown() {
        appiumDriver.closeApp();
    }

    private void setupAppiumDriver(PageObjectType pageObjectType, String platformName,
                                   String deviceName, String app, String browserName)
            throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(PLATFORM_NAME, platformName);
        desiredCapabilities.setCapability(DEVICE_NAME, deviceName);

        switch (pageObjectType) {
            case NATIVE:
                if(app.endsWith(AppParameters.APP_EXTENSION)) {
                    desiredCapabilities.setCapability(APP,
                            new File(app).getAbsolutePath());
                } else {
                    throw new Exception(Errors.PROBLEMS_WITH_APP);
                }
                break;
            case WEB:
                desiredCapabilities.setCapability(BROWSER_NAME, browserName);
                break;
        }
        try {
            appiumDriver = new AppiumDriver(new URL(
                    System.getProperty(AppParameters.APPIUM_URL_PROPERTY)),
                    desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


}
