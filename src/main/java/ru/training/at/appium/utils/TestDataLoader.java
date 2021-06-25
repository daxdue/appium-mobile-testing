package ru.training.at.appium.utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import ru.training.at.appium.models.TestObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class TestDataLoader {

    private static final String TEST_DATA_JSON_PATH = "src/main/resources/testData.json";

    public static List<TestObject> load() {
        List<TestObject> testObjectList = null;
        try (InputStream inputStream = new FileInputStream(TEST_DATA_JSON_PATH)) {
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
            Type itemsType = new TypeToken<List<TestObject>>() {}.getType();
            testObjectList = new Gson().fromJson(jsonReader, itemsType);
            System.out.println("Amount of items: " + testObjectList.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return testObjectList;
    }
}