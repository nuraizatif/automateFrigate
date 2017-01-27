package com.sepulsa.tesisautotest.scenarioTest;

import com.sepulsa.tesisautotest.configuration.actionsController;
import com.sepulsa.tesisautotest.configuration.appiumSetup;
import com.sepulsa.tesisautotest.configuration.userSettings;
import com.sepulsa.tesisautotest.pageObject.mainPage;
import com.sepulsa.tesisautotest.pageObject.menuPage;
import com.sepulsa.tesisautotest.pageObject.signInPage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by nuraizatif on 10/30/16.
 */

public class scenario2 {
    // Define webdriver object variable.
    WebDriver driver;

    // Define webdriverwait object for delay in next actions.
    WebDriverWait wait;

    // Define all actions needed in this page.
    actionsController actions;

    // Define class name for screenshot folder.
    String className = this.getClass().getSimpleName();

    @Before
    public void SuccessLoginSetup() throws Exception {
        // Get appium settings.
        appiumSetup setupAppium = new appiumSetup();
        driver = setupAppium.setupCapabilitiesAppium();
    }

    @Test
    public void SuccessLogin() throws Exception {
        // Open url.
        driver.get(mainPage.url);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/1_Akses_Mobile_Web_Sepulsa", "Sukses Login di m.sepulsa.id", true);

        // Push hamburger icon.
        actions.pressButtonByAjax(driver, mainPage.hamburgerButtonTag, mainPage.hamburgerButton, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/2_Halaman_Menu_Web", "Sukses Login di m.sepulsa.id", false);

        // Push Sign In Button.
        actions.pressButtonByAjax(driver, menuPage.signInButtonTag, menuPage.signInButton, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/3_Halaman_Login", "Sukses Login di m.sepulsa.id", false);

        // Input username.
        actions.inputText(driver, signInPage.usernameFieldTag, signInPage.usernameField, userSettings.existingUserName);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/4_Memasukan_Username", "Sukses Login di m.sepulsa.id", false);

        // Input username.
        actions.inputText(driver, signInPage.passwordFieldTag, signInPage.passwordField, userSettings.existingPassword);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/5_Memasukan_Password", "Sukses Login di m.sepulsa.id", false);

        // Push hamburger icon.
        actions.pressButtonByAjax(driver, signInPage.showHiddenPasswordFieldTag, signInPage.showHiddenPasswordField, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/6_Menekan_Tombol_Lihat_Password", "Sukses Login di m.sepulsa.id", false);

        // Push Submit Button.
        actions.pressButtonByAjax(driver, signInPage.submitButtonTag, signInPage.submitButton, false);

        // Wait until element is visible.
        actions.waitElementIsVisibleByXpath(driver, mainPage.sepulsaCreditTitleTag, mainPage.sepulsaCreditTitle);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/7_Menekan_Tombol_Sign_In", "Sukses Login di m.sepulsa.id", false);

        // Scenario Success.
        Assert.assertTrue(actions.compareTextElement(driver, mainPage.sepulsaCreditTitleTag, mainPage.sepulsaCreditTitle, mainPage.sepulsaCreditTitleString));
    }

    /*

    @Test
    public void LoginFacebook() throws Exception {

    }

    @Test
    public void LoginLine() throws Exception {

    }

     */

    @After
    public void SuccessLoginTearDown() {
        // Quit driver
        driver.quit();
    }

}
