package com.verizon.dashvue.util;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DashvueUtils {

    //    /**
//     * Return {@code string value} if the supplied Object is not {@code null} or empty.
//     * Otherwise, return {@code null}.
//     * @param obj the Object to convert
//     * @return the string value of Object
//     */
    public static String objectToString(@Nullable Object obj) {
        if (null != obj) {
            return obj.toString();
        }
        return null;
    }

    public static Long objectToLong(Object obj) {
        if (null != obj && !StringUtils.isEmpty(objectToString(obj))) {
            return Long.parseLong(objectToString(obj));
        }
        return null;
    }

    public static Date objectToSqlDate(Object obj) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        try {
            if (null != obj && !StringUtils.isEmpty(objectToString(obj))) {
                return new Date(sdf.parse(objectToString(obj)).getTime());
            }
            return null;
        } catch (ParseException e) {
            // Todo
            return null;
        }
    }

    public static LocalDate objectToLocalDate(Object obj) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-mm-yyyy");
        if (null != obj && !StringUtils.isEmpty(objectToString(obj))) {
            return LocalDate.parse(objectToString(obj), dtf);
        }
        return null;
    }

}
