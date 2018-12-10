package com.apress.projsp;

import java.util.Collection;
import java.util.Iterator;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class IteratorTag extends TagSupport {
  private String type;

  private Collection items;

  private Iterator iterator;

  public void setType(String s) {
    this.type = s;
  }

  public void setItems(Collection coll) {
    this.items = coll;
  }

  public int doStartTag() throws JspException {
    // set up the iterator to be used
    iterator = items.iterator();
    if (iterator.hasNext()) {
      // if there are elements, put the first one into page
      // scope under the name provided by the "id" attribute
      pageContext.setAttribute(id, iterator.next());
      // and include the body
      return EVAL_BODY_INCLUDE;
    } else {
      // there are no elements so skip the body
      return SKIP_BODY;
    }
  }

  public int doAfterBody() throws JspException {
    if (iterator.hasNext()) {
      //if there are more elements, put the next one into page
      //scope under the name provided by the "id" attribute
      pageContext.setAttribute(id, iterator.next());
      //and instruct the JSP engine to reevaluate the body of this tag
      return EVAL_BODY_AGAIN;
    } else {
      //there are no more elements so skip the body
      return SKIP_BODY;
    }
  }
}