# Appium mobile testing homework

This repository contains homework for Mobile Testing Unit of EPAM Test Auto Lab

## How to run

Each homework located in their own branch:
* ***appium_base*** - branch for the first appium homework
* ***appium_cloud*** - branch for the second appium homework

**To run homework appium_base:**
* Clone the repository to your local file system by executing ***git clone*** command:
    ```
    git clone https://github.com/daxdue/appium-mobile-testing
    ```
* Run Appium on your local machine. If you haven't Appium, please install it.
* Open the project in IntelliJIDEA
* Checkout to *appium_base branch*
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
  
**To to run homework appium_cloud:**
* If you already cloned the repository, checkout to *appium_cloud branch*.
* Choose required device in EPAM Mobile Cloud web-service and place his identifier to **deviceName** (if use Android) 
  or **udid** (if use iOS) in the required suite .xml file. 
* Open ***Terminal / Command line*** and locate to project directory.
* Copy your EPAM Mobile Cloud token
* To run ***Android Web*** test execute command:
  ```
  mvn clean test -P cloudWebAndroid -Dtoken=$yourApiToken
  ```
* To run ***iOS Web*** test execute command:
  ```
  mvn clean test -P cloudWebIos -Dtoken=$yourApiToken
  ```
* To run ***Android Native*** test execute:
  ```
  mvn clean test -P cloudNativeAndroid -Dtoken=$yourApiToken
  ```
* To run ***iOS Native*** test execute:
  ```
  mvn clean test -P cloudNativeIos -Dtoken=$yourApiToken
  ```

