package ru.training.at.appium.nativeapp;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.appium.BaseTest;
import ru.training.at.appium.constants.DataProviders;
import ru.training.at.appium.testdata.TestDataProvider;

public class NativeAppTests extends BaseTest {

    @Test(dataProvider = DataProviders.ACCOUNT_DATA, dataProviderClass = TestDataProvider.class)
    public void signinAppTest(String testEmail, String testLogin, String testPassword) {
        try {
            //Open account registration screen
            pageObject.getPageElement("registerButton").click();
            //Input email for new account
            pageObject.getPageElement("registerEmailInput")
                    .sendKeys(testEmail);
            //Input username for new account
            pageObject.getPageElement("registerUsernameInput")
                    .sendKeys(testLogin);
            //Input password for new account
            pageObject.getPageElement("registerPasswordInput")
                    .sendKeys(testPassword);
            //Confirm password
            pageObject.getPageElement("registerConfirmPasswordInput")
                    .sendKeys(testPassword);
            //Hide keyboard
            appiumDriver.hideKeyboard();
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
            Assert.assertEquals(activityName, "BudgetActivity");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
