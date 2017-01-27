package com.sepulsa.tesisautotest.reportGenerator;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * Created by nuraizatif on 1/14/17.
 */

public class accordionDetails {

    // Define Template Tab.
    public static String templateTab = "<li (class_active)><a href=\"#(ganti_id)\" data-toggle=\"tab\">(ganti_caption)</a></li>";

    // Define Template Image.
    public static String templateImage= "<div class=\"tab-pane (active)\" id=\"(ganti_id)\"><img src=\"(ganti_path)\" alt=\"\" class=\"img-responsive\"></div>";

    public static void addDetails(String path, String name, String skenario, Boolean first) throws IOException {
        // Define Template Tab.
        String temp = templateTab;

        // Define Template Tab.
        String tempImg = templateImage;

        // Check if its first details.
        if (first) {
            accordionMain.generateNewPanel(skenario);

            // Replace (class_active).
            temp = temp.replaceAll("\\(class_active\\)", "class=\"active\"");

            // Replace (active).
            tempImg = tempImg.replaceAll("\\(active\\)", "active");
        }
        else {
            // Remove (class_active).
            temp = temp.replaceAll("\\(class_active\\)", "");

            // Remove (active).
            tempImg = tempImg.replaceAll("\\(active\\)", "");

        }

        // Prepare id & caption.
        String[] splitName = name.split("/");

        // Define fix id.
        String fix_id = splitName[0] + "_" + splitName[1];

        // Replace ganti_id.
        temp = temp.replaceAll("\\(ganti_id\\)", fix_id);

        String[] split = splitName[1].split("_");
        String caption = "";
        for (int i = 0; i < split.length; i++) {
            if (i == 0) {
                caption += split[i] + ".";
            }
            else {
                caption += " " + split[i];
            }
        }

        temp = temp.replaceAll("\\(ganti_caption\\)", caption);

        // Replace ganti_id.
        tempImg = tempImg.replaceAll("\\(ganti_id\\)", fix_id);

        // Replace ganti_path.
        tempImg = tempImg.replaceAll("\\(ganti_path\\)", path + name + ".png");

        accordionMain.creteNewDetails(temp, tempImg, skenario);
    }
}
