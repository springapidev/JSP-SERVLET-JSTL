package com.apress.projsp.web;

import com.apress.projsp.Aggregator;
import com.apress.projsp.AggregatorImpl;
import com.apress.projsp.persist.AggregatorDAO;
import com.apress.projsp.persist.castor.CastorAggregatorDAO;
import com.apress.projsp.persist.hibe.HibeAggregatorDAO;
import com.apress.projsp.web.SubscriptionAction;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller Servlet creates and calls actions.
 */
public class Controller extends HttpServlet
{
  private Map mActions = new HashMap();
  private LoginAction mLoginAction = null;
  private ServletContext mContext = null;

  /**
   * Respond to request by calling action specified by pathinfo.
   */
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException
  {
    Action action = (Action) mActions.get(req.getPathInfo());

    if (action != null) {
      if (req.getSession(true).getAttribute("user") == null) {
        action = mLoginAction;
      }
      action.doGet(req, res);
    } else {
      res.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }

  /**
   * Calls doGet().
   */
  public void doPost(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException
  {
    doGet(req, res);
  }

  /**
   * Two tasks: 1) create DAO class and store in Context as attribute
   * and 2) create actions and hash them away.
   */
  public void init(ServletConfig config) throws ServletException {
    try {
      // Create DAO and store it as Context attribute
      AggregatorDAO dao = null;

      String engineClassName = config.getServletContext()
          .getInitParameter("persistenceEngine");
      if (engineClassName != null
          && engineClassName.equals("hibernate")) {
        dao = new HibeAggregatorDAO();
      } else {
        String castorConfig = config.getServletContext()
            .getResource("/WEB-INF/database.xml").toString();
        dao = new CastorAggregatorDAO(castorConfig);
      }

      Aggregator ag = new AggregatorImpl(dao);
      config.getServletContext().setAttribute("aggregator", ag);

      // Create Actions and hash them away
      mLoginAction = new LoginAction(config.getServletContext());
      mActions.put("/login", mLoginAction);
      mActions.put("/news", new AggregationAction(config
          .getServletContext()));
      mActions.put("/subs", new SubscriptionAction(config
          .getServletContext()));
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException("Error setting up actions", e);
    }
  }
}
