package com.sepulsa.tesisautotest.scenarioTest;

import com.sepulsa.tesisautotest.configuration.actionsController;
import com.sepulsa.tesisautotest.configuration.appiumSetup;
import com.sepulsa.tesisautotest.configuration.userSettings;
import com.sepulsa.tesisautotest.pageObject.ProductPage.pulsaPage;
import com.sepulsa.tesisautotest.pageObject.ProductPage.voucherPage;
import com.sepulsa.tesisautotest.pageObject.checkoutPage;
import com.sepulsa.tesisautotest.pageObject.mainPage;
import com.sepulsa.tesisautotest.pageObject.signInPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;
import java.util.Random;

/**
 * Created by nuraizatif on 1/15/17.
 */

public class scenario9 {
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
    public void anonimousTransactionCCSetup() throws Exception {
        // Get appium settings.
        appiumSetup setupAppium = new appiumSetup();
        driver = setupAppium.setupCapabilitiesAppium();
    }

    @Test
    public void anonimousTransactionCC() throws Exception {
        // Main menu.
        driver.get(mainPage.url);

        // Get hashmap paymentmethod.
        // paymentMethod = paymentMethodSettings.getPaymentMethod();

        // Get index bank transfer.
        // System.out.println(paymentMethod.get("bank_transfer"));

        // Screenshot.
        actions.takeScreenshot(driver, className + "/1_Akses_Mobile_Web_Sepulsa", "Transaksi Dengan Kartu Kredit (Anonymous) di m.sepulsa.id", true);

        // Press pulsa button.
        actions.pressButtonByAjax(driver, mainPage.isiPulsaButtonTag, mainPage.isiPulsaButton, false);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/2_Halaman_Isi_Pulsa", "Transaksi Dengan Kartu Kredit (Anonymous) di m.sepulsa.id", false);

        // Input number to field.
        actions.inputText(driver, pulsaPage.fieldPhoneNumberTag, pulsaPage.fieldPhoneNumber, userSettings.existingPhoneNumber);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/3_Memasukan_Nomor_HP", "Transaksi Dengan Kartu Kredit (Anonymous) di m.sepulsa.id", false);

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
        actions.takeScreenshot(driver, className + "/4_Voucher_List", "Transaksi Dengan Kartu Kredit (Anonymous) di m.sepulsa.id", false);

        // Prepare Add voucher to cart.
        reactIdVoucer = actions.getReactIdByElementAjax(driver, voucherPage.voucherDetailsTag, voucherPage.voucherTitleOne, voucherPage.voucherDetailsClassTag);

        // Try to show details of voucher.
        actions.pressButtonByAjax(driver, voucherPage.voucherDetailsTag, voucherPage.voucherTitleOne, voucherPage.voucherDetailsClassTag);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/5_Voucher_Details", "Transaksi Dengan Kartu Kredit (Anonymous) di m.sepulsa.id", false);

        // Close iFrame.
        actions.pressButtonByAjax(driver, voucherPage.ambilVoucherCloseTag, voucherPage.ambilVoucherCloseValuetClass, voucherPage.ambilVoucherCloseClassTag);

        // Add to cart.
        actions.pressButtonByAjax(driver, voucherPage.buttonAddVoucherTag, reactIdVoucer.substring(0, reactIdVoucer.length() - voucherPage.buttonAddVoucherAddtional.length()) + voucherPage.buttonAddVoucherAddtional);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/6_Add_Voucher_To_Cart", "Transaksi Dengan Kartu Kredit (Anonymous) di m.sepulsa.id", false);

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
        actions.takeScreenshot(driver, className + "/7_Halaman_Pembayaran", "Transaksi Dengan Kartu Kredit (Anonymous) di m.sepulsa.id", false);

        // add email to order.
        actions.inputText(driver, checkoutPage.emailAnonymousTag, checkoutPage.emailAnonymous, userSettings.anonymousUserEmail);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/8_Memasukan_Alamat_Email", "Transaksi Dengan Kartu Kredit (Anonymous) di m.sepulsa.id", false);

        // Choose Creadit Card.
        actions.pressButtonByAjax(driver, checkoutPage.creditCardTag, checkoutPage.creditCard, true);

        // Wait until Email Field element is visible.
        actions.waitElementIsVisibleByid(driver, checkoutPage.CCNumberFieldId);

        // Input Valid CC number.
        actions.inputTextById(driver, checkoutPage.CCNumberFieldId, checkoutPage.CCNumberValid);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll("+ 0 +", "+ 500 +");");

        // Screenshot.
        actions.takeScreenshot(driver, className + "/9_Memasukan_Nomor_CC_Valid", "Transaksi Dengan Kartu Kredit (Anonymous) di m.sepulsa.id", false);

        // Select Month.
        actions.selectFromDropdownById(driver, checkoutPage.monthSelectId, "Jan");

        // Screenshot.
        actions.takeScreenshot(driver, className + "/10_Pilih_Bulan_CC", "Transaksi Dengan Kartu Kredit (Anonymous) di m.sepulsa.id", false);

        // Select Month.
        actions.selectFromDropdownById(driver, checkoutPage.yearSelectId, "2020");

        // Screenshot.
        actions.takeScreenshot(driver, className + "/11_Pilih_Tahun_CC", "Transaksi Dengan Kartu Kredit (Anonymous) di m.sepulsa.id", false);

        // Input Valid CCV number.
        actions.inputTextById(driver, checkoutPage.CVVId, checkoutPage.CCVValid);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/12_Memasukan_Valid_CVV", "Transaksi Dengan Kartu Kredit (Anonymous) di m.sepulsa.id", false);

        // Press "Bayar Sekarang" button.
        actions.pressButtonByAjax(driver, checkoutPage.buyNowTag, checkoutPage.buyNow, false);

        Thread.sleep(10000);

        driver.switchTo().frame(driver.findElement(By.xpath("//" + checkoutPage.iframeTag + "[@data-reactid=\"" + checkoutPage.iframe + "\"]")));

        // Input Valid Otp number.
        actions.inputTextById(driver, checkoutPage.triDotpId, checkoutPage.triDotpValid);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/13_Memasukan_Otp_Valid", "Transaksi Dengan Kartu Kredit (Anonymous) di m.sepulsa.id", false);

        js.executeScript("scroll("+ 0 +", "+ 10000 +");");

        // Press ok button 3D.
        actions.pressButtonByName(driver, checkoutPage.okButtonSpesifikClass);
//        actions.pressButtonByAjax(driver, checkoutPage.okButtonTag, checkoutPage.okButtonSpesifikClass, checkoutPage.okButtonClass);

        // Screenshot.
        actions.takeScreenshot(driver, className + "/15_Setelah_Menekan_Tombol_OK", "Transaksi Dengan Kartu Kredit (Anonymous) di m.sepulsa.id", false);

//        // Screenshot.
//        actions.takeScreenshot(driver, className + "/13_Halaman_3D", "Transaksi Dengan Kartu Kredit (Anonymous) di m.sepulsa.id", false);
//
//        // Input Valid CCV number.
//        actions.inputTextById(driver, checkoutPage.triDotpId, checkoutPage.triDotpValid);
//
//        // Screenshot.
//        actions.takeScreenshot(driver, className + "/14_Memasukan_Valid_OTP", "Transaksi Dengan Kartu Kredit (Anonymous) di m.sepulsa.id", false);


    }

    @After
    public void anonimousTransactionCCTearDown()
    {
        // Quit driver
        driver.quit();
    }
}
