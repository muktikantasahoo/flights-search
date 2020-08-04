package com.flight.dao;

import java.text.ParseException;
import java.util.List;

import com.flight.model.Flight;

public interface FlightSearchDAO 
{
	public List<Flight> findFlights() throws ParseException;
}
