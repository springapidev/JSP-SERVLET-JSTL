package com.apress.projsp;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Outputs the current date and time to the page.
 *
 * @author    Simon Brown
 */
public class DateTimeTag extends TagSupport {

  /**
   * Called when the starting tag is encountered.
   */
  public int doStartTag() throws JspException {
    DateFormat df = DateFormat.getDateTimeInstance(
        DateFormat.MEDIUM, DateFormat.MEDIUM);

    try {
      // now write out the formatted date to the page
      pageContext.getOut().write(df.format(new Date()));
    } catch (IOException ioe) {
      throw new JspTagException(ioe.getMessage());
    }

    return SKIP_BODY;
  }

}