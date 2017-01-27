package com.sepulsa.tesisautotest.scenarioTest;

import com.sepulsa.tesisautotest.configuration.actionsController;
import com.sepulsa.tesisautotest.configuration.appiumSetup;
import com.sepulsa.tesisautotest.pageObject.StaticPage.aboutUsPage;
import com.sepulsa.tesisautotest.pageObject.StaticPage.faqPage;
import com.sepulsa.tesisautotest.pageObject.StaticPage.tncPage;
import com.sepulsa.tesisautotest.pageObject.mainPage;
import com.sepulsa.tesisautotest.pageObject.menuPage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by nuraizatif on 10/30/16.
 */

public class scenario7 {
    // Define webdriver object variable.
    WebDriver driver;

    // Define webdriverwait object for delay in next actions.
    WebDriverWait wait;

    // Define all actions needed in this page.
    actionsController actions;

    // Define class name for screenshot folder.
    String className = this.getClass().getSimpleName();

    @Before
    public void AllStaticPageSetup() throws Exception {
        // Get appium settings.
        appiumSetup setupAppium = new appiumSetup();
        driver = setupAppium.setupCapabilitiesAppium();
    }

    @Test
    public void AllStaticPage() throws Exception {
        // Open url.
        driver.get(mainPage.url);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/1_Akses_Mobile_Web_Sepulsa", "Halaman Statik m.sepulsa.id", true);

        // Press hamburger icon.
        actions.pressButtonByAjax(driver, mainPage.hamburgerButtonTag, mainPage.hamburgerButton, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/2_Halaman_Menu_Web", "Halaman Statik m.sepulsa.id", false);

        // Press About Us Button.
        actions.pressButtonByAjax(driver, menuPage.aboutUsButtonTag, menuPage.aboutUsButton, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/3_Menampilkan_Halaman_About_Us", "Halaman Statik m.sepulsa.id", false);

        // Check if the title is right.
        // Assert.assertTrue(actions.compareTextElement(driver, aboutUsPage.aboutUsTitleTag, aboutUsPage.aboutUsTitle, aboutUsPage.aboutUsTitleString));

        // Press Back Button.
        actions.pressButtonByAjax(driver, aboutUsPage.backButtonTag, aboutUsPage.backButton, true);

        // Press FAQ Button.
        actions.pressButtonByAjax(driver, menuPage.faqButtonTag, menuPage.faqButton, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/4_Menampilkan_Halaman_FAQ", "Halaman Statik m.sepulsa.id", false);

        // Press Accordion 1.
        actions.pressButtonByAjax(driver, faqPage.accordionSatuTag, faqPage.accordionSatu, false);

        // Sleep in 2 sec.
        Thread.sleep(2000);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/5_Membuka_FAQ_1", "Halaman Statik m.sepulsa.id", false);

        // Press Accordion 2.
        actions.pressButtonByAjax(driver, faqPage.accordionDuaTag, faqPage.accordionDua, false);

        // Sleep in 2 sec.
        Thread.sleep(2000);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/6_Membuka_FAQ_2", "Halaman Statik m.sepulsa.id", false);

        // Press Accordion 2.
        actions.pressButtonByAjax(driver, faqPage.accordionDuaTag, faqPage.accordionDua, false);

        // Press Accordion 3.
        actions.pressButtonByAjax(driver, faqPage.accordionTigaTag, faqPage.accordionTiga, false);

        // Sleep in 2 sec.
        Thread.sleep(2000);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/7_Membuka_FAQ_3", "Halaman Statik m.sepulsa.id", false);

        // Press Accordion 3.
        actions.pressButtonByAjax(driver, faqPage.accordionTigaTag, faqPage.accordionTiga, false);

        // Press Accordion 4.
        actions.pressButtonByAjax(driver, faqPage.accordionEmpatTag, faqPage.accordionEmpat, false);

        // Sleep in 2 sec.
        Thread.sleep(2000);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/8_Membuka_FAQ_4", "Halaman Statik m.sepulsa.id", false);

        // Press Accordion 4.
        actions.pressButtonByAjax(driver, faqPage.accordionEmpatTag, faqPage.accordionEmpat, false);

        // Press Accordion 5.
        actions.pressButtonByAjax(driver, faqPage.accordionLimaTag, faqPage.accordionLima, false);

        // Sleep in 2 sec.
        Thread.sleep(2000);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/9_Membuka_FAQ_5", "Halaman Statik m.sepulsa.id", false);

        // Press Accordion 5.
        actions.pressButtonByAjax(driver, faqPage.accordionLimaTag, faqPage.accordionLima, false);

        // Press Back Button.
        actions.pressButtonByAjax(driver, aboutUsPage.backButtonTag, aboutUsPage.backButton, true);

        // Press TNC Button.
        actions.pressButtonByAjax(driver, menuPage.tncButtonTag, menuPage.tncButton, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/10_Halaman_TNC", "Halaman Statik m.sepulsa.id", false);

        // Check if the title is right.
        Assert.assertTrue(actions.compareTextElement(driver, tncPage.tncTitleTag, tncPage.tncTitle, tncPage.tncTitleString));
    }

    @After
    public void AllStaticPageTearDown()
    {
        // Quit driver
        driver.quit();
    }
}
