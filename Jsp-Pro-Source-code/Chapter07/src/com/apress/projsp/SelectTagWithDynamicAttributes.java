package com.apress.projsp;

import java.beans.PropertyDescriptor;
import java.util.*;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Given a collection, this tag produces a HTML select (dropdown) list
 * based upon the collection.
 *
 * @author    Simon Brown
 */
public class SelectTagWithDynamicAttributes
    extends TagSupport implements DynamicAttributes {

  /** the name of the select control */
  private String name;

  /** the name of the property to be used as the displayed label */
  private String label;

  /** the name of the property to be used as the hidden value */
  private String value;

  /** the collection over which this tag should iterate */
  private Collection items;

  /** the map used to store any dynamic attributes */
  private Map dynamicAttributes = new HashMap();

  /**
   * Called when the starting tag is encountered.
   */
  public int doStartTag() throws JspException {
    // setup the iterator to be used
    Iterator iterator = items.iterator();

    try {
      JspWriter out = pageContext.getOut();

      // write the starting tag of the select control
      out.print("<select name=\"");
      out.print(name);
      out.print("\"");

      // insert the dynamic attributes
      Iterator it = dynamicAttributes.keySet().iterator();
      while (it.hasNext()) {
        String key = (String)it.next();
        out.print(" ");
        out.print(key);
        out.print("=\"");
        out.print(dynamicAttributes.get(key));
        out.print("\"");
      }

      out.print(">");

      while (iterator.hasNext()) {
        // get the next JavaBean from the collection
        Object o = iterator.next();

        // and use it to create a description of the property used
        // to represent the displayable label
        PropertyDescriptor labelPD =
            new PropertyDescriptor(label, o.getClass());

        // and the property used to represent the hidden value
        PropertyDescriptor valuePD =
            new PropertyDescriptor(value, o.getClass());

        // and now generate the HTML
        out.print("<option value=\"");

        // call the accessor method for the value property
        // (this is the same as calling get<PropertyName>() on
        // the JavaBean instance)
        out.print(
            valuePD.getReadMethod().invoke(o, new Object[]{}).toString());
        out.print("\">");

        // and do the same for the label property
        out.print(
            labelPD.getReadMethod().invoke(o, new Object[]{}).toString());
        out.print("</option>");
      }

      // write the ending tag of the select control
      out.print("</select>");

    } catch (Exception e) {
      throw new JspTagException(e.getMessage());
    }

    // and skip the body
    return SKIP_BODY;
  }

  /**
   * Sets the collection over which this tag should iterate.
   *
   * @param coll    a Collection
   */
  public void setItems(Collection coll) {
    this.items = coll;
  }

  /**
   * Sets the name for the generated select control.
   *
   * @param s   the name as a String
   */
  public void setName(String s) {
    this.name = s;
  }

  /**
   * Sets the name of the property to display.
   *
   * @param s   the name of the label property
   */
  public void setLabel(String s) {
    this.label = s;
  }

  /**
   * Sets the name of the property to use as the hidden value.
   *
   * @param s   the name of the value property
   */
  public void setValue(String s) {
    this.value = s;
  }

  /**
   * Called to set a dynamic attribute on this tag handler.
   *
   * @param uri     // todo
   * @param name    the name of the attribute
   * @param value   the value of the attribute
   */
  public void setDynamicAttribute(String uri, String name, Object value) {
    dynamicAttributes.put(name, value);
  }

}