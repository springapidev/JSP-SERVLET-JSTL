package com.apress.projsp;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

public class IteratorTagExtraInfo extends TagExtraInfo {
  public VariableInfo[] getVariableInfo(TagData data) {
    return new VariableInfo[] { new VariableInfo(data.getId(), data
        .getAttributeString("type"), true, VariableInfo.NESTED) };
  }
}