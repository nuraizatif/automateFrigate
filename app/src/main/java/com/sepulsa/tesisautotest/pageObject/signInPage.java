package com.sepulsa.tesisautotest.pageObject;

/**
 * Created by nuraizatif on 10/30/16.
 */

/**
 * TODO :
 * 1. List all react id on this page.
 */

public class signInPage {
    //-------- STRING TO COMPARE ---------//

    // Menu Page URL.
    public static String url = "https://m.sepulsa.id/signin";

    // Message wrong email / password.
    public static String invalidEmailPassword = "Wrong username or password.";

    // Message invalid email pattern.
    public static String invalidEmailPattern = "Masukkan email yang valid";

    // Message invalid password pattern.
    public static String invalidPasswordPattern = "Password minimal 6 karakter";

    //-------- DEFINE ELEMENT -----------//

    // Logo sepulsa (redirect to menuPage).
    public static String logoSepulsa = ".0.0.0.0";
    public static String logoSepulsaTag = "a";

    // Back Button (redirect to menuPage).
    public static String backButton = ".0.0.2";
    public static String backButtonTag = "button";

    // Alert Bar.
    public static String alertBar = ".0.3.2.0";
    public static String alertBarTag = "div";

    // Title Sign in form.
    public static String signInTitleForm = ".0.3.1";
    public static String signInTitleFormTag = "div";

    // Username Field.
    public static String usernameField = ".0.3.3.0.0.0.2.0";
    public static String usernameFieldTag = "input";

    // Password Field.
    public static String passwordField = ".0.3.3.0.0.1.2.0";
    public static String passwordFieldTag = "input";

    // Show / Hidden Password button.
    public static String showHiddenPasswordField = ".0.3.3.0.0.1.2.1";
    public static String showHiddenPasswordFieldTag = "a";

    // Submit button.
    public static String submitButton = ".0.3.3.0.0.2.0";
    public static String submitButtonTag = "button";

    // Forgot password button.
    public static String forgotPasswordButton = ".0.3.4.0";
    public static String forgotPasswordButtonTag = "a";

    // Login with facebook button.
    public static String loginFacebookButton = ".0.3.6.0";
    public static String loginFacebookButtonTag = "a";

    // Login with Google+ button.
    public static String loginGoogleButton = ".0.3.6.1";
    public static String loginGoogleButtonTag = "a";

    // Login with Line button.
    public static String loginLineButton = ".0.3.6.2";
    public static String loginLineButtonTag = "a";

    // Sign Up button.
    public static String signUpButton = ".0.3.7.3";
    public static String signUpButtonTag = "a";

    // ---------- Google Page Element--------------//

    // Email field.
    public static String googleEmailFieldId = "Email";

    // Button next.
    public static String googleNextButtonId = "next";

    // Password field.
    public static String googlePasswordFieldId = "Passwd";

    // Button submit.
    public static String googleSignInButtonId = "signIn";

    // Allow button.
    public static String googleAllowbuttonId = "submit_approve_access";

}
