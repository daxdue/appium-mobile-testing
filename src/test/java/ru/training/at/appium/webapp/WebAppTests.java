package ru.training.at.appium.webapp;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.appium.BaseTest;
import ru.training.at.appium.utils.JsUtils;

public class WebAppTests extends BaseTest {

    @Test
    public void yandexSearchTest() throws NoSuchFieldException, IllegalAccessException {

        pageObject.getPageElement("searchInput")
                .sendKeys("EPAM");
        pageObject.getPageElement("searchButton").click();
        JsUtils.waitUntilDocumentIsReady(appiumDriver, 10);
        Assert.assertTrue(pageObject.getPageElements("searchResults").size() != 0);
    }
}
