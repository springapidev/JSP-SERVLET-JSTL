package com.apress.projsp;

import java.util.Date;
import java.text.*;

public class DateFormatBean {
  private DateFormat dateFormat;
  private Date date;

  public DateFormatBean() {
    dateFormat = DateFormat.getInstance();
    date = new Date();
  }

  public String getDate() {
    return dateFormat.format(date);
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public void setFormat(String format) {
    this.dateFormat = new SimpleDateFormat(format);
  }
}
