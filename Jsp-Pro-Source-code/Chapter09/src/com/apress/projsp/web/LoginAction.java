package com.apress.projsp.web;

import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apress.projsp.*;

/////////////////////////////////////////////////////////////////////////////

/**
 * Action for loggging into Ag.
 */
public class LoginAction implements Action
{
  private ServletContext mContext = null;
  private Aggregator mAggregator = null;

  public LoginAction(ServletContext ctx) throws Exception {
    mContext = ctx;
    mAggregator = (Aggregator) ctx.getAttribute("aggregator");
  }

  /**
   * Respond to call from Controller.
   * 
   * @param req
   *          Servlet request.
   * @param res
   *          Servlet response.
   */
  public void doGet(HttpServletRequest req, HttpServletResponse res) {
    try {
      String verb = req.getParameter("verb");
      String name = req.getParameter("userName");

      if ((verb != null) && verb.equals("Login")) {
        User user = mAggregator.getUser(name);
        req.getSession(true).setAttribute("user", user);
        Collection subs = user.getSubscriptions();
        req.setAttribute("subs", subs);
        req.getRequestDispatcher("/subs.jsp").forward(req, res);
      } else {
        req.getRequestDispatcher("/login.jsp").forward(req, res);
      }
    } catch (Exception e) {
      e.printStackTrace();
      String msg = "ERROR Processing form action [";
      if (e.getCause() != null) {
        msg = msg + e.getCause().getMessage() + "]";
      } else {
        msg = msg + e.getMessage() + "]";
      }
      req.setAttribute("processError", msg);
      mContext.log(msg, e);
    }
  }
}
