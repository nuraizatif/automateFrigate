package com.sepulsa.tesisautotest.configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nuraizatif on 11/13/16.
 */

public class paymentMethodSettings {

    public static Map<String, String> getPaymentMethod() {
        Map<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("credit_card", "commerce_veritrans|commerce_payment_commerce_veritrans");
        hashMap.put("bank_transfer", "commerce_veritrans|commerce_payment_atm_mandiri");
        hashMap.put("bca_bank_transfer", "bank_transfer|commerce_payment_bca_bank_transfer");
        hashMap.put("kredivo", "commerce_kredivo|commerce_payment_commerce_kredivo");
        hashMap.put("bni_debit_online", "commerce_veritrans|rules_bni_debit_online");
        return hashMap;
    }

}
