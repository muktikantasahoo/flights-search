package com.flight.search.service;

import java.text.ParseException;
import java.util.List;

import com.flight.model.Flight;
import com.flight.model.Request;

public interface FlightSearchService 
{
	 List<Flight> seachFlights(Request request) throws ParseException;
}
