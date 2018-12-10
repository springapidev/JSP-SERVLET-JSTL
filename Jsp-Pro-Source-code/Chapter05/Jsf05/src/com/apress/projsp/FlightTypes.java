package com.apress.projsp;

import javax.faces.model.SelectItem;

public class FlightTypes {
  static SelectItem[] tripTypes = new SelectItem[] {
      new SelectItem("Roundtrip", "Roundtrip"),
      new SelectItem("One way", "One way") };
 
  public SelectItem[] getTripTypes() {
    return tripTypes;
  }
  public void setTripTypes(SelectItem[] tripTypes) {
    FlightTypes.tripTypes = tripTypes;
  }
}
