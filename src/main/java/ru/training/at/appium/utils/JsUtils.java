package ru.training.at.appium.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JsUtils {

    private static final String DOCUMENT_READY_SCRIPT = "return document.readyState";
    private static final String DOCUMENT_READY_FLAG = "complete";

    public static void waitUntilDocumentIsReady(AppiumDriver driver, int seconds) {
        new WebDriverWait(driver, seconds).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript(DOCUMENT_READY_SCRIPT)
                .equals(DOCUMENT_READY_FLAG)
        );
    }
}
