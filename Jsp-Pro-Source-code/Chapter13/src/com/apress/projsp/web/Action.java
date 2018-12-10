package com.apress.projsp.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Action handler interface used by Controller, implemented by Actions.
 */
public interface Action {
    public void doGet(HttpServletRequest req, HttpServletResponse res);
}
