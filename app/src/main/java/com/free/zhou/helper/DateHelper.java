package com.free.zhou.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zskzh on 2017/5/1.
 */

public class DateHelper {
    public static String getDate(int i) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = calendar.getTime();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return simpleDateFormat.format(calendar.getTime());

    }
}
