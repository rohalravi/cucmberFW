/*
 * Created on Fri Sep 16 2022
 * Pushpendra Kumar
 * Copyright (c) 2022 PepsiCo
 */
package com.pepsico.retail.helpers;

import java.util.Date;

import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class AssertionHelper {

    public boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }

    public boolean isValidPriceAndProductCount(String type, String value) {
        Pattern pattern = null;
        if (type.equals("OrderPrice")) {
            pattern = Pattern.compile("^[0-9, ]*\\p{Sc}$");
        } else if (type.equals("ProductConter")) {
            pattern = Pattern.compile("^[0-9 ]*Products$");
        }
        Matcher matcher = pattern.matcher(value);
        return matcher.find();

    }

}
