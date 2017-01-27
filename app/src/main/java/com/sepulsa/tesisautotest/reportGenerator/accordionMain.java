package com.sepulsa.tesisautotest.reportGenerator;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nuraizatif on 1/14/17.
 */

public class accordionMain {

    // Define main template path.
    public static String mainAccordionPath = "/Users/nuraizatif/Sites/tesisAutoTest/report/template/";

    // Define name main template.
    public static String mainAccordionName = "panel.html";

    public static void generateNewPanel(String skenario) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(mainAccordionPath + mainAccordionName));
        String str;
        String newContent = "";

        List<String> list = new ArrayList<String>();
        while((str = file.readLine()) != null){
            list.add(str);
        }

        String[] stringArr = list.toArray(new String[0]);

        for (int i = 0; i < stringArr.length; i++) {
            newContent += stringArr[i] + '\n';
        }

        File tempReport = reportFile.findCurrentReport();

        try {
            // Read file main file.
            String content = FileUtils.readFileToString(tempReport, "UTF-8");

            // Replace tab_detail.
            content = content.replaceAll("\\<\\!\\-\\-\\(tab_detail\\)\\-\\-\\>", "");

            // Replace img_detail.
            content = content.replaceAll("\\<\\!\\-\\-\\(img_detail\\)\\-\\-\\>", "");

            // Replace panel.
            content = content.replaceAll("\\<\\!\\-\\-\\(panel\\)\\-\\-\\>", newContent);

            String panel_id = MD5(skenario);

            // Replace id.
            content = content.replaceAll("\\<\\!\\-\\-\\(panel_id\\)\\-\\-\\>", panel_id);

            // Replace judul.
            content = content.replaceAll("\\<\\!\\-\\-\\(panel_title\\)\\-\\-\\>", skenario);

            // Write new panel to file.
            FileUtils.writeStringToFile(tempReport, content, "UTF-8");
        } catch (IOException e) {
            //Simple exception handling, replace with what's necessary for your use case!
            throw new RuntimeException("Generating file failed", e);
        }
    }

    public static void creteNewDetails(String tab, String img, String skenario) throws IOException {
        File tempReport = reportFile.findCurrentReport();

        try {
            // Read file main file.
            String content = FileUtils.readFileToString(tempReport, "UTF-8");

            // Define tab details pattern.
            String tabToCompare = "<!--(tab_detail)-->";

            // Define img details pattern.
            String imgToCompare = "<!--(img_detail)-->";

            // Check if there is no pattern details.
            if (!content.toLowerCase().contains(tabToCompare.toLowerCase())
                    && !content.toLowerCase().contains(imgToCompare.toLowerCase())) {
                // Generate new panel.
                generateNewPanel(skenario);

                // Load new file.
                tempReport = reportFile.findCurrentReport();
            }

            // Load new content.
            content = FileUtils.readFileToString(tempReport, "UTF-8");

            // Replace tab_detail.
            content = content.replaceAll("\\<\\!\\-\\-\\(tab\\_detail\\)\\-\\-\\>", tab + '\n' + tabToCompare);

            // Replace img_detail.
            content = content.replaceAll("\\<\\!\\-\\-\\(img\\_detail\\)\\-\\-\\>", img + '\n' + imgToCompare);

            // Write new details to file.
            FileUtils.writeStringToFile(tempReport, content, "UTF-8");

        } catch (IOException e) {
            //Simple exception handling, replace with what's necessary for your use case!
            throw new RuntimeException("Generating file failed", e);
        }
    }

    public static String MD5(String md5) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        md5 = md5 + timestamp.getTime();
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
