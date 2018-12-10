package com.apress.projsp;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.faces.context.FacesContext;

public class FlightSearch {
  Airport origination;
  Airport destination;
  Date departDate;
  String departTime;
  Date returnDate;
  String returnTime;
  String tripType;
  ArrayList matchingFlights = new ArrayList();
	String flightNum;
  Flight matchingFlight;
  public Date getDepartDate() {
    return departDate;
  }
  public void setDepartDate(Date departDate) {
    this.departDate = departDate;
    ((Flight) matchingFlights.get(0)).setDepartDate(departDate);
    ((Flight) matchingFlights.get(1)).setDepartDate(departDate);
  }
  public String getDepartTime() {
    return departTime;
  }
  public void setDepartTime(String departTime) {
    this.departTime = departTime;
    ((Flight) matchingFlights.get(0)).setDepartTime(departTime);
    ((Flight) matchingFlights.get(1)).setDepartTime(departTime);
  }
  public Airport getDestination() {
    return destination;
  }
  public void setDestination(Airport destination) {
    this.destination = destination;
    ((Flight) matchingFlights.get(0)).setDestination(destination);
    ((Flight) matchingFlights.get(1)).setDestination(destination);
    ((Flight) matchingFlights.get(0)).setFlightNum("133");
    ((Flight) matchingFlights.get(1)).setFlightNum("233");
  }
  public Airport getOrigination() {
    return origination;
  }
  public void setOrigination(Airport origination) {
    this.origination = origination;
    ((Flight) matchingFlights.get(0)).setOrigination(origination);
    ((Flight) matchingFlights.get(1)).setOrigination(origination);
  }
  public Date getReturnDate() {
    return returnDate;
  }
  public void setReturnDate(Date returnDate) {
    this.returnDate = returnDate;
    ((Flight) matchingFlights.get(0)).setReturnDate(returnDate);
    ((Flight) matchingFlights.get(1)).setReturnDate(returnDate);
  }
  public String getReturnTime() {
    return returnTime;
  }
  public void setReturnTime(String returnTime) {
    this.returnTime = returnTime;
    ((Flight) matchingFlights.get(0)).setReturnTime(returnTime);
    ((Flight) matchingFlights.get(1)).setReturnTime(returnTime);
  }
  public String getTripType() {
    return tripType;
  }
  public void setTripType(String tripType) {
    this.tripType = tripType;
  }
  public List getMatchingFlights() {
    return matchingFlights;
  }
  public void setMatchingFlights(List matchingFlights) {
    this.matchingFlights.addAll(matchingFlights);
  }
  public String reset() {
    this.setDepartDate(null);
    this.setDepartTime("");
    this.setDestination(null);
    this.setOrigination(null);
    this.setReturnDate(null);
    this.setReturnTime("");
    this.setTripType("");
    return "success";
  }
  public String search() {
    if (origination.code.equals("BOS") && 
        destination.code.equals("ORD")) {
      return "success";
    } else {
      return "no flights";
    }
  }
  public Flight getMatchingFlight() {
    for (int i = 0; i < matchingFlights.size(); i++) {
      matchingFlight = (Flight) matchingFlights.get(i);
      if (matchingFlight.flightNum.equals(flightNum)) {
        break;
      }
      matchingFlight = null;
    }
    return matchingFlight;
  }
  public void setMatchingFlight(Flight flight) {
    matchingFlight = flight;
  }
  public String getFlightNum() {
    return flightNum;
  }
  public void setFlightNum(String string) {
    flightNum = string;
  }
  public String select() {
    FacesContext context = FacesContext.getCurrentInstance();
    Map requestParams =
      context.getExternalContext().getRequestParameterMap();
    flightNum = (String) requestParams.get("flightNum");
    return "select";
  }
}