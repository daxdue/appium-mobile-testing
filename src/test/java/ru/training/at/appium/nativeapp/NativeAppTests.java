package ru.training.at.appium.nativeapp;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.appium.BaseTest;
import ru.training.at.appium.constants.DataProviders;
import ru.training.at.appium.models.TestObject;
import ru.training.at.appium.testdata.TestDataProvider;

public class NativeAppTests extends BaseTest {

    @Test(dataProvider = DataProviders.TEST_DATA, dataProviderClass = TestDataProvider.class)
    public void signinAppTest(TestObject testObject) {
        try {
            //Open account registration screen
            pageObject.getPageElement("registerButton").click();
            //Input email for new account
            pageObject.getPageElement("registerEmailInput")
                    .sendKeys(testObject.getEmail());
            //Input username for new account
            pageObject.getPageElement("registerUsernameInput")
                    .sendKeys(testObject.getLogin());
            //Input password for new account
            pageObject.getPageElement("registerPasswordInput")
                    .sendKeys(testObject.getPassword());
            //Confirm password
            pageObject.getPageElement("registerConfirmPasswordInput")
                    .sendKeys(testObject.getPasswordConfirmation());
            //Hide keyboard
            appiumDriver.hideKeyboard();
            //Register new account
            pageObject.getPageElement("registerNewAccountButton")
                    .click();
            //Input account email
            pageObject.getPageElement("loginEmailInput")
                    .sendKeys(testObject.getEmail());
            //Input account password
            pageObject.getPageElement("passwordInput")
                    .sendKeys(testObject.getPassword());
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
