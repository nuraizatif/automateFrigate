package com.sepulsa.tesisautotest.pageObject;

import java.util.HashMap;

/**
 * Created by nuraizatif on 11/13/16.
 */

public class checkoutPage {
    // ------------ STRING TO COMPARE ---------------- //

    // Menu Page URL.
    public static String url = "https://m.sepulsa.id/isi-pulsa";

    // ------------ DEFINE ELEMENT ------------------- //

    // Logo sepulsa (redirect to mainPage).
    public static String logoSepulsa = ".0.0.0.0";
    public static String logoSepulsaTag = "a";
    // Back Button (redirect to mainPage).
    public static String backButton = ".0.0.2";
    public static String backButtonTag = "button";
    // Email anonymous user.
    public static String emailAnonymousTag = "input";
    public static String emailAnonymous = ".0.3.5.1.0.$react-autowhatever-1-input";
    // Bank Transfer ID.
    public static String bankTransferTag = "a";
    public static String bankTransfer = ".0.3.6.1.0.$bank_transfer|commerce_payment_bca_bank_transfer/=1$bank_transfer|commerce_payment_bca_bank_transfer.0.1";
    // Credit Card ID.
    public static String creditCardTag = "a";
    public static String creditCard = ".0.3.6.1.0.$commerce_veritrans|commerce_payment_commerce_veritrans/=1$commerce_veritrans|commerce_payment_commerce_veritrans.0.1";
    // Email field.
    public static String CCNumberFieldId = "cc";
    public static String CCNumberFieldTag = "input";
    public static String CCNumberField = ".0.3.6.1.0.$commerce_veritrans|commerce_payment_commerce_veritrans/=1$commerce_veritrans|commerce_payment_commerce_veritrans.1.0.0.1.1.0";
    public static String CCNumberValid = "4811111111111114";
    // Select Month.
    public static String monthSelectId = "cc_month";
    public static String monthSelectTag = "select";
    public static String monthSelect = ".0.3.6.1.0.$commerce_veritrans|commerce_payment_commerce_veritrans/=1$commerce_veritrans|commerce_payment_commerce_veritrans.1.0.0.1.2.0.1";
    // Select Year.
    public static String yearSelectId = "cc_year";
    public static String yearSelectTag = "select";
    public static String yearSelect = ".0.3.6.1.0.$commerce_veritrans|commerce_payment_commerce_veritrans/=1$commerce_veritrans|commerce_payment_commerce_veritrans.1.0.0.1.2.0.2";
    // CVV Id.
    public static String CVVId = "cc_cvv";
    public static String CCVValid = "123";
    // 3Dotp Id.
    public static String triDotpId = "PaRes";
    public static String triDotpValid = "112233";
    public static String triDotpTag = "input";
    public static String triDotpClass = "id";
    // Butoon OK 3D.
    public static String okButtonTag = "button";
    public static String okButtonClass = "name";
    public static String okButtonSpesifikClass = "ok";
    // Bayar sekarang Button.
    public static String buyNowTag = "button";
    public static String buyNow = ".0.3.6.2.0";
    // iFrame id.
    public static String iframeTag = "iframe";
    public static String iframe = ".1.0.2.0";
}
