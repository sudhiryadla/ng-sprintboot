package com.test;

import static org.junit.Assert.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

 
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.test.controller.FlightController;
import com.test.model.Flight;
import com.test.model.Flights;
import com.test.repository.MockFlightsGenerator;
import com.test.service.FlightService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class FlightTests {

    @Autowired
    private TestRestTemplate restTemplate;
	
    @MockBean
    private FlightService flightService;
    
    @Autowired
    private MockFlightsGenerator mockFlightsGenerator;
	
    @Before
    public void setup() {
        when(this.flightService.getAllFlights()).thenReturn(mockFlightsGenerator.getAllFlights());
    }

    @Test
    public void test() {
        ResponseEntity<Flights> responseEntity = this.restTemplate.getForEntity("/flights", 
            Flights.class);
        Assert.assertTrue(responseEntity.getHeaders().getContentType().equals(MediaType.APPLICATION_JSON_UTF8));
        Assert.assertTrue(responseEntity.getStatusCode().equals(HttpStatus.OK));
    }
    

}
