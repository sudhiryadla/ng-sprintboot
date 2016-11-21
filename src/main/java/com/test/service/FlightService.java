package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Flights;
import com.test.repository.MockFlightsGenerator;

@Service
public class FlightService {
	
	@Autowired
	private MockFlightsGenerator mockFlightsGenerator;
	
	public Flights getAllFlights() {
		return mockFlightsGenerator.getAllFlights();
	}
}