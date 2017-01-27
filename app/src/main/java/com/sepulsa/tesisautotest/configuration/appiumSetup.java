package com.sepulsa.tesisautotest.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Created by nuraizatif on 10/26/16.
 */

public class appiumSetup {
    static WebDriver driver;

    public WebDriver setupCapabilitiesAppium()  throws Exception{

        // Create object of  DesiredCapabilities class and specify android platform
        DesiredCapabilities capabilities=DesiredCapabilities.android();

        // Set the capability to execute test in chrome browser
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, deviceSettings.webBrowser);

        // Set the capability to execute our test in Android Platform
        capabilities.setCapability(MobileCapabilityType.PLATFORM, deviceSettings.devicePlatform);

        // We need to define platform name
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, deviceSettings.deviceName);

        // Set the device name as well (you can give any name)
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceSettings.udid);

        // Set the device udid as well
        capabilities.setCapability(MobileCapabilityType.UDID, deviceSettings.udid);

        // Set the android version as well 
        capabilities.setCapability(MobileCapabilityType.VERSION, deviceSettings.platformVersion);

        // Create object of URL class and specify the appium server address
        URL url= new URL(deviceSettings.appUrl + ":" + deviceSettings.appiumPort + "/wd/hub");

        // Create object driver.
        driver = new AndroidDriver(url, capabilities);

        // Return device.
        return driver;
    }
}
