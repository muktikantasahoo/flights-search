package com.flight.model;

import java.io.Serializable;
import java.util.List;

public class Responce implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Flight> flights;
	private Integer totalNumberOfResult;
	public List<Flight> getFlights() {
		return flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	public Integer getTotalNumberOfResult() {
		return totalNumberOfResult;
	}
	public void setTotalNumberOfResult(Integer totalNumberOfResult) {
		this.totalNumberOfResult = totalNumberOfResult;
	}
	
	
}
