# Appium mobile testing homework

This repository contains homework for Mobile Testing Unit of EPAM Test Auto Lab

## How to run

Each homework located in their own branch:
* ***appium_base*** - branch for the first appium homework
* ***appium_cloud*** - branch for the second appium homework

###To run homework appium_base:
* Clone the repository to your local file system by executing ***git clone*** command:
    ```
    git clone https://github.com/daxdue/appium-mobile-testing
    ```
* Run Appium on your local machine. If you haven't Appium, please install it.
* Open the project in IntelliJIDEA
* Open ***test/java/resources/nativeAppTestSuite.xml*** and change value for property ***deviceName*** to your target device
* Open ***Terminal / Command line*** and locate to project directory
* To run ***Web*** test execute command:
    ```
    mvn clean test -P web
    ```
* To run ***Native*** test execute command:
    ```
    mvn clean test -P native
    ```
