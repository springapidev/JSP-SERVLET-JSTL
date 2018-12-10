package com.apress.projsp;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * This acts like a filter on the body content, filtering out
 * the domain of e-mail addresses.
 *
 * @author    Simon Brown
 */
public class EmailAddressFilterTag extends BodyTagSupport {

  /**
   * Called when the end tag is encountered.
   */
  public int doEndTag() throws JspException {
    if (bodyContent != null) {
      try {
        String content = bodyContent.getString();
        content = filter(content);

        // now clear the original body content and write back
        // the filtered content
        bodyContent.clearBody();
        bodyContent.print(content);

        // finally, write the contents of the bodyContent object back to the
        // original JspWriter (out) instance
        bodyContent.writeOut(getPreviousOut());
      } catch (IOException ioe) {
        throw new JspTagException(ioe.getMessage());
      }
    }

    return EVAL_PAGE;
  }

  /**
   * Filters out characters that have meaning within JSP and HTML, and
   * replaces them with "escaped" versions.
   *
   * @param s   the String to filter
   * @return  the filtered String
   */
  private String filter(String s) {
    Pattern p = Pattern.compile("@[A-Za-z0-9_.]+\\.[A-Za-z]{2,}");
    Matcher m = p.matcher(s);
    return m.replaceAll("@...");
  }

}