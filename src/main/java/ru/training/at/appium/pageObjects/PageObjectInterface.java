package ru.training.at.appium.pageObjects;

import org.openqa.selenium.WebElement;

public interface PageObjectInterface {
    WebElement getPageElement(String elementName)
            throws NoSuchFieldException, IllegalAccessException;
}
