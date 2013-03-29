package com.pcci.idlsweb.reports.util;

import java.text.DecimalFormat;

public class DisplayUtil {
	public static String getDecimalFormat(String pattern, double number) {
        DecimalFormat formatter = new DecimalFormat(pattern);
        return formatter.format(number);
    }
}
