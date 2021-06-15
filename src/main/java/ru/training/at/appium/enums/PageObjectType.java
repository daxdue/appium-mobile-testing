package ru.training.at.appium.enums;

public enum PageObjectType {
    NATIVE("native"),
    WEB("web");

    private String value;

    PageObjectType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
