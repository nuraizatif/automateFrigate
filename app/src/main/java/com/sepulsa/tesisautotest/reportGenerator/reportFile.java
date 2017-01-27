package com.sepulsa.tesisautotest.reportGenerator;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nuraizatif on 1/14/17.
 */

public class reportFile {

    // Define main template path.
    public static String mainPath = "/Users/nuraizatif/Sites/tesisAutoTest/report/template/";

    // Define name main template.
    public static String mainName = "main.html";

    // Define target path.
    public static String targetPath = "/Users/nuraizatif/Sites/tesisAutoTest/report/fix_report/";

    // Define name of temp report.
    public static String reportTempName = "tempReport.html";

    // Function to generate Temp Fix Report.
    public static void generateTempReport() throws IOException {
        // Find main tempalate.
        File mainTemplate = new File(mainPath + mainName);

        // Create temp file.
        File tempReport = new File(targetPath + reportTempName);

        try {
            // Define date.
            Date date = new Date();
            SimpleDateFormat currentDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            // Read file main file.
            String content = FileUtils.readFileToString(mainTemplate, "UTF-8");

            // Replace judul.
            content = content.replaceAll("\\<\\!\\-\\-\\(judul\\)\\-\\-\\>", "Report " + currentDate.format(date));

            // Write new judul to file.
            FileUtils.writeStringToFile(tempReport, content, "UTF-8");
        } catch (IOException e) {
            //Simple exception handling, replace with what's necessary for your use case!
            throw new RuntimeException("Generating file failed", e);
        }
    }

    // Find active temp report.
    public static File findCurrentReport() throws IOException {
        // Create temp file.
        File tempReport = new File(targetPath + reportTempName);

        if(!tempReport.exists()) {
            generateTempReport();

            tempReport = new File(targetPath + reportTempName);
        }

        return tempReport;
    }

    // Finish report and rename it.
    public static void finishReport(String tempName) {

    }
}
