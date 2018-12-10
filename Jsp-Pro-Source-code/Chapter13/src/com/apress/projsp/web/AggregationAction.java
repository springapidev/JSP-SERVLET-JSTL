package com.apress.projsp.web;

import com.apress.projsp.Subscription;
import com.apress.projsp.User;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action for viewing of newsfeeds and aggregation.
 */
public class AggregationAction extends BaseAction
{
  public AggregationAction(ServletContext ctx) throws Exception {
    super(ctx);
  }

  // ---------------------------------------------------------------------

  /**
   * Process subscription form action.
   * 
   * @param ctx
   *          Servlet context.
   * @param req
   *          Servlet request.
   * @return Status message for display on page.
   */
  public void doGet(HttpServletRequest req, HttpServletResponse res) {
    try {
      String verb = req.getParameter("verb");

      if ((verb != null) && verb.equals("Aggregate")) {
        mAggregator.aggregate();
        req.setAttribute("processMessage", "Ran aggregation");
      }

      User user = (User) req.getSession().getAttribute("user");
      user = mAggregator.getUser(user.getName());
      req.setAttribute("user", user);

      Collection subs = user.getSubscriptions();
//      Iterator subIter = subs.iterator();
//
//      while (subIter.hasNext()) {
//        Subscription sub = (Subscription) subIter.next();
//        sub.getNewsfeed().getItems();
//      }

      req.setAttribute("subs", subs);

      req.getRequestDispatcher("/news.jsp").forward(req, res);
    } catch (Exception e) {
      String msg = "ERROR Processing form action ["
                   + e.getCause().getMessage() + "]";
      req.setAttribute("processError", msg);
      mContext.log(msg, e);
    }
  }
}
