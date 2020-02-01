package com.hziee.util;

import com.hziee.po.Vacate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
    public static List<Vacate> formatList(List<Vacate> list) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Vacate vacate : list) {
            Date submit_time = new Date(new Long(vacate.getSubmit_time()));
            vacate.setSubmit_time(timeFormat.format(submit_time));
            Date start_time = new Date(new Long(vacate.getStart_time()));
            vacate.setStart_time(dateFormat.format(start_time));
            Date end_time = new Date(new Long(vacate.getEnd_time()));
            vacate.setEnd_time(dateFormat.format(end_time));
        }
        return list;
    }

    public static int dateToWeek(String datetime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int[] weekDays = {7, 1, 2, 3, 4, 5, 6};
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        try {
            cal.setTime(dateFormat.parse(datetime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int i = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天
        if (i < 0)
            i = 0;
        return weekDays[i];
    }
}
