package com.apress.projsp;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class AirportConverter implements Converter {
  public Object getAsObject(
    FacesContext ctxt,
    UIComponent comp,
    String value) {
    Airport airport = null;
    if (value.equals("BOS")) {
      airport = new Airport("BOS", "Logan International Airport");
    }
    if (value.equals("ORD")) {
      airport = new Airport("ORD", "O'Hare International Airport");
    }
    if (airport == null) {
      FacesMessage message =
        new FacesMessage(
          FacesMessage.SEVERITY_ERROR,
          "UnrecognizedAirportCode",
          "Airport code " + value + " is not recognized");
      throw new ConverterException(message);
    }
    return airport;
  }
  public String getAsString(
    FacesContext ctxt,
    UIComponent comp,
    Object obj) {
    return obj.toString();
  }
}
