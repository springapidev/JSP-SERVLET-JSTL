package com.apress.projsp;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagAdapter;

public class EventHandlerTag extends BodyTagSupport {
  private String name;

  public void setName(String s) {
    this.name = s;
  }

  public int doEndTag() throws JspException {
    if (bodyContent != null) {
      // get the body content (the JavaScript code)
      String content = bodyContent.getString();
      // now find the parent tag
      SelectTag tag = (SelectTag) ((TagAdapter) getParent()).getAdaptee();
      // and add the event handler to the select tag
      if (tag != null) {
        tag.addEventHandler(name, content);
      }
    }
    return EVAL_PAGE;
  }
}