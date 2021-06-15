package ru.training.at.appium.pageObjects;

import org.openqa.selenium.WebElement;
import java.lang.reflect.Field;
import java.util.List;

public class PageObject implements PageObjectInterface {

    @Override
    public WebElement getPageElement(String elementName)
            throws NoSuchFieldException, IllegalAccessException {

        Field field = this.getClass().getDeclaredField(elementName);
        field.setAccessible(true);
        return (WebElement) field.get(this);
    }

    public List<WebElement> getPageElements(String elementsName)
            throws NoSuchFieldException, IllegalAccessException {
        Field field = this.getClass().getDeclaredField(elementsName);
        field.setAccessible(true);
        return (List<WebElement>) field.get(this);
    }
}
