package ru.training.at.appium.pageObjects;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface PageObjectInterface {
    WebElement getPageElement(String elementName)
            throws NoSuchFieldException, IllegalAccessException;
    List<WebElement> getPageElements(String elements)
            throws NoSuchFieldException, IllegalAccessException;
}
