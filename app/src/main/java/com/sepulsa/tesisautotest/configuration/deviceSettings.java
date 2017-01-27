package com.sepulsa.tesisautotest.configuration;

import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.Platform;

/**
 * Created by nuraizatif on 10/26/16.
 */

public class deviceSettings {
    // Android OS version of your device.
    public static String platformVersion = "6.0";
    // Serial number deivce.
    public static String udid = "872c0992";
    // Define browser type.
    public static String webBrowser = BrowserType.CHROME;
    // Define platform.
    public static Platform devicePlatform = Platform.ANDROID;
    // Define platform name.
    public static String deviceName = "Android";
    // Appium port.
    public static int appiumPort = 4723;
    // Appium running url (user 127.0.0.1 if you use localhost).
    public static String appUrl = "http://127.0.0.1";
}
