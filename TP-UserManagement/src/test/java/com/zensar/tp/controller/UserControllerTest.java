package com.zensar.tp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.tp.Dto.AuthenticationRequest;
import com.zensar.tp.Dto.Dto;
import com.zensar.tp.Repo.UserRepo;
import com.zensar.tp.service.UserService;
import com.zensar.tp.utils.JwtUtils;


@WebMvcTest(UserController.class)
public class UserControllerTest {
	@Autowired
    MockMvc mockMvc;
@MockBean
UserService usservice;
	

	@Autowired
	AuthenticationManager authenticationManager1;
@MockBean
    UserDetailsService userDetailsService;

   @Autowired
   ObjectMapper objectMapper;
   
//	@Autowired
//	AuthenticationManager authenticationManager;
//   @Test
//	void testUsernameIsNotNull()   {
//	  AuthenticationRequest auth=new AuthenticationRequest("admin","admin123","admin");
//	   
//		String username=auth.getUsername();
//	   Assertions.assertNotNull(username);
//	   
//   }
//   @Test
//	void testpasswordIsNotNull()   {
//	  AuthenticationRequest auth=new AuthenticationRequest("admin","admin123","admin");
//	   
//		String password=auth.getPassword();
//	   Assertions.assertNotNull(password);
//	   
//  }
//   @Test
//   void authi() {
//	   AuthenticationRequest auth=new AuthenticationRequest("admin","admin123","admin");
//	   
//   }
   @MockBean JwtUtils jwtUtils;
   @Test
   public void testgetUserById() throws Exception {
       List<Dto> lis = new ArrayList<Dto>();
       lis.add(new Dto(1,"ash","ruff","pswd1"));
       int val = 18;
       when(this.usservice.getUserById(val)).
           thenReturn((Dto) lis);
       
       MvcResult mvcResult = this.mockMvc.perform(get("http://localhost:8050/home/user/18"))
               .andExpect(status().isOk())
               .andReturn();
       String response = mvcResult.getResponse().getContentAsString();
       assertEquals(response.contains("ash"), true);
       }
   
//   @Test
//   public void testgetAllCategoriesById() throws Exception {
//       List<CategoryDto> categoryDtoList = new ArrayList<CategoryDto>();
//       categoryDtoList.add(new CategoryDto(1,"Spring Boot"));
//       long val = 1;
//       when(this.categoryService.getAllCategoriesById(val)).
//           thenReturn(categoryDtoList);
//       
//       MvcResult mvcResult = this.mockMvc.perform(get("http://localhost:8001/devforum/category/1"))
//               .andExpect(status().isOk())
//               .andReturn();
//       String response = mvcResult.getResponse().getContentAsString();
//       assertEquals(response.contains("Spring Boot"), true);
//   }
   
//   @Test
//   public void test2UserById() throws Exception {
//       Dto dtlist = new Dto();
//    //   dtlist.add(new Dto(1,"ash","ruff","pswd2"));
//       int val = -1;
//       when(this.usservice.getUserById(val)).
//           thenReturn((Dto) dtlist);
//       
//       MvcResult mvcResult = this.mockMvc.perform(get("http://localhost:8050/home/user/1"))
//               .andExpect(status().isOk())
//               .andReturn();
//       String response = mvcResult.getResponse().getContentAsString();
//       assertEquals(response.contains("[]"), true);
//
//}
}
