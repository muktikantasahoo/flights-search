package com.flight.search.flightsearch;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.flight.model.Flight;
import com.flight.model.Responce;
import com.flight.search.service.FlightSearchService;

@RunWith(MockitoJUnitRunner.class)
public class FlightSearchControllerTest {

	private static final String AI_506 = "AI-506";
	@InjectMocks
	private FlightSearchController flightSearchController;
	@Mock
	private FlightSearchService flightSearchServiceImpl;

	@Test
	public void testbuildListIsEmpty() throws ParseException {
		// when
		Responce responce = ReflectionTestUtils.invokeMethod(flightSearchController, "build", new ArrayList<>());

		// then
		assertNotNull(responce);
	}

	@Test
	public void testBuild() throws ParseException {
		// given
		List<Flight> flights = new ArrayList<>();
		Flight flight = new Flight(AI_506, "Air India", "Banglore", "Odisha", new Date(), new Date(), "02 hrs 40 mins",
				"Non stop", 5003d, "09-08-2020");
		flights.add(flight);

		// when
		Responce responce = ReflectionTestUtils.invokeMethod(flightSearchController, "build", flights);

		// then
		assertNotNull(responce);
		assertEquals(AI_506, responce.getFlights().get(0).getFlightNumber());
		assertEquals(1, responce.getTotalNumberOfResult());
	}

}
