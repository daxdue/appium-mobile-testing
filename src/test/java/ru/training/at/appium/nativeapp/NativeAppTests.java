package ru.training.at.appium.nativeapp;

import org.testng.annotations.Test;
import ru.training.at.appium.BaseTest;

public class NativeAppTests extends BaseTest {

    @Test
    public void fillEmailFieldTest() {
        try {
            pageObject.getPageElement("passwordInput")
                    .sendKeys("dax due");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
