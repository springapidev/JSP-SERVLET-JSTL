package com.apress.projsp.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Main page action, display aggregated blogs. */
public class MainAction extends BaseAction
{

  public MainAction(ServletContext ctx) throws Exception {
    super(ctx);
  }

  public void doGet(HttpServletRequest req, HttpServletResponse res) {
    try {
      req.setAttribute("ag", mAggregator);

      String path = req.getPathInfo();
      if ("/maincache".equals(path)) {
        req.getRequestDispatcher("/main_with_caching.jsp").forward(req, res);
      } else {
        req.getRequestDispatcher("/main.jsp").forward(req, res);
      }

    } catch (Exception e) {
      String msg = "ERROR Processing main action ["
                   + e.getMessage() + "]";
      req.setAttribute("processError", msg);
      mContext.log(msg, e);
    }
  }

}
