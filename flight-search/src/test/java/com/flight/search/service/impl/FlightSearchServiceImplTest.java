package com.flight.search.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.flight.model.Flight;
import com.flight.model.Request;

@RunWith(MockitoJUnitRunner.class)
public class FlightSearchServiceImplTest 
{
	private static final String TravelDate = "09-08-2020";
	private static final String DestinationCity = "Odisha";
	private static final String SourceCity = "Banglore";
	@InjectMocks
	private FlightSearchServiceImpl flightSearchServiceImpl;
	
	
	@Test
	public void testSeachFlightsForSortByIsEmpty() throws ParseException
	{
		//then
		List<Flight> flights= flightSearchServiceImpl.seachFlights(buildRequest(null));
		
		//then
		assertEquals("AI-506", flights.get(0).getFlightNumber());
		assertEquals("Air India", flights.get(0).getAirlineName());
		assertEquals("Air India", flights.get(0).getAirlineName());
		assertEquals("SG-905", flights.get(1).getFlightNumber());
		assertEquals("Spicejet", flights.get(1).getAirlineName());
	}
	
	@Test
	public void testSeachFlightsForSortByAirlineName() throws ParseException
	{
		//when
		List<Flight> flights= flightSearchServiceImpl.seachFlights(buildRequest("airlineName"));
		
		//then
		assertEquals("SG-905", flights.get(0).getFlightNumber());
		assertEquals("Spicejet", flights.get(0).getAirlineName());
		assertEquals("AI-506", flights.get(1).getFlightNumber());
		assertEquals("Air India", flights.get(1).getAirlineName());
	}
	
	@Test
	public void testSeachFlightsForSortByPrice() throws ParseException
	{
		//when
		List<Flight> flights= flightSearchServiceImpl.seachFlights(buildRequest("airlineName"));
		
		//then
		assertEquals(6000d, flights.get(0).getPrice());
		assertEquals(5003d, flights.get(1).getPrice());
		
	}

	private Request buildRequest(String sortBy)
	{
		Request request=new Request();
		request.setSourceCity(SourceCity);
		request.setDestinationCity(DestinationCity);
		request.setTravelDate(TravelDate);
		request.setSortBy(sortBy);
		return request;	
	}
}

