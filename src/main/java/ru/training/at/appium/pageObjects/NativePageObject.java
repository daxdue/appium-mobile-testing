package ru.training.at.appium.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NativePageObject extends PageObject {

    private static final String BASE_PACKAGE = "platkovsky.alexey.epamtestapp";

    @AndroidFindBy(id = BASE_PACKAGE + ":id/login_email")
    WebElement loginEmailInput;

    @AndroidFindBy(id = BASE_PACKAGE + ":id/login_pwd")
    WebElement passwordInput;

    @AndroidFindBy(id = BASE_PACKAGE + ":id/email_sign_in_button")
    WebElement signInButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BudgetActivity']")
    WebElement activityName;

    @AndroidFindBy(id = BASE_PACKAGE + ":id/register_button")
    WebElement registerButton;

    @AndroidFindBy(id = BASE_PACKAGE + ":id/registration_email")
    WebElement registerEmailInput;

    @AndroidFindBy(id = BASE_PACKAGE + ":id/registration_username")
    WebElement registerUsernameInput;

    @AndroidFindBy(id = BASE_PACKAGE + ":id/registration_password")
    WebElement registerPasswordInput;

    @AndroidFindBy(id = BASE_PACKAGE + ":id/registration_confirm_password")
    WebElement registerConfirmPasswordInput;

    @AndroidFindBy(id = BASE_PACKAGE + ":id/register_new_account_button")
    WebElement registerNewAccountButton;

    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

}
