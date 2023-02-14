//package com.cognixia.jump.controller;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verifyNoMoreInteractions;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.cognixia.jump.model.UserApp;
//import com.cognixia.jump.repository.UserAppRepository;
//import com.cognixia.jump.service.MyUserDetailsService;
//import com.cognixia.jump.util.JwtUtil;
//
//
////@WebMvcTest(UserAppController.class)
////@AutoConfigureMockMvc(addFilters = false)
//@WebMvcTest(controllers = UserAppController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
//public class UserAppControllerTest {
//	
//	private static final String STARTING_URI = "http://localhost:8080/api";
//	
//	public static enum Role {
//		ROLE_USER, ROLE_ADMIN	// roles should start with capital ROLE_ and has to be completely in capital letters
//	}
//	
//	// mocking the request/response
//	@Autowired
//	private MockMvc mvc;
//	
//	// mock the method calls for the service
//	// we decide what data gets returned from the service methods instead
//	@MockBean
//	private UserAppRepository repo;
//	
//	// when the controller tries to autowire the service,
//	// mock the creation of the service
//	@InjectMocks
//	private UserAppController controller;
//	
//	@MockBean
//	private MyUserDetailsService myUserDetailsService;
//	
//	@MockBean
//	private JwtUtil JwtUtil;
//	
//	
//	@Test
//	public void testGetUsers() throws Exception {
//		
//		String uri = STARTING_URI + "/users";
//		
//		List<UserApp> allUsers = new ArrayList<UserApp>();
//		// init the users later
//		allUsers.add(new UserApp(1, "ayden", "abad", "ayden333", "123", true));
//		allUsers.add(new UserApp(2, "charina", "abapo", "cabapo", "123", true));
//		
//		when( repo.findAll() ).thenReturn(allUsers);
//		
//		mvc.perform( get(uri) )   // perform get request
//		.andDo( print() ) // print request sent/response given
//		.andExpect( status().isOk() ) // expect a 200 status code
//		.andExpect( content().contentType( MediaType.APPLICATION_JSON_VALUE ) ) // checks content type is json
//		.andExpect( jsonPath( "$.length()" ).value( allUsers.size() ) ) // length of the list matches one above
//		.andExpect( jsonPath("$[0].id").value(allUsers.get(0).getUser_id()) ) // check each column value for the cars in list
//		.andExpect( jsonPath("$[0].firstName").value(allUsers.get(0).getF_name() ) )
//		.andExpect( jsonPath("$[0].lastName").value(allUsers.get(0).getL_name() ) )
//		.andExpect( jsonPath("$[0].email").value(allUsers.get(0).getUsername() ) )
//		.andExpect( jsonPath("$[0].gpa").value(allUsers.get(0).getUser_pwd() ) )
//		.andExpect( jsonPath("$[1].id").value(allUsers.get(1).getUser_id()) ) // check each column value for the cars in list
//		.andExpect( jsonPath("$[1].firstName").value(allUsers.get(1).getF_name() ) )
//		.andExpect( jsonPath("$[1].lastName").value(allUsers.get(1).getL_name() ) )
//		.andExpect( jsonPath("$[1].email").value(allUsers.get(1).getUsername() ) )
//		.andExpect( jsonPath("$[1].gpa").value(allUsers.get(1).getUser_pwd() ) );
//		
//		verify( repo, times(1) ).findAll(); // getStudents() from service called once
//		verifyNoMoreInteractions( repo ); // after checking above, service is no longer called
//		
//	}
//	
//	@Test
//	public void testPostUser() throws Exception {
//		
//		String uri = STARTING_URI + "/user";
//		
//		UserApp user = new UserApp(1, "ayden", "abad", "ayden333", "123", true);
//		
//		when( repo.save( Mockito.any(UserApp.class) ) ).thenReturn(user);
//		
//		mvc.perform( post(uri)
//				.content( user.toJson() ) // data sent in body NEEDS to be in JSON format
//				.contentType(MediaType.APPLICATION_JSON_VALUE) )
//		.andDo( print() )
//		.andExpect( status().isCreated() )
//		.andExpect( content().contentType( MediaType.APPLICATION_JSON_VALUE ) );
//		
//	}
	
	
	
}


















////	@Test
////	public void testGetUsers() throws Exception {
////		
////		String uri = STARTING_URI + "/users";
////		
////		List<UserApp> allUsers = new ArrayList<UserApp>();
////		// init the users later
////		allUsers.add(new UserApp(1, "ayden", "abad", "ayden333", "123", true));
////		allUsers.add(new UserApp(2, "charina", "abapo", "cabapo", "123", true));
////		
////		when( repo.findAll() ).thenReturn(allUsers);
////		
////		mvc.perform( get(uri) )   // perform get request
////		.andDo( print() ) // print request sent/response given
////		.andExpect( status().isOk() ) // expect a 200 status code
////		.andExpect( content().contentType( MediaType.APPLICATION_JSON_VALUE ) ) // checks content type is json
////		.andExpect( jsonPath( "$.length()" ).value( allUsers.size() ) ); // length of the list matches one above
////		
////		verify( repo, times(1) ).findAll(); // getStudents() from service called once
////		verifyNoMoreInteractions( repo ); // after checking above, service is no longer called
////		
////	}
////	
////	@Test
////	public void testPostUser() throws Exception {
////		
////		String uri = STARTING_URI + "/user";
////		
////		UserApp user = new UserApp(1, "ayden", "abad", "ayden333", "123", true);
////		
////		when( repo.save( Mockito.any(UserApp.class) ) ).thenReturn(user);
////		
////		mvc.perform( post(uri)
////				.content( user.toJson() ) // data sent in body NEEDS to be in JSON format
////				.contentType(MediaType.APPLICATION_JSON_VALUE) )
////		.andDo( print() )
////		.andExpect( status().isCreated() )
////		.andExpect( content().contentType( MediaType.APPLICATION_JSON_VALUE ) );
////		
////	}
//	
//	
//	
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
