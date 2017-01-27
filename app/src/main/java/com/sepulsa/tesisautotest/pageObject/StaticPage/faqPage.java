package com.sepulsa.tesisautotest.pageObject.StaticPage;

/**
 * Created by nuraizatif on 11/4/16.
 */

public class faqPage {
    /**
     * String to compare.
     */

    // Main Page URL.
    public static String url = "https://m.sepulsa.id/faq";
    // Sepulsa FAQ page Title.
    public static String aboutUsTitleString = "PERTANYAAN YANG SERING DIAJUKAN";

    /**
     * ELEMENT.
     */

    // Back Button Page.
    public static String backButton = ".0.0.2";
    public static String backButtonTag = "button";
    // Title element.
    public static String aboutUsTitle = ".0.3.0";
    public static String aboutUsTitleTag = "h1";
    // Accordion 1. Pegisian Pulsa.
    public static String accordionSatu = ".0.3.1.$1/=1$1.0";
    public static String accordionSatuTag = "div";
    // Accordion 2. Kupon.
    public static String accordionDua = ".0.3.1.$2/=1$2.0";
    public static String accordionDuaTag = "div";
    // Accordion 3. Pembayaran.
    public static String accordionTiga = ".0.3.1.$3/=1$3.0";
    public static String accordionTigaTag = "div";
    // Accordion 4. Registrasi.
    public static String accordionEmpat = ".0.3.1.$4/=1$4.0";
    public static String accordionEmpatTag = "div";
    // Accordion 5. Umum.
    public static String accordionLima = ".0.3.1.$5/=1$5.0";
    public static String accordionLimaTag = "div";

}
