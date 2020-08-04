package com.flight.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.flight.dao.FlightSearchDAO;
import com.flight.model.Flight;

@Repository
public class FlightSearchDAOImpl implements FlightSearchDAO {
	@Override
	public List<Flight> findFlights() throws ParseException {
		// i am hardcode all satic data but it should be DB call
		List<Flight> flights = new ArrayList<>();
		Flight flight1 = new Flight("AI-506", "Air India", "Banglore", "Odisha", getDate("08-08-2020 15:00"),
				getDate("31-12-1998 17:00"), "2", "Non stop", 5003d, "09-08-2020");
		Flight flight2 = new Flight("SG-905", "Spicejet", "Banglore", "Odisha", getDate("10-08-2020 15:00"),
				getDate("31-12-1998 17:00"), "3", "Non stop", 6000d, "09-08-2020");
		Flight flight3 = new Flight("G8-113", "Go Air", "Banglore", "Delhi", getDate("09-09-2020 15:00"),
				getDate("31-12-1998 17:00"), "02 hrs 40 mins", "Non stop", 4993d, "09-09-2020");
		flights.add(flight1);
		flights.add(flight2);
		flights.add(flight3);
		return flights;

	}

	private Date getDate(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		return formatter.parse(date);
	}

}
