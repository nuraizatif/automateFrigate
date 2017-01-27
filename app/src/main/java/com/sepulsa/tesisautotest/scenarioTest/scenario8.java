package com.sepulsa.tesisautotest.scenarioTest;

import com.sepulsa.tesisautotest.configuration.actionsController;
import com.sepulsa.tesisautotest.configuration.appiumSetup;
import com.sepulsa.tesisautotest.configuration.paymentMethodSettings;
import com.sepulsa.tesisautotest.configuration.userSettings;
import com.sepulsa.tesisautotest.pageObject.ProductPage.pulsaPage;
import com.sepulsa.tesisautotest.pageObject.checkoutPage;
import com.sepulsa.tesisautotest.pageObject.mainPage;
import com.sepulsa.tesisautotest.pageObject.ProductPage.voucherPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;
import java.util.Random;

/**
 * Created by nuraizatif on 11/7/16.
 */

public class scenario8 {
    // Define webdriver object variable.
    WebDriver driver;

    // Define webdriverwait object for delay in next actions.
    WebDriverWait wait;

    // Define all actions needed in this page.
    actionsController actions;

    // Define class name for screenshot folder.
    String className = this.getClass().getSimpleName();

    // Define react Id voucher.
    String reactIdVoucer;

    // Define map paymentMethod.
    Map paymentMethod;

    @Before
    public void anonimousTransactionSetup() throws Exception {
        // Get appium settings.
        appiumSetup setupAppium = new appiumSetup();
        driver = setupAppium.setupCapabilitiesAppium();
    }

    @Test
    public void anonimousTransaction() throws Exception {
        // Main menu.
        driver.get(mainPage.url);

        // Get hashmap paymentmethod.
        // paymentMethod = paymentMethodSettings.getPaymentMethod();

        // Get index bank transfer.
        // System.out.println(paymentMethod.get("bank_transfer"));

        // Screenshot.
        actions.takeScreenshot(driver, className + "/1_Akses_Mobile_Web_Sepulsa", "Transaksi Dengan Bank Transfer (Anonymous) di m.sepulsa.id", true);

        // Press pulsa button.
        actions.pressButtonByAjax(driver, mainPage.isiPulsaButtonTag, mainPage.isiPulsaButton, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/2_Halaman_Isi_Pulsa", "Transaksi Dengan Bank Transfer (Anonymous) di m.sepulsa.id", false);

        // Input number to field.
        actions.inputText(driver, pulsaPage.fieldPhoneNumberTag, pulsaPage.fieldPhoneNumber, userSettings.existingPhoneNumber);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/3_Memasukan_Nomor_HP", "Transaksi Dengan Bank Transfer (Anonymous) di m.sepulsa.id", false);

        // Count how many product active in pulsa packet.
        int xpathCount = actions.countElementInElement(driver, pulsaPage.liPulsaPacketTag, pulsaPage.liPulsaPacket, pulsaPage.liPulsaPacketChildTag);

        // Get random from 1 to xpathCount.
        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = 4;

        // Press random product.
        actions.pressButtonByAjax(driver, pulsaPage.liPulsaPacketChildTag, pulsaPage.liPulsaPacketChild + randomNum, false);

        Thread.sleep(5000);

        // Wait until element visible.
        actions.waitElementIsVisibleByXpath(driver, voucherPage.cartTitlePTag, voucherPage.cartTitleP);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/4_Voucher_List", "Transaksi Dengan Bank Transfer (Anonymous) di m.sepulsa.id", false);

        // Prepare Add voucher to cart.
        reactIdVoucer = actions.getReactIdByElementAjax(driver, voucherPage.voucherDetailsTag, voucherPage.voucherTitleOne, voucherPage.voucherDetailsClassTag);

        // Try to show details of voucher.
        actions.pressButtonByAjax(driver, voucherPage.voucherDetailsTag, voucherPage.voucherTitleOne, voucherPage.voucherDetailsClassTag);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/5_Voucher_Details", "Transaksi Dengan Bank Transfer (Anonymous) di m.sepulsa.id", false);

        // Close iFrame.
        actions.pressButtonByAjax(driver, voucherPage.ambilVoucherCloseTag, voucherPage.ambilVoucherCloseValuetClass, voucherPage.ambilVoucherCloseClassTag);

        // Add to cart.
        actions.pressButtonByAjax(driver, voucherPage.buttonAddVoucherTag, reactIdVoucer.substring(0, reactIdVoucer.length() - voucherPage.buttonAddVoucherAddtional.length()) + voucherPage.buttonAddVoucherAddtional);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/6_Add_Voucher_To_Cart", "Transaksi Dengan Bank Transfer (Anonymous) di m.sepulsa.id", false);

//        // Prepare Add voucher to cart.
//        reactIdVoucer = actions.getReactIdByElementAjax(driver, voucherPage.voucherDetailsTag, voucherPage.voucherTitleThree, voucherPage.voucherDetailsClassTag);
//
//        // Try to show details of voucher.
//        actions.pressButtonByAjax(driver, voucherPage.voucherDetailsTag, voucherPage.voucherTitleThree, voucherPage.voucherDetailsClassTag);
//
//        // Screenshot.
//        actions.takeScreenshot(driver, className + "/7_voucher_details_frigate");
//
//        // Close iFrame.
//        actions.pressButtonByAjax(driver, voucherPage.ambilVoucherCloseTag, voucherPage.ambilVoucherCloseValuetClass, voucherPage.ambilVoucherCloseClassTag);
//
//        // Add to cart.
//        actions.pressButtonByAjax(driver, voucherPage.buttonAddVoucherTag, reactIdVoucer.substring(0, reactIdVoucer.length() - voucherPage.buttonAddVoucherAddtional.length()) + voucherPage.buttonAddVoucherAddtional);
//
//        // Screenshot.
//        actions.takeScreenshot(driver, className + "/8_add_voucher_to_cart_frigate");
//
//        // Try to remove voucher.
//        actions.pressButtonByAjax(driver, voucherPage.buttonRemoveVoucherTag, voucherPage.generateRemoveVoucherButton("1"));
//
//        // Screenshot.
//        actions.takeScreenshot(driver, className + "/9_remove_voucher_from_cart_frigate");
//
        // Go to payment page.
        actions.pressButtonByAjax(driver, voucherPage.buttonGotoPaymentTag, voucherPage.buttonGotoPayment, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/7_Halaman_Pembayaran", "Transaksi Dengan Bank Transfer (Anonymous) di m.sepulsa.id", false);

        // add email to order.
        actions.inputText(driver, checkoutPage.emailAnonymousTag, checkoutPage.emailAnonymous, userSettings.anonymousUserEmail);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/8_Memasukan_Alamat_Email", "Transaksi Dengan Bank Transfer (Anonymous) di m.sepulsa.id", false);

        // Choose BCA Bank Transfer.
        actions.pressButtonByAjax(driver, checkoutPage.bankTransferTag, checkoutPage.bankTransfer, true);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/9_Pilih_Bank_Transfer_Sebagai_Metode_Pembayaran", "Transaksi Dengan Bank Transfer (Anonymous) di m.sepulsa.id", false);

        // Press "Bayar Sekarang" button.
        actions.pressButtonByAjax(driver, checkoutPage.buyNowTag, checkoutPage.buyNow, false);

        Thread.sleep(15000);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/10_Halaman_Complete", "Transaksi Dengan Bank Transfer (Anonymous) di m.sepulsa.id", false);

    }

    @After
    public void anonimousTransactionTearDown()
    {
        // Quit driver
        driver.quit();
    }
}
