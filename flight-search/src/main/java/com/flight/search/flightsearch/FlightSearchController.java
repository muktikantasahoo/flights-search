package com.flight.search.flightsearch;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.model.Flight;
import com.flight.model.Request;
import com.flight.model.Responce;
import com.flight.search.service.FlightSearchService;


@RestController
@RequestMapping("/flight")
public class FlightSearchController {

	private static final String SORT_BY = "sortBy";

	private static final String RETURN_DATE = "returnDate";

	private static final String TRAVEL_DATE = "travelDate";

	private static final String DESTINATION_CITY = "destinationCity";

	private static final String SOURCE_CITY = "sourceCity";

	private Logger LOGGER = LoggerFactory.getLogger(FlightSearchController.class);

	@Autowired
	private FlightSearchService flightSearchServiceImpl;
	
	

	@GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Responce> searchFlights(@RequestParam(value = SOURCE_CITY, required = true) String sourceCity,
			@RequestParam(value = DESTINATION_CITY, required = true) String destinationCity,
			@RequestParam(value = TRAVEL_DATE, required = true) String travelDate,
			@RequestParam(value = RETURN_DATE, required = false) String returnDate,
			@RequestParam(value = SORT_BY, required = false) String sortBy) throws ParseException {
		LOGGER.info("Flights search started");
		Request request = buildRequest(sourceCity, destinationCity, travelDate, returnDate, sortBy);
		List<Flight> flights = flightSearchServiceImpl.seachFlights(request);
		ResponseEntity<Responce> respoce = new ResponseEntity<Responce>(build(flights), HttpStatus.OK);
		LOGGER.info("SucessFully excuted  and returned StatusCode -{} ", respoce.getStatusCode());
		return respoce;
	}

	private Request buildRequest(final String sourceCity, final String destinationCity, final String travelDate,
			final String returnDate, final String sortBy) {
		Request request = new Request();
		request.setSourceCity(sourceCity);
		request.setDestinationCity(destinationCity);
		request.setTravelDate(travelDate);
		request.setReturnDate(returnDate);
		request.setSortBy(sortBy);
		return request;
	}

	private Responce build(final List<Flight> flights) {
		Responce responce = new Responce();
		if (flights.isEmpty()) {
			return responce;
		}
		responce.setFlights(flights);
		responce.setTotalNumberOfResult(flights.size());
		return responce;
	}

}
