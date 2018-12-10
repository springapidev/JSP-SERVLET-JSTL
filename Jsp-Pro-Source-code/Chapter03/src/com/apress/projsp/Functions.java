package com.apress.projsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;

import javax.servlet.jsp.PageContext;

public class Functions {

  public static String toUpperCase(String theString) {
    return theString.toUpperCase();
  }

  public static String sayHello() {
    Calendar rightNow = Calendar.getInstance();
    int hour = rightNow.get(Calendar.HOUR);
    int AmPm = rightNow.get(Calendar.AM_PM);

    if (AmPm == Calendar.AM) {
      return "Good Morning";
    } else if (AmPm == Calendar.PM && hour < 6) {
      return "Good Afternoon";
    } else {
      return "Good Evening";
    }
  }

  public static String source(String filename, PageContext pageContext)
      throws IOException {

    // use the servlet context to read in the file
    InputStream in;
    BufferedReader br;
    StringBuffer buf = new StringBuffer();

    in = pageContext.getServletContext().getResourceAsStream(filename);
    br = new BufferedReader(new InputStreamReader(in));

    String line = br.readLine();

    while (line != null) {
      // replace opening and closing tags
      line = line.replaceAll("<", "&lt;");
      line = line.replaceAll(">", "&gt;");
      // writing out each line as we go

      buf.append(line + "\n");

      line = br.readLine();
    }

    br.close();

    // return the contents of the file
    return buf.toString();

  }

}