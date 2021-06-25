package ru.training.at.appium.webapp;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.appium.BaseTest;
import ru.training.at.appium.constants.DataProviders;
import ru.training.at.appium.models.TestObject;
import ru.training.at.appium.utils.JsUtils;
import ru.training.at.appium.utils.TestDataLoader;

public class WebAppTests extends BaseTest {

    @Test(dataProvider = DataProviders.NATIVE_TEST_DATA, dataProviderClass = TestDataLoader.class)
    public void yandexSearchTest(TestObject testObject) throws NoSuchFieldException, IllegalAccessException {

        pageObject.getPageElement("searchInput")
                .sendKeys(testObject.getWordToSearch());
        pageObject.getPageElement("searchButton").click();
        JsUtils.waitUntilDocumentIsReady(appiumDriver, 10);
        Assert.assertTrue(pageObject.getPageElements("searchResults").size() != 0);
    }
}
