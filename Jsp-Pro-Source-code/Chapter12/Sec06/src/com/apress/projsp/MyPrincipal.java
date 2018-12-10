package com.apress.projsp;

public class MyPrincipal implements java.security.Principal {
  String m_Name = new String("");

  public MyPrincipal(String name) {
    m_Name = name;
  }

  public boolean equals(Object another) {
    try {
      MyPrincipal pm = (MyPrincipal) another;
      return pm.m_Name.equalsIgnoreCase(m_Name);
    } catch (Exception e) {
      return false;
    }
  }

  public String getName() {
    return m_Name;
  }

  public int hashCode() {
    return m_Name.hashCode();
  }

  public String toString() {
    return m_Name;
  }
}