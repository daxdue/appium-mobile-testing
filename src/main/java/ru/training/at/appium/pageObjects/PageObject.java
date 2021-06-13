package ru.training.at.appium.pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ru.training.at.appium.enums.PageObjectType;

import java.lang.reflect.Field;

public class PageObject implements PageObjectInterface {

    private Object pageObject;

    public PageObject(PageObjectType pageObjectType, AppiumDriver appiumDriver) {

        switch (pageObjectType) {
            case WEB:
                break;
            case NATIVE:
                pageObject = new NativePageObject(appiumDriver);
                break;
        }
    }

    @Override
    public WebElement getPageElement(String elementName)
            throws NoSuchFieldException, IllegalAccessException {

        Field field = pageObject.getClass().getDeclaredField(elementName);
        field.setAccessible(true);
        return (WebElement) field.get(pageObject);
    }
}
