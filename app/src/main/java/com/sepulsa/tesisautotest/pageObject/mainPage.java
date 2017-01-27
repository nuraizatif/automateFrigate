package com.sepulsa.tesisautotest.pageObject;

/**
 * Created by nuraizatif on 10/28/16.
 */

/**
 * TODO :
 * 1. List all react id on this page.
 * 2. Define to check banner automatically.
 */

public class mainPage {
    /**
     * String to compare.
     */

    // Main Page URL.
    public static String url = "https://m.sepulsa.id";

    // Sepulsa Credit Title.
    public static String sepulsaCreditTitleString = "Sepulsa Kredit";

    /**
     * ELEMENT.
     */

    // Logo sepulsa (redirect to mainPage).
    public static String logoSepulsa = ".0.0.0.0";
    public static String logoSepulsaTag = "a";
    // Hamburger button (redirect to menuPage).
    public static String hamburgerButton = ".0.0.1";
    public static String hamburgerButtonTag = "a";
    // Title promo after header.
    public static String titlePromo = ".0.3.2.0.0.0";
    public static String titlePromoTag = "div";
    // Isi pulsa button.
    public static String isiPulsaButton = ".0.3.2.1.$0.0.0";
    public static String isiPulsaButtonTag = "div";
    // Beli Token Listrik button.
    public static String tokenListrikButton = ".0.3.2.1.$1.0.0";
    public static String tokenListrikButtonTag = "div";
    // Bayar BPJS Kesehatan button.
    public static String bpjsButton = ".0.3.2.1.$2.0.0";
    public static String bpjsButtonTag = "div";
    // Bayar Bayar Cicilan (Multifinance) button.
    public static String multifinanceButton = ".0.3.2.1.$3.0.0";
    public static String multifinanceButtonTag = "div";
    // Try to get apps.
    public static String androidApp = ".0.4.0.1.0";
    public static String androidAppTag = "a";
    // Sepulsa credit info title.
    public static String sepulsaCreditTitle = ".0.1.0.0.0.0";
    public static String sepulsaCreditTitleTag = "p";
}
