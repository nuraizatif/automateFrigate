package com.sepulsa.tesisautotest.pageObject.ProductPage;

/**
 * Created by nuraizatif on 11/7/16.
 */

public class pulsaPage {
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
    // Field phone number.
    public static String fieldPhoneNumber = ".0.3.0.3.0.1.0.$react-autowhatever-1-input";
    public static String fieldPhoneNumberTag = "input";
    // list pulsa packet.
    public static String liPulsaPacket = ".0.3.0.3.2";
    public static String liPulsaPacketTag = "li";
    public static String liPulsaPacketChild = ".0.3.0.3.2.$";
    public static String liPulsaPacketChildTag = "button";

}
