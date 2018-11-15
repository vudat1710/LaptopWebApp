package com.group14.project.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group14.project.web.beans.Authority;
import com.group14.project.web.beans.Gender;
import com.group14.project.web.beans.User;
import com.group14.project.web.service.UserService;

@Controller
public class UserController {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public @ResponseBody String register(HttpServletRequest request) {
		String ajaxResponse = "";
		ObjectMapper mapper = new ObjectMapper();
		
		String username = request.getParameter("username");
		System.out.println(username);
		boolean flag = userService.isUsernameExisted(username);
		System.out.println(flag);
		if(flag) {
			try {
				ajaxResponse = mapper.writeValueAsString(Boolean.FALSE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			Date birthDate = null;
			try {
				birthDate = dateFormat.parse(request.getParameter("birthDate"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Gender gender = Gender.valueOf(request.getParameter("gender"));
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			Authority authority = Authority.ROLE_USER;
			
			User user = new User(username, password, name, email, birthDate, gender, address, phone, authority);
			userService.addUser(user);
			
			try {
				ajaxResponse = mapper.writeValueAsString(Boolean.TRUE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ajaxResponse;
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
}
