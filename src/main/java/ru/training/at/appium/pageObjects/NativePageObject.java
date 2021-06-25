package ru.training.at.appium.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject extends PageObject {

    private static final String BASE_PACKAGE = "platkovsky.alexey.epamtestapp";

    @AndroidFindBy(id = BASE_PACKAGE + ":id/login_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    WebElement loginEmailInput;

    @AndroidFindBy(id = BASE_PACKAGE + ":id/login_pwd")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    WebElement passwordInput;

    @AndroidFindBy(id = BASE_PACKAGE + ":id/email_sign_in_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Sign In']")
    WebElement signInButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BudgetActivity']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Budget']")
    WebElement activityName;

    @AndroidFindBy(id = BASE_PACKAGE + ":id/register_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Register new account']")
    WebElement registerButton;

    @AndroidFindBy(id = BASE_PACKAGE + ":id/registration_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    WebElement registerEmailInput;

    @AndroidFindBy(id = BASE_PACKAGE + ":id/registration_username")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    WebElement registerUsernameInput;

    @AndroidFindBy(id = BASE_PACKAGE + ":id/registration_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    WebElement registerPasswordInput;

    @AndroidFindBy(id = BASE_PACKAGE + ":id/registration_confirm_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
    WebElement registerConfirmPasswordInput;

    @AndroidFindBy(id = BASE_PACKAGE + ":id/register_new_account_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Register new account']")
    WebElement registerNewAccountButton;

    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

}
