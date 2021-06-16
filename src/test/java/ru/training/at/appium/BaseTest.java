package ru.training.at.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ru.training.at.appium.constants.AppParameters;
import ru.training.at.appium.constants.Errors;
import ru.training.at.appium.enums.PageObjectType;
import ru.training.at.appium.enums.SwipeDirection;
import ru.training.at.appium.pageObjects.NativePageObject;
import ru.training.at.appium.pageObjects.PageObjectInterface;
import ru.training.at.appium.pageObjects.WebPageObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static ru.training.at.appium.constants.AppiumDesiredCapabilities.*;

public class BaseTest {

    protected AppiumDriver appiumDriver;
    protected PageObjectInterface pageObject;

    @BeforeSuite
    @Parameters({APP_TYPE, PLATFORM_NAME, DEVICE_NAME, APP,
            BROWSER_NAME, UDID_NAME, BUNDLEID_NAME, APP_ACTIVITY_NAME, APP_PACKAGE_NAME})
    public void setUp(String appType, String platformName, @Optional("") String deviceName,
                      @Optional("") String app, @Optional("") String browserName,
                      @Optional("") String udid, @Optional("") String bundleId,
                      @Optional("") String appActivity, @Optional("") String appPackage)
            throws Exception {

        PageObjectType pageObjectType = Stream.of(PageObjectType.values())
                .filter(pot -> pot.getValue().equals(appType))
                .findFirst()
                .orElseThrow(() -> new Exception(Errors.UNKNOWN_PAGE_OBJECT_TYPE));

        setupAppiumDriver(pageObjectType, platformName, deviceName, app, browserName, udid,
                bundleId, appActivity, appPackage);

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
                                   String deviceName, String app, String browserName, String udid,
                                   String bundleId, String appActivity, String appPackage)
            throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(PLATFORM_NAME, platformName);
        desiredCapabilities.setCapability(DEVICE_NAME, deviceName);
        desiredCapabilities.setCapability(UDID_NAME, udid);
        switch (pageObjectType) {
            case NATIVE:
                if(app.endsWith(AppParameters.APP_EXTENSION)) {
                    desiredCapabilities.setCapability(APP,
                            new File(app).getAbsolutePath());
                }
                //Android app
                desiredCapabilities.setCapability(APP_PACKAGE_NAME, appPackage);
                desiredCapabilities.setCapability(APP_ACTIVITY_NAME, appActivity);
                //iOS app
                desiredCapabilities.setCapability(BUNDLEID_NAME, bundleId);
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
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void swipeScreen(SwipeDirection dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = appiumDriver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(appiumDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

}
