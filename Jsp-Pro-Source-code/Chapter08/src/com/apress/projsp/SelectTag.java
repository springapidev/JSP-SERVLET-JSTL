package com.apress.projsp;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SelectTag extends SimpleTagSupport {
  private String name;

  private String label;

  private String value;

  private Collection items;

  private HashMap eventHandlers;

  public SelectTag() {
    this.eventHandlers = new HashMap();
  }

  public void setName(String s) {
    this.name = s;
  }

  public void setLabel(String s) {
    this.label = s;
  }

  public void setValue(String s) {
    this.value = s;
  }

  public void setItems(Collection coll) {
    this.items = coll;
  }

  public void doTag() throws JspException, IOException {
    try {
      //  first of all we must evaluate the body content
      if (getJspBody() != null) {
        getJspBody().invoke(getJspContext().getOut());
      }
      JspWriter out = getJspContext().getOut();
      //  write the starting tag of the select control
      out.print("<select name=\"");
      out.print(name);
      out.print("\"");
      //  and now write out any event handlers
      Iterator it = eventHandlers.keySet().iterator();
      String eventHandlerName;
      while (it.hasNext()) {
        eventHandlerName = (String) it.next();
        out.print(" ");
        out.print(eventHandlerName);
        out.print("=\"");
        out.print(eventHandlers.get(eventHandlerName));
        out.print("\"");
      }
      out.print(">");
      it = items.iterator();
      while (it.hasNext()) {
        //  get the next JavaBean from the collection
        Object o = it.next();
        //  and use it to create a description of the property used
        //  to represent the displayable label
        PropertyDescriptor labelPD = new PropertyDescriptor(label, o.getClass());
        //  and the property used to represent the hidden value
        PropertyDescriptor valuePD = new PropertyDescriptor(value, o.getClass());
        //  and now generate the HTML
        out.print("<option value=\"");
        //  call the accessor method for the value property
        //  (this is the same as calling get<PropertyName>() on
        //  the JavaBean instance)
        out
            .print(valuePD.getReadMethod().invoke(o, new Object[] {})
                .toString());
        out.print("\">");
        //  and do the same for the label property
        out
            .print(labelPD.getReadMethod().invoke(o, new Object[] {})
                .toString());
        out.print("</option>");
      }
      //      write the ending tag of the select control
      out.print("</select>");
    } catch (Exception e) {
      e.printStackTrace();
      throw new JspTagException(e.getMessage());
    }
  }

  public void addEventHandler(String name, String code) {
    eventHandlers.put(name, code);
  }
}