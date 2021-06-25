package ru.training.at.appium.testdata;

import org.testng.annotations.DataProvider;
import ru.training.at.appium.constants.DataProviders;
import ru.training.at.appium.models.TestObject;
import ru.training.at.appium.utils.TestDataLoader;

import java.util.List;

public class TestDataProvider {

    @DataProvider(name = DataProviders.NATIVE_TEST_DATA)
    public Object[][] accountTestData() {
        List<TestObject> testObjectList = TestDataLoader.load();
        return testObjectList.stream()
                .map(data -> new TestObject[]{data})
                .toArray(Object[][]::new);
    }
}
