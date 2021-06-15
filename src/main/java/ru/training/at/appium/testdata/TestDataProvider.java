package ru.training.at.appium.testdata;

import org.testng.annotations.DataProvider;
import ru.training.at.appium.constants.DataProviders;

public class TestDataProvider {

    @DataProvider(name = DataProviders.ACCOUNT_DATA)
    public Object[][] accountTestData() {
        return new Object[][]{{"test@test.ru", "test", "qzwxecasd123"}};
    }
}
