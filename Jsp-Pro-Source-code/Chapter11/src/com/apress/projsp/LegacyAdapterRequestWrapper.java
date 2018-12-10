package com.apress.projsp;

import java.util.Map;
import javax.servlet.http.*;

public class LegacyAdapterRequestWrapper extends HttpServletRequestWrapper {
  String myDept = null;

  public LegacyAdapterRequestWrapper(HttpServletRequest inReq, String deptString) {
    super(inReq);
    myDept = deptString;
  }

  public Map getParameterMap() {
    Map tmpMap = super.getParameterMap();
    tmpMap.put("DEPT", myDept);
    return tmpMap;
  }

  public String[] getParameterValues(String paramName) {
    if (paramName.equalsIgnoreCase("DEPT")) {
      String[] tpAry = new String[1];
      tpAry[0] = myDept;
      return tpAry;
    } else {
      return super.getParameterValues(paramName);
    }
  }

  public String getParameter(String paramName) {
    if (paramName.equalsIgnoreCase("DEPT")) {
      return myDept;
    } else {
      return super.getParameter(paramName);
    }
  }
}
