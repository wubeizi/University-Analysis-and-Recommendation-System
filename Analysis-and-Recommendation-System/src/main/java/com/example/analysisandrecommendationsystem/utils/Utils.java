package com.example.analysisandrecommendationsystem.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utils {
//    将String转换成Date
    public Date stringtoDate(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf.parse(dateString);
        // 将 java.util.Date 转换为 java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }

    public float stringtoFloat(String floatString){
        float floatValue = Float.parseFloat(floatString);
        return floatValue;
    }

    public int stringtoInt(String intString){
        return Integer.parseInt(intString);
    }
}
