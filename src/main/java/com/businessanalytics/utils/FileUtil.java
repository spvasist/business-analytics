package com.businessanalytics.utils;

import org.apache.tomcat.util.codec.binary.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by srikanth on 13-04-2017.
 */
public class FileUtil {

    public static String readFileString(String path)
    {
        try {
            byte[] data = Files.readAllBytes(Paths.get(path));
            return StringUtils.newStringUtf8(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
