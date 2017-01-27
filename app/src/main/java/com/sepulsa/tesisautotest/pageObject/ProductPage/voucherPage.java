package com.sepulsa.tesisautotest.pageObject.ProductPage;

/**
 * Created by nuraizatif on 11/10/16.
 */

public class voucherPage {
    // ------------ STRING TO COMPARE ---------------- //

    // Menu Page URL.
    public static String url = "https://m.sepulsa.id/isi-pulsa";

    // Cart Title.
    public static String cartTitle = "CART";

    // ------------ DEFINE ELEMENT ------------------- //

    // Logo sepulsa (redirect to mainPage).
    public static String logoSepulsa = ".0.0.0.0";
    public static String logoSepulsaTag = "a";
    // Back Button (redirect to mainPage).
    public static String backButton = ".0.0.2";
    public static String backButtonTag = "button";
    // Title Cart.
    public static String cartTitleP = ".0.3.1.2.1";
    public static String cartTitlePTag = "p";
    // Voucher Button.
    public static String voucherDetailsTag = "img";
    public static String voucherDetailsClassTag = "alt";
    public static String voucherTitleOne = "Voucher Diskon 50% di Uber";
    public static String voucherTitleTwo = "Diskon 50 ribu di Uber";
    public static String voucherTitleThree = "TVOFU Voucher SOMAT Blitz ";
    // iFrame voucher details.
    public static String ambilVoucherCloseTag = "a";
    public static String ambilVoucherCloseClassTag = "class";
    public static String ambilVoucherCloseValuetClass = "ui-icon-delete ui-btn-icon-notext ui-btn-right close-popup";
    // Button add voucher.
    public static String buttonAddVoucherTag = "button";
    public static String buttonAddVoucherAddtional = "1.0";
    // Main cart content.
    public static String cartContentId = ".0.3.1.2.2";
    public static String suffixCartContentId = ".0";
    // Button remove voucher.
    public static String buttonRemoveVoucherTag = "button";
    // BUtton go to payment page.
    public static String buttonGotoPaymentTag = "button";
    public static String buttonGotoPayment = ".0.3.2.0";

    /**
     * Function to generate remove voucher.
     *
     * @param orderVoucher
     *  Order voucher.
     *
     * @return
     */
    public static String generateRemoveVoucherButton(String orderVoucher){
        return cartContentId + ".$" + orderVoucher + "." + "$" + orderVoucher + suffixCartContentId;
    }

}
