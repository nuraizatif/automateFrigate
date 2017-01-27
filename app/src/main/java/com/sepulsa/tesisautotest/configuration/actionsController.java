package com.sepulsa.tesisautotest.configuration;

/**
 * Created by nuraizatif on 10/28/16.
 */

import com.sepulsa.tesisautotest.reportGenerator.accordionDetails;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;


/**
 * TODO :
 * 1. Press button (selennium action / js).
 * 2. Take ScreenShot.
 * 3. Scroll screen.
 * 4. Choose radio button.
 */

public class actionsController {

    private static String fullPath = "/Users/nuraizatif/Sites/tesisAutoTest/report/img_report/";

    private static long defaultWait = 2000;

    private static int defaultMinCoordinate = 10;
    // Define not found string.
    private static String elementNotFound = "Element Not Found";

    /**
     * Function to press button with xpath.
     *
     * @param driver
     *  Webdriver object.
     * @param tag
     *  Html tag that you want to press.
     * @param specificTags
     *  Value in data-reactid.
     */
    public static void pressButtonByAjax(WebDriver driver, String tag, String specificTags) {
        waitElementIsVisibleByXpath(driver, tag, specificTags);
        WebElement gobutton = driver.findElement(By.xpath("//" + tag + "[@data-reactid=\"" + specificTags + "\"]"));
        Point coordinates = gobutton.getLocation();
        scrollByAjax(driver, 0, coordinates.getY() - defaultMinCoordinate);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", gobutton);
        try {
            Thread.sleep(defaultWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function to press button with xpath.
     *
     * @param driver
     *  Webdriver object.
     * @param tag
     *  Html tag that you want to press.
     * @param specificTags
     *  Value in data-reactid.
     * @param scrool
     *  Need to scrool or not.
     */
    public static void pressButtonByAjax(WebDriver driver, String tag, String specificTags, boolean scrool) {
        waitElementIsVisibleByXpath(driver, tag, specificTags);
        WebElement gobutton = driver.findElement(By.xpath("//" + tag + "[@data-reactid=\"" + specificTags + "\"]"));
        if (scrool) {
            Point coordinates = gobutton.getLocation();
            System.out.println(coordinates.getX() + " , " + coordinates.getY());
            scrollByAjax(driver, 0, coordinates.getY());
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", gobutton);
        try {
            Thread.sleep(defaultWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function to press image voucher and show details of the voucher.
     *
     * @param driver
     *  Webdriver object.
     * @param tag
     *  Html tag that you want to press.
     * @param specificTags
     *  Value of class tag.
     * @param classTag
     *  Class tag image that want to search.
     */
    public static void pressButtonByAjax(WebDriver driver, String tag, String specificTags, String classTag){
        waitElementIsVisibleByXpath(driver, tag, specificTags, classTag);
        WebElement gobutton = driver.findElement(By.xpath("//" + tag + "[@" + classTag + "=\"" + specificTags + "\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", gobutton);
        try {
            Thread.sleep(defaultWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function to press button with xpath.
     *
     * @param driver
     *  Webdriver object.
     * @param id
     *  Element id.
     */
    public static void pressButtonById(WebDriver driver, String id) {
        driver.findElement(By.id(id)).click();
        try {
            Thread.sleep(defaultWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function to press button with xpath.
     *
     * @param driver
     *  Webdriver object.
     * @param name
     *  Element id.
     */
    public static void pressButtonByName(WebDriver driver, String name) {
        driver.findElement(By.name(name)).click();
        try {
            Thread.sleep(defaultWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function to screenshot after test.
     *
     * @param driver
     *  Webdriver object.
     * @param fileName
     *  fileName.
     */
    public static void takeScreenshot(WebDriver driver, String fileName){
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fixPath = fullPath + fileName + ".png" ;
        System.out.println(fixPath);
        try {
            // Copy paste file at destination folder location
            FileUtils.copyFile(source, new File(fixPath));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function to screenshot after test.
     *
     * @param driver
     *  Webdriver object.
     * @param fileName
     *  fileName.
     * @param skenario
     *  Skenario untuk report.
     */
    public static void takeScreenshot(WebDriver driver, String fileName, String skenario, boolean first){
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fixPath = fullPath + fileName + ".png" ;
        System.out.println(fixPath);
        try {
            // Copy paste file at destination folder location
            FileUtils.copyFile(source, new File(fixPath));
            accordionDetails.addDetails(fullPath, fileName, skenario, first);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  Function to input text to field.
     *
     * @param driver
     *  Webdriver Object.
     * @param tag
     *  Html tag that you want to press.
     * @param specificTags
     *  Value in data-reactid.
     * @param Text
     *  Text to input.
     */
    public static void inputText(WebDriver driver, String tag, String specificTags, String Text){
        waitElementIsVisibleByXpath(driver, tag, specificTags);
        driver.findElement(By.xpath("//" + tag + "[@data-reactid=\"" + specificTags + "\"]")).sendKeys(Text);
    }

    /**
     *  Function to input text to field.
     *
     * @param driver
     *  Webdriver Object.
     * @param id
     *  Element id.
     * @param Text
     *  Text to input.
     */
    public static void inputTextById(WebDriver driver, String id, String Text){
        waitElementIsVisibleByid(driver, id);
        driver.findElement(By.id(id)).sendKeys(Text);
    }

    /**
     * Function to wait is visible in page.
     *
     * @param driver
     *  WebDriverWait Object.
     * @param tag
     *  Html tag that you want to press.
     * @param specificTags
     *  Value in data-reactid.
     */
    public static void waitElementIsVisibleByXpath(WebDriver driver, String tag, String specificTags) {
        // Define wait variable.
        WebDriverWait wait = new WebDriverWait(driver, 30);

        // Wait until element is visible.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//" + tag + "[@data-reactid=\"" + specificTags + "\"]")));
    }

    /**
     * Function to wait is visible in page.
     *
     * @param driver
     *  WebDriverWait Object.
     * @param tag
     *  Html tag that you want to press.
     * @param specificTags
     *  Value in class tag.
     * @param classTag
     *  Class tag.
     */
        public static void waitElementIsVisibleByXpath (WebDriver driver, String tag, String specificTags, String classTag) {
        // Define wait variable.
        WebDriverWait wait = new WebDriverWait(driver, 30);

        // Wait until element is visible.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//" + tag + "[@" + classTag + "=\"" + specificTags + "\"]")));
    }

    /**
     * Function to wait is visible in page by id.
     *
     * @param driver
     *  WebDriverWait Object.
     * @param id
     *  Id element.
     */
    public static void waitElementIsVisibleByid (WebDriver driver, String id) {
        // Define wait variable.
        WebDriverWait wait = new WebDriverWait(driver, 2);

        // Wait until element is visible by id.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    /**
     *  Function to compare value of element.
     *
     * @param driver
     *  Webdriver Object.
     * @param tag
     *  Html tag that you want to press.
     * @param specificTags
     *  Value in data-reactid.
     * @param Text
     *  Text to compare.
     *
     *  @return boolean
     */
    public static boolean compareTextElement(WebDriver driver, String tag, String specificTags, String Text) {
        // Compare Text.
        return driver.findElement(By.xpath("//" + tag + "[@data-reactid=\"" + specificTags + "\"]")).getText().toString().equalsIgnoreCase(Text);
    }

    /**
     *  Function to count element in some element
     *
     * @param driver
     *  Webdriver Object.
     * @param tag
     *  Html tag that you want to press.
     * @param specificTags
     *  Value in data-reactid.
     * @param childTag
     *  Child tag that want to count.
     *
     * @return int.
     */
    public static int countElementInElement(WebDriver driver, String tag, String specificTags, String childTag){
        waitElementIsVisibleByXpath(driver, tag, specificTags);
        return driver.findElements(By.xpath("//" + tag + "[@data-reactid=\"" + specificTags + "\"]/"+ childTag)).size();
    }

    /**
     * Function to count element in some element
     *
     * @param driver
     *  Webdriver Object.
     * @param tag
     *  Html tag that you want to press.
     * @param specificTags
     *  Value in data-reactid.
     * @param childTag
     *  Child tag that want to count.
     * @param classTag
     *  Class parent tag.
     *
     * @return int
     */
    public static int countElementInElement(WebDriver driver, String tag, String specificTags, String childTag, String classTag){
        waitElementIsVisibleByXpath(driver, tag, specificTags, classTag);
        return driver.findElements(By.xpath("//" + tag + "[@" + classTag + "=\"" + specificTags + "\"]/"+ childTag)).size();
    }

    /**
     * Function to show page base on sosition.
     *
     * @param x
     *  X Position.
     * @param y
     *  Y Position.
     */
    public static void scrollByAjax(WebDriver driver, int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll("+ x +", "+ y +");");
    }

    /**
     * Function to get react id if you know just xpath element
     *
     * @param driver
     *  Webdriver Object.
     * @param tag
     *  Html tag that you want to press.
     * @param specificTags
     *  Value in data-reactid.
     * @param classTag
     *  Class parent tag.
     */
    public static String getReactIdByElementAjax(WebDriver driver, String tag, String specificTags, String classTag){
        waitElementIsVisibleByXpath(driver, tag, specificTags, classTag);
        WebElement searchElement = driver.findElement(By.xpath("//" + tag + "[@" + classTag + "=\"" + specificTags + "\"]"));
        if (!searchElement.getAttribute("data-reactid").isEmpty()) {
            return searchElement.getAttribute("data-reactid");
        }
        return elementNotFound;
    }

    /**
     * Function to select dropdown By Xpath.
     *
     * @param driver
     *  Webdriver Object.
     * @param tag
     *  Html tag that you want to press.
     * @param specificTags
     *  Value in data-reactid.
     * @param value
     *  Value to select.
     */
    public static void selectFromDropdownByAjax(WebDriver driver, String tag, String specificTags, String value) {
        waitElementIsVisibleByXpath(driver, tag, specificTags);
        Select dropdown = new Select(driver.findElement(By.xpath("//" + tag + "[@data-reactid=\"" + specificTags + "\"]")));
        dropdown.selectByVisibleText(value);
    }

    /**
     * Function to select dropdown By Id.
     *
     * @param driver
     *  Webdriver Object.
     * @param id
     *  Id Element
     * @param value
     *  Value to select.
     */
        public static void selectFromDropdownById(WebDriver driver, String id, String value) {
        waitElementIsVisibleByid(driver, id);
        Select dropdown = new Select(driver.findElement(By.id(id)));
        dropdown.selectByVisibleText(value);
    }
}
