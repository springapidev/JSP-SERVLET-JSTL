package com.apress.projsp;

import java.io.IOException;
import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ThumbnailTag extends SimpleTagSupport {
  private String path;

  private String suffix;

  public void setPath(String s) {
    this.path = s;
  }

  public void setSuffix(String s) {
    this.suffix = s;
  }

  public void doTag() throws JspException, IOException {
    // first of all, find the names of the files
    Collection files = findFiles();
    if (files != null && !files.isEmpty()) {
      String filename;
      // now that the names have been found, iterate over each of them
      // and generate the appropriate HTML
      Iterator it = files.iterator();
      while (it.hasNext()) {
        filename = (String) it.next();
        getJspContext().getOut().write("<img src=\".");
        getJspContext().getOut().write(filename);
        getJspContext().getOut().write("\" alt=\"");
        getJspContext().getOut().write(filename);
        getJspContext().getOut().write("\" width=\"128\" height=\"96\"> ");
      }
    }
  }

  private Collection findFiles() {
    PageContext pageContext = (PageContext) getJspContext();
    Collection resources = pageContext.getServletContext().getResourcePaths(
        path);
    List filteredResources = new ArrayList();
    if (resources == null || resources.isEmpty()) {
      return filteredResources;
    }
    Iterator it = resources.iterator();
    String uri;
    String testSuffix;
    if (this.suffix != null) {
      testSuffix = this.suffix;
    } else {
      testSuffix = ".jpg";
    }
    //   now filter out those files that don't end in the suffix
    while (it.hasNext()) {
      uri = (String) it.next();
      if (uri.endsWith(testSuffix)) {
        filteredResources.add(uri);
      }
    }
    return filteredResources;
  }
}