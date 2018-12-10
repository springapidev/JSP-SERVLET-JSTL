package com.apress.projsp.store;

import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class CartAction implements Action {

  public String process(HttpServletRequest request, HttpServletResponse response)
      throws ServletException {

    //  Check to see if we are adding to the cart or
    //  if we want to dispay the cart
    String adding = request.getParameter("add");

    //  Get the cart if it exists
    HttpSession session = request.getSession();

    Cart cart = (Cart) session.getAttribute("cart");

    if (cart == null) {
      cart = new Cart();
    }

    if (adding.equalsIgnoreCase("true")) {
      //  Add to it
      addToCart(request, cart);
    }

    return "/cart.jsp";

  }

  private void addToCart(HttpServletRequest request, Cart cart)
      throws ItemAlreadyAddedException {
    //  Get the item to add from the request

    //  Get the products from the servletcontext
    HashMap products = (HashMap) request.getSession().getServletContext()
        .getAttribute("products");

    //  Find the one represented by the ID that we passed in
    try {
      String id = request.getParameter("id");

      Product p = (Product) products.get(id);

      //  Add it to the cart
      cart.addItem(p);
      //  add the cart to the session
      request.getSession().setAttribute("cart", cart);

    } catch (NumberFormatException nfe) {
      throw new ItemAlreadyAddedException();
    }
  }

}