package com.sepulsa.tesisautotest.scenarioTest;

import com.sepulsa.tesisautotest.configuration.actionsController;
import com.sepulsa.tesisautotest.configuration.appiumSetup;
import com.sepulsa.tesisautotest.configuration.userSettings;
import com.sepulsa.tesisautotest.pageObject.mainPage;
import com.sepulsa.tesisautotest.pageObject.menuPage;
import com.sepulsa.tesisautotest.pageObject.signInPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by nuraizatif on 1/15/17.
 */

public class scenario6 {
    // Define webdriver object variable.
    WebDriver driver;

    // Define webdriverwait object for delay in next actions.
    WebDriverWait wait;

    // Define all actions needed in this page.
    actionsController actions;

    // Define class name for screenshot folder.
    String className = this.getClass().getSimpleName();

    @Before
    public void LoginGoogleSetup() throws Exception {
        // Get appium settings.
        appiumSetup setupAppium = new appiumSetup();
        driver = setupAppium.setupCapabilitiesAppium();
    }

    @Test
    public void LoginGoogle() throws Exception {
        // Open url.
        driver.get(mainPage.url);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/1_Akses_Mobile_Web_Sepulsa", "Login di m.sepulsa.id Dengan Menggunakan G+", true);

        // Push hamburger icon.
        actions.pressButtonByAjax(driver, mainPage.hamburgerButtonTag, mainPage.hamburgerButton, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/2_Halaman_Menu_Web", "Login di m.sepulsa.id Dengan Menggunakan G+", false);

        // Push Sign In Button.
        actions.pressButtonByAjax(driver, menuPage.signInButtonTag, menuPage.signInButton, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/3_Halaman_Login", "Login di m.sepulsa.id Dengan Menggunakan G+", false);

        // Push Sign In Button.
        actions.pressButtonByAjax(driver, signInPage.loginGoogleButtonTag, signInPage.loginGoogleButton, false);

        // Wait until Email Field element is visible.
        actions.waitElementIsVisibleByid(driver, signInPage.googleEmailFieldId);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/4_Halaman_Login_G+", "Login di m.sepulsa.id Dengan Menggunakan G+", false);

        // Input email to email field.
        actions.inputTextById(driver, signInPage.googleEmailFieldId, userSettings.validGoogleEmail);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/5_Memasukan_Email_Google_Valid", "Login di m.sepulsa.id Dengan Menggunakan G+", false);

        // Press next button.
        actions.pressButtonById(driver, signInPage.googleNextButtonId);

        // Wait until Password Fiel element is visible.
        actions.waitElementIsVisibleByid(driver, signInPage.googlePasswordFieldId);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/6_Menekan_Tombol_Next", "Login di m.sepulsa.id Dengan Menggunakan G+", false);

        // Input Passwor google.
        actions.inputTextById(driver, signInPage.googlePasswordFieldId, userSettings.validGooglePassword);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/7_Memasukan_Password_Gmail_Valid", "Login di m.sepulsa.id Dengan Menggunakan G+", false);

        // Press sign in button
        actions.pressButtonById(driver, signInPage.googleSignInButtonId);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/8_Menekan_Tombol_Login", "Login di m.sepulsa.id Dengan Menggunakan G+", false);

        // TODO : check if its a first login ! need to press allow button.
    }

    @After
    public void LoginGoogleTearDown() {
        // Quit driver
        driver.quit();
    }
}
