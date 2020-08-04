package com.flight.search.service.impl;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flight.dao.FlightSearchDAO;
import com.flight.model.Flight;
import com.flight.model.Request;
import com.flight.search.service.FlightSearchService;

@Service
public class FlightSearchServiceImpl implements FlightSearchService {

	private static final String PRICE = "price";
	private static final String DURATION = "duration";
	private static final String DEPARTURE_DATE = "departureDate";
	private static final String AIRLINE_NAME = "airlineName";

	@Autowired
	private FlightSearchDAO flightSearchDAOImpl;
	
	
	@Override
	public List<Flight> seachFlights(final Request request) throws ParseException {

		// Here DAO call
		List<Flight> flights = flightSearchDAOImpl.findFlights();
		flights=flights.stream().filter(flight -> (flight.getSourceCity().trim().equalsIgnoreCase(request.getSourceCity().trim()))
				&& (flight.getDestinationCity().trim().equalsIgnoreCase(request.getDestinationCity().trim())
				&&  (flight.getTravelDate().equals(request.getTravelDate()))
				)).collect(Collectors.toList());
		return request.getSortBy()== null ? flights : sort(request.getSortBy(), flights);
	}

	public List<Flight> sort(final String soryBy, List<Flight> flights) {
		switch (soryBy) {
		case AIRLINE_NAME:
			Collections.sort(flights, Flight.AirlineNameComparator);
			break;
		case DEPARTURE_DATE:
			Collections.sort(flights, Flight.departureDateComparator);
			break;
		case DURATION:
			Collections.sort(flights, Flight.durationComparator);
			break;
		case PRICE:
			Collections.sort(flights, Flight.priceComparator);
			break;

		}
		return flights;
	}

}
