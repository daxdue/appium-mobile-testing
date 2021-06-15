package ru.training.at.appium.pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.appium.utils.JsUtils;

import java.util.List;

public class WebPageObject extends PageObject {

    private static final String YANDEX_URL = "https://yandex.ru";

    @FindBy(css = "input.mini-suggest__input")
    WebElement searchInput;

    @FindBy(css = "button.mini-suggest__button")
    WebElement searchButton;

    @FindBy(css = "div.serp-item.serp-list__card")
    List<WebElement> searchResults;

    private AppiumDriver appiumDriver;

    public WebPageObject(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
        appiumDriver.get(YANDEX_URL);
        JsUtils.waitUntilDocumentIsReady(appiumDriver, 10);
    }
}
