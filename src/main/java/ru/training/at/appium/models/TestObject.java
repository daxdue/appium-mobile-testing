package ru.training.at.appium.models;

import lombok.Data;

@Data
public class TestObject {
    private String email;
    private String login;
    private String password;
    private String passwordConfirmation;
    private String activityName;
    private String wordToSearch;
}