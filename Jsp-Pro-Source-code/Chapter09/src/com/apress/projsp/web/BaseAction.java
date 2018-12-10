package com.apress.projsp.web;

import com.apress.projsp.Aggregator;

import javax.servlet.ServletContext;


/**
 * Base Action implementation extended by all Actions.
 */
public abstract class BaseAction implements Action {
    protected ServletContext mContext = null;
    protected Aggregator mAggregator = null;

    public BaseAction(ServletContext ctx) throws Exception {
        mContext = ctx;
        mAggregator = (Aggregator) mContext.getAttribute("aggregator");
    }
}
