package com.shizhen.util;

import java.io.BufferedReader;
import java.io.FileReader;

public class IOUtil {

    /**
     * read data from file and save as string array
     * @param filePath the path of file
     * @return string array of data
     */
    public static String[] readArrayFromFile(String filePath) {
        String[] result = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line.trim() + System.lineSeparator());
            }
            result = sb.toString().trim().split(System.lineSeparator());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
