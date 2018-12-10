package com.apress.projsp;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Given a collection, this tag iterates over each element and makes it
 * available to the page.
 *
 * @author    Simon Brown
 */
public class IteratorTag extends TagSupport {

  /** the name of the scoped attribute used to access each element */
  private String var;

  /** the collection over which this tag should iterate */
  private Collection items;

  /** the iterator used by this tag */
  private Iterator iterator;

  /**
   * Called when the starting tag is encountered.
   */
  public int doStartTag() throws JspException {
    // setup the iterator to be used
    iterator = items.iterator();

    if (iterator.hasNext()) {
      // if there are elements, put the first one into page
      // scope under the name provided by the "var" attribute
      pageContext.setAttribute(var, iterator.next());

      // and include the body
      return EVAL_BODY_INCLUDE;
    } else {
      // there are no elements so skip the body
      return SKIP_BODY;
    }
  }

  /**
   * Called after the body has been evaluated.
   */
  public int doAfterBody() throws JspException {
    if (iterator.hasNext()) {
      // if there are more elements, put the next one into page
      // scope under the name provided by the "var" attribute
      pageContext.setAttribute(var, iterator.next());

      // and instruct the JSP engine to re-evaluate the body of this tag
      return EVAL_BODY_AGAIN;
    } else {
      // there are no more elements so skip the body
      return SKIP_BODY;
    }
  }

  public void setVar(String s) {
    this.var = s;
  }

  /**
   * Sets the collection over which this tag should iterate.
   *
   * @param coll    a Collection
   */
  public void setItems(Collection coll) {
    this.items = coll;
  }

}