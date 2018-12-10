package com.apress.projsp.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Main page action, display aggregated blogs. */
public class LinkAction extends BaseAction
{

  public LinkAction(ServletContext ctx) throws Exception {
    super(ctx);
  }

  public void doGet(HttpServletRequest req, HttpServletResponse res) {
    try {
      String link = req.getParameter("link");
      mAggregator.hitItem(link);
      res.sendRedirect(link);
    } catch (Exception e) {
      String msg = "ERROR Processing main action ["
                   + e.getMessage() + "]";
      req.setAttribute("processError", msg);
      mContext.log(msg, e);
    }
  }
}
