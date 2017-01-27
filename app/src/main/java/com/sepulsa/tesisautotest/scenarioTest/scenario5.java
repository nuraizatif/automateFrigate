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

public class scenario5 {
    // Define webdriver object variable.
    WebDriver driver;

    // Define webdriverwait object for delay in next actions.
    WebDriverWait wait;

    // Define all actions needed in this page.
    actionsController actions;

    // Define class name for screenshot folder.
    String className = this.getClass().getSimpleName();

    @Before
    public void InvalidPasswordRequirementSetup() throws Exception {
        // Get appium settings.
        appiumSetup setupAppium = new appiumSetup();
        driver = setupAppium.setupCapabilitiesAppium();
    }

    @Test
    public void InvalidPasswordRequirement() throws Exception {
        // Open url.
        driver.get(mainPage.url);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/1_Akses_Mobile_Web_Sepulsa", "Gagal Login di m.sepulsa.id Password Kurang Dari 6", true);

        // Push hamburger icon.
        actions.pressButtonByAjax(driver, mainPage.hamburgerButtonTag, mainPage.hamburgerButton, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/2_Halaman_Menu_Web", "Gagal Login di m.sepulsa.id Password Kurang Dari 6", false);

        // Push Sign In Button.
        actions.pressButtonByAjax(driver, menuPage.signInButtonTag, menuPage.signInButton, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/3_Halaman_Login", "Gagal Login di m.sepulsa.id Password Kurang Dari 6", false);

        // Input username.
        actions.inputText(driver, signInPage.usernameFieldTag, signInPage.usernameField, userSettings.invalidPasswordPatternName);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/4_Memasukan_Username", "Gagal Login di m.sepulsa.id Password Kurang Dari 6", false);

        // Input username.
        actions.inputText(driver, signInPage.passwordFieldTag, signInPage.passwordField, userSettings.invalidPasswordPatternPassword);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/5_Memasukan_Password_Kurang_Dari_6", "Gagal Login di m.sepulsa.id Password Kurang Dari 6", false);

        // Push hamburger icon.
        actions.pressButtonByAjax(driver, signInPage.showHiddenPasswordFieldTag, signInPage.showHiddenPasswordField, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/6_Tampilkan_Password", "Gagal Login di m.sepulsa.id Password Kurang Dari 6", false);

        // Push Submit Button.
        actions.pressButtonByAjax(driver, signInPage.submitButtonTag, signInPage.submitButton, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/7_Tampilan_Setelah_Gagal_Login", "Gagal Login di m.sepulsa.id Password Kurang Dari 6", false);

        // Check msg.
        Assert.assertTrue(actions.compareTextElement(driver, signInPage.alertBarTag, signInPage.alertBar, signInPage.invalidPasswordPattern));
    }

    @After
    public void InvalidPasswordRequirementTearDown() {
        // Quit driver
        driver.quit();
    }
}
