package com.apress.projsp.web;

import com.apress.projsp.User;
import java.util.Collection;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Action for subscription management. */
public class SubscriptionAction extends BaseAction
{

  public SubscriptionAction(ServletContext mContext) throws Exception {
    super(mContext);
  }

  /** Process subscription action. */
  public void doGet(HttpServletRequest req, HttpServletResponse res) {
    try {
      String verb = req.getParameter("verb");
      String name = req.getParameter("name");
      String url = req.getParameter("url");
      String remove = req.getParameter("remove");
      String subname = req.getParameter("subname");

      // Perform action specified by request attribute 'verb'
      if ((verb != null) && verb.equals("Add")) {
        User user = (User) req.getSession().getAttribute("user");
        mAggregator.addSubscription(user, name, url);
        req.setAttribute("processMessage", "Added subscription ["
                                           + name + "]");
      } else if ((remove != null)
                 && verb != null && verb.equals("Remove")) {
        mAggregator.removeSubscription(remove);
        req.setAttribute("processMessage", "Removed subscription ["
                                           + subname + "]");
      }

      // Load model into context for page
      User user = (User) req.getSession().getAttribute("user");
      user = mAggregator.getUser(user.getName());
      req.setAttribute("user", user);

      Collection subs = user.getSubscriptions();
      req.setAttribute("subs", subs);

      // Forward to view
      req.getRequestDispatcher("/subs.jsp").forward(req, res);
    } catch (Exception e) {
      String msg = "ERROR Processing form action ["
                   + e.toString() + "]";
      req.setAttribute("processError", msg);
      mContext.log(msg, e);
    }
  }
}
