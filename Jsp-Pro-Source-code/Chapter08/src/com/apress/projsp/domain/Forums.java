package com.apress.projsp.domain;

import java.util.*;

public class Forums {
  private static final Forums instance = new Forums();

  private List forums;

  private Forums() {
    forums = new ArrayList();
    forums.add(new Forum(1, "Servlets"));
    forums.add(new Forum(2, "JSP"));
    forums.add(new Forum(3, "EJB"));
    forums.add(new Forum(4, "JMS"));
  }

  public static Forums getInstance() {
    return instance;
  }

  public Collection getForums() {
    return Collections.unmodifiableCollection(forums);
  }

}