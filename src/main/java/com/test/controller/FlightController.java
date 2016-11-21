package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Flights;
import com.test.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@RequestMapping(value="/flights", method = RequestMethod.GET)
	public Flights getAllFlights() {
		return flightService.getAllFlights();
	}

}
