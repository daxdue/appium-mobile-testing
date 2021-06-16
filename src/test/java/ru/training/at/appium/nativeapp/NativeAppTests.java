package ru.training.at.appium.nativeapp;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.appium.BaseTest;
import ru.training.at.appium.constants.DataProviders;
import ru.training.at.appium.enums.SwipeDirection;
import ru.training.at.appium.testdata.TestDataProvider;

public class NativeAppTests extends BaseTest {

    @Test(dataProvider = DataProviders.NATIVE_TEST_DATA, dataProviderClass = TestDataProvider.class)
    public void signinAppTest(String testEmail, String testLogin,
                              String testPassword, String requiredActivityName) {
        try {
            //Open account registration screen
            pageObject.getPageElement("registerButton").click();
            //Input email for new account
            pageObject.getPageElement("registerEmailInput").click();
            pageObject.getPageElement("registerEmailInput")
                    .sendKeys(testEmail);
            //Input username for new account
            pageObject.getPageElement("registerUsernameInput").click();
            pageObject.getPageElement("registerUsernameInput")
                    .sendKeys(testLogin);
            //Input password for new account
            pageObject.getPageElement("registerPasswordInput").click();
            pageObject.getPageElement("registerPasswordInput")
                    .sendKeys(testPassword);
            //Confirm password
            pageObject.getPageElement("registerConfirmPasswordInput").click();
            pageObject.getPageElement("registerConfirmPasswordInput")
                    .sendKeys(testPassword);
            //Hide keyboard
            //appiumDriver.hideKeyboard();
            swipeScreen(SwipeDirection.DOWN);
            //Register new account
            pageObject.getPageElement("registerNewAccountButton")
                    .click();
            //Input account email
            pageObject.getPageElement("loginEmailInput")
                    .sendKeys(testEmail);
            //Input account password
            pageObject.getPageElement("passwordInput")
                    .sendKeys(testPassword);
            //Perform login
            pageObject.getPageElement("signInButton")
                    .click();
            String activityName = pageObject.getPageElement("activityName").getText();
            //Check current screen name
            Assert.assertTrue(activityName.contains(requiredActivityName));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
