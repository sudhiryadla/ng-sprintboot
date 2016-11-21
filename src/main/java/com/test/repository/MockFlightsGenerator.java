package com.test.repository;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.model.Flights;

@Component
public class MockFlightsGenerator {

	public Flights getAllFlights() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Flights flights = mapper.readValue(getClass().getResourceAsStream("/input.json"), Flights.class);
			return flights;
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
}
