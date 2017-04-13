package com.businessanalytics.utils;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by srikanth on 13-04-2017.
 */
public class StringUtil {

    public static String[] removeEmptyStrings(String[] strings)
    {
        LinkedList<String> list = new LinkedList<>(Arrays.asList(strings));
        list.removeAll(Arrays.asList("", null));
        String[] cleanList = new String[list.size()];
        return list.toArray(cleanList);

    }
}
