package com.cognixia.jump.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Exercise;
import com.cognixia.jump.model.UserApp;
import com.cognixia.jump.model.WorkoutSession;
import com.cognixia.jump.repository.WorkoutSessionRepository;
import com.cognixia.jump.service.MyUserDetailsService;
import com.cognixia.jump.service.WorkoutSessionService;
import com.cognixia.jump.util.JwtUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = WorkoutSessionController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class WorkoutSessionControllerTest {
	private static final String STARTING_URI = "http://localhost:8080/api";
	public static enum Role {
		ROLE_USER, ROLE_ADMIN	// roles should start with capital ROLE_ and has to be completely in capital letters
	}
	
	// mocking the request/response
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private WorkoutSessionService service;
	
	// mock the method calls for the service
	// we decide what data gets returned from the service methods instead
	@MockBean
	private WorkoutSessionRepository repo;
	
	// when the controller tries to autowire the service,
	// mock the creation of the service
	@InjectMocks
	private WorkoutSessionController controller;
	
	@MockBean
	private MyUserDetailsService myUserDetailsService;
	
	@MockBean
	private JwtUtil JwtUtil;
	
	@Test
	public void getAllWorkoutSessions() throws Exception {
		
		String uri = STARTING_URI + "/workout";
		
		List<WorkoutSession> allSessions = new ArrayList<WorkoutSession>();
		
		// init
		WorkoutSession sessionOne = new WorkoutSession();
		WorkoutSession sessionTwo = new WorkoutSession();
		
		when( repo.findAll( ) ).thenReturn(allSessions);
		
		mvc.perform( get(uri) )   // perform get request
		.andDo( print() ) // print request sent/response given
		.andExpect( status().isOk() ) // expect a 200 status code
		.andExpect( jsonPath( "$.length()" ).value( allSessions.size() ) ); // length of the list matches one above
		
		
		verify( repo, times(1) ).findAll(); // getStudents() from service called once
		verifyNoMoreInteractions( repo ); // after checking above, service is no longer called
	}
	
	@Test
	public void addWorkout() throws Exception {
		
		String uri = STARTING_URI + "/workout";
		
		// init
		WorkoutSession sessionOne = new WorkoutSession(1, new UserApp(), new Date(0), new Time(0), 50, new Exercise());
		
		when( repo.save( Mockito.any(WorkoutSession.class) ) ).thenReturn(sessionOne);
		
		mvc.perform( post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content( asJsonString(sessionOne) )) // data sent in body NEEDS to be in JSON format
		.andDo( print() )
		.andExpect( status().isCreated() )
		.andExpect( (ResultMatcher) content().contentType( MediaType.APPLICATION_JSON_VALUE ) );
		
		verify( repo, times(1) ).save(Mockito.any(WorkoutSession.class)); // getStudents() from service called once
		verifyNoMoreInteractions( repo ); // after checking above, service is no longer called
		
		
	}
	
	@Test
	void testDeleteStudent() throws Exception {
		
		String uri = STARTING_URI + "/workout/{id}";		
		int id = 1;
		
		WorkoutSession sessionOne = new WorkoutSession(id, new UserApp(), new Date(0), new Time(0), 50, new Exercise());
				
		when( service.deleteSession(id) ).thenReturn(true);		
		
		mvc.perform( delete(uri, id) )
				.andDo( print() )
				.andExpect( status().isOk() );
				// can do more tests to make sure json data formatted properly
		
		verify( service, times(1) ).deleteSession(id);
		verifyNoMoreInteractions(service);
	}
	
	@Test
	public void deleteWorkoutNotFound() throws Exception {
		
		String uri = STARTING_URI + "/workout/{id}";		
		int id = 6;
		
		when(service.deleteSession(id)).thenReturn( false );
		
		mvc.perform( delete(uri, id) )
		.andDo( print() )
		.andExpect( status().isOk() );
		
		verify( service, times(1) ).deleteSession(id);
		verifyNoMoreInteractions(service);
		
	}
	
	
	@Test
	void testUpdateWorkoutSession() throws Exception {
		String uri = STARTING_URI + "/workout/update";
		
		int id = 1;
		WorkoutSession sessionOne = new WorkoutSession(id, new UserApp(), new Date(0), new Time(0), 50, new Exercise());		
		
		when( service.updateSession( Mockito.any(WorkoutSession.class) ) ) .thenReturn(sessionOne);
		
		mvc.perform( put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content( asJsonString(sessionOne )))
		.andDo( print() )
		.andExpect( status().isOk() );
		
		verify( service, times(1) ).updateSession(Mockito.any(WorkoutSession.class));
		verifyNoMoreInteractions(service);
	}
	
	
	
	// converts any object to a JSON string
	public static String asJsonString(final Object obj) {
		
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	
	
}


