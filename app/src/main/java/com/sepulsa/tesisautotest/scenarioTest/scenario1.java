package com.sepulsa.tesisautotest.scenarioTest;

import com.sepulsa.tesisautotest.configuration.appiumSetup;
import com.sepulsa.tesisautotest.configuration.actionsController;
import com.sepulsa.tesisautotest.pageObject.mainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nuraizatif on 10/26/16.
 */

public class scenario1 {
    // Define webdriver object variable.
    WebDriver driver;

    // Define webdriverwait object for delay in next actions.
    WebDriverWait wait;

    // Define all actions needed in this page.
    actionsController actions;

    // Define class name for screenshot folder.
    String className = this.getClass().getSimpleName();

    @Before
    public void RedirectToSepulsaSetup() throws Exception {
        // Get appium settings.
        appiumSetup setupAppium = new appiumSetup();
        driver = setupAppium.setupCapabilitiesAppium();
    }

    @Test
    public void RedirectToSepulsa() throws Exception
    {
        // Open url.
        driver.get(mainPage.url);

        // Define wait variable.
        wait = new WebDriverWait(driver, 2);

        // Logging.
        System.out.println("document status : " + ((JavascriptExecutor)driver).executeScript("return document.readyState").toString());
        System.out.println("page title : " + driver.getTitle().toString());
        // Wait until page loaded completely.
        wait.until(ExpectedConditions.titleIs("Sepulsa Mobile Web"));

        // Screenshot.
        actions.takeScreenshot(driver, className + "/1_Akses_Mobile_Web_Sepulsa", "Membuka m.sepulsa.id di mobile browser", true);

        // Page is already open.
        Assert.assertTrue(driver.getTitle().toString().equalsIgnoreCase("Sepulsa Mobile Web"));
    }

    @After
    public void RedirectToSepulsaTearDown()
    {
        // Define wait variable.
        wait = new WebDriverWait(driver, 2);

        // Quit driver
        driver.quit();
    }
}
