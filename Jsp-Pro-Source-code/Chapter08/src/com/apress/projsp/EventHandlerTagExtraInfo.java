package com.apress.projsp;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.jsp.tagext.*;

public class EventHandlerTagExtraInfo extends TagExtraInfo {
  private static List EVENT_HANDLERS = new ArrayList();
  static {
    // here is a list of the valid event handlers for the select tag
    EVENT_HANDLERS.add("onblur");
    EVENT_HANDLERS.add("onchange");
    EVENT_HANDLERS.add("onclick");
    EVENT_HANDLERS.add("ondblclick");
    EVENT_HANDLERS.add("onfocus");
    EVENT_HANDLERS.add("onkeydown");
    EVENT_HANDLERS.add("onkeypress");
    EVENT_HANDLERS.add("onkeyup");
    EVENT_HANDLERS.add("onmousedown");
    EVENT_HANDLERS.add("onmousemove");
    EVENT_HANDLERS.add("onmouseout");
    EVENT_HANDLERS.add("onmouseover");
    EVENT_HANDLERS.add("onmouseup");
  }

  public ValidationMessage[] validate(TagData data) {
    String name = data.getAttributeString("name");
    // validate that the name is valid
    if (!EVENT_HANDLERS.contains(name.toLowerCase())) {
      return new ValidationMessage[] { new ValidationMessage(null,
          "Event handler called " + name + " not valid") };
    } else {
      return null;
    }
  }
}