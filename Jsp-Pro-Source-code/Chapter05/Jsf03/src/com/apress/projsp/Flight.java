package com.apress.projsp;

public class Flight {
  String flightNum;
  String origination;
  String destination;
  String departDate;
  String departTime;
  String returnDate;
  String returnTime;

  public String getFlightNum() {
    return flightNum;
  }
  public void setFlightNum(String flightNum) {
    this.flightNum = flightNum;
  }
  public String getDepartDate() {
    return departDate;
  }
  public void setDepartDate(String departDate) {
    this.departDate = departDate;
  }
  public String getDepartTime() {
    return departTime;
  }
  public void setDepartTime(String departTime) {
    this.departTime = departTime;
  }
  public String getDestination() {
    return destination;
  }
  public void setDestination(String destination) {
    this.destination = destination;
  }
  public String getOrigination() {
    return origination;
  }
  public void setOrigination(String origination) {
    this.origination = origination;
  }
  public String getReturnDate() {
    return returnDate;
  }
  public void setReturnDate(String returnDate) {
    this.returnDate = returnDate;
  }
  public String getReturnTime() {
    return returnTime;
  }
  public void setReturnTime(String returnTime) {
    this.returnTime = returnTime;
  }
  public String toString() {
    return "Flight " + flightNum + " departing " + origination + " at "
      + departTime + " arriving " + destination + " 2 hours later";
  }
}