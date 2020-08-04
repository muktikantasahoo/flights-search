package com.flight.model;

import java.util.Comparator;
import java.util.Date;

public class Flight 
{
	
	private String flightNumber ;
	private String airlineName;
	private String sourceCity;
	private String destinationCity;
	private Date departureDate;
	private Date arrivalDate;
	private String duration;
	private String noOfStop;
	private Double price;
	private String travelDate;
	
	
	
	
	
	public Flight(String flightNumber, String airlineName, String sourceCity, String destinationCity,
			Date departureDate, Date arrivalDate, String duration, String noOfStop, Double price, String travelDate) {
		super();
		this.flightNumber = flightNumber;
		this.airlineName = airlineName;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.duration = duration;
		this.noOfStop = noOfStop;
		this.price = price;
		this.travelDate = travelDate;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getNoOfStop() {
		return noOfStop;
	}

	public void setNoOfStop(String noOfStop) {
		this.noOfStop = noOfStop;
	}


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


	public static Comparator<Flight> AirlineNameComparator = new Comparator<Flight>() {
		public int compare(Flight o1, Flight o2) {
			String airlineName1 = o1.getAirlineName().toUpperCase();
			   String StudentName2 = o2.getAirlineName().toUpperCase();
			 return StudentName2.compareTo(airlineName1);
		}};
		
	public static Comparator<Flight> priceComparator = new Comparator<Flight>() {
		public int compare(Flight o1, Flight o2) {
			if (o2.getPrice() > o1.getPrice()) {
				return 1;
			} else if (o2.getPrice() == o1.getPrice()) {
				return 0;
			}

			return -1;
		}
	};
	
	public static Comparator<Flight> departureDateComparator = new Comparator<Flight>() {
		public int compare(Flight o1, Flight o2) {
			if (o2.getDepartureDate().before(o1.getDepartureDate()) ) {
				return -1;
			} else if (o2.getDepartureDate().equals(o1.getDepartureDate())) {
				return 0;
			}

			return 1;
		}
	};
	
	public static Comparator<Flight> durationComparator = new Comparator<Flight>() {
		public int compare(Flight o1, Flight o2) {
			return o2.getDuration().compareTo(o1.getDuration());
		}
	};

}
