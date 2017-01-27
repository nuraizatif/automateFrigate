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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by nuraizatif on 1/15/17.
 */

public class scenario4 {
    // Define webdriver object variable.
    WebDriver driver;

    // Define webdriverwait object for delay in next actions.
    WebDriverWait wait;

    // Define all actions needed in this page.
    actionsController actions;

    // Define class name for screenshot folder.
    String className = this.getClass().getSimpleName();

    @Before
    public void InvalidEmailPatternSetup() throws Exception {
        // Get appium settings.
        appiumSetup setupAppium = new appiumSetup();
        driver = setupAppium.setupCapabilitiesAppium();
    }

    @Test
    public void InvalidEmailPattern() throws Exception {
        // Open url.
        driver.get(mainPage.url);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/1_Akses_Mobile_Web_Sepulsa", "Gagal Login di m.sepulsa.id Karena Salah Pola Email", true);

        // Push hamburger icon.
        actions.pressButtonByAjax(driver, mainPage.hamburgerButtonTag, mainPage.hamburgerButton, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/2_Halaman_Menu_Web", "Gagal Login di m.sepulsa.id Karena Salah Pola Email", false);

        // Push Sign In Button.
        actions.pressButtonByAjax(driver, menuPage.signInButtonTag, menuPage.signInButton, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/3_Halaman_Login", "Gagal Login di m.sepulsa.id Karena Salah Pola Email", false);

        // Input username.
        actions.inputText(driver, signInPage.usernameFieldTag, signInPage.usernameField, userSettings.invalidEmailPatternName);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/4_Memasukan_Email_Dengan_Pola_Salah", "Gagal Login di m.sepulsa.id Karena Salah Pola Email", true);

        // Input username.
        actions.inputText(driver, signInPage.passwordFieldTag, signInPage.passwordField, userSettings.invalidEmailPatternPassword);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/5_Memasukan_Password", "Gagal Login di m.sepulsa.id Karena Salah Pola Email", false);

        // Push hamburger icon.
        actions.pressButtonByAjax(driver, signInPage.showHiddenPasswordFieldTag, signInPage.showHiddenPasswordField, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/6_Tampilkan_Password", "Gagal Login di m.sepulsa.id Karena Salah Pola Email", false);

        // Push Submit Button.
        actions.pressButtonByAjax(driver, signInPage.submitButtonTag, signInPage.submitButton, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/7_Tampilan_Setelah_Gagal_Login", "Gagal Login di m.sepulsa.id Karena Salah Pola Email", false);

        // Check msg.
        Assert.assertTrue(actions.compareTextElement(driver, signInPage.alertBarTag, signInPage.alertBar, signInPage.invalidEmailPattern));
    }

    @After
    public void InvalidEmailPatternTearDown() {
        // Quit driver
        driver.quit();
    }
}
