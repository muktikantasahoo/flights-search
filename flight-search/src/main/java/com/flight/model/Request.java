package com.flight.model;

public class Request 
{
  private String sourceCity;
  private  String destinationCity;
  private  String travelDate;
  private  String returnDate;
  private String sortBy;
public String getSourceCity() {
	return sourceCity;
}
public void setSourceCity(String sourceCity) {
	this.sourceCity = sourceCity;
}
public String getDestinationCity() {
	return destinationCity;
}
public void setDestinationCity(String destinationCity) {
	this.destinationCity = destinationCity;
}
public String getTravelDate() {
	return travelDate;
}
public void setTravelDate(String travelDate) {
	this.travelDate = travelDate;
}
public String getReturnDate() {
	return returnDate;
}
public void setReturnDate(String returnDate) {
	this.returnDate = returnDate;
}


public String getSortBy() {
	return sortBy;
}
public void setSortBy(String sortBy) {
	this.sortBy = sortBy;
}
@Override
public String toString() {
	return "Request [sourceCity=" + sourceCity + ", destinationCity=" + destinationCity + ", travelDate=" + travelDate
			+ ", returnDate=" + returnDate + ", sort=" + sortBy + "]";
}
   

}
