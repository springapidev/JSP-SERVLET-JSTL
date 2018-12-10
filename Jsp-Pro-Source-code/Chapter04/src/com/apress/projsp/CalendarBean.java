package com.apress.projsp;

import java.util.Calendar;
import java.util.Date;

/**
 * Simple bean wrapper around a Calendar to enable the manipulation
 * via JSTL tag.
 *
 * @author  Dan Jepp
 */
public class CalendarBean {

    private Calendar calendar;

    public CalendarBean() {
        calendar = Calendar.getInstance();
    }

    public Date getTime() {
        return calendar.getTime();
    }

    public int getHour() {
      return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinute() {
      return calendar.get(Calendar.MINUTE);
    }
}
