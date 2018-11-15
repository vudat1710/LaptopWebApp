package com.group14.project.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group14.project.web.beans.User;
import com.group14.project.web.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/viewUsers")
	public String viewUsers() {
		return "viewUsers";
	}
	
	@RequestMapping(value="/searchUser", method=RequestMethod.GET)
	public @ResponseBody String searchUsers(HttpServletRequest request) {
		String ajaxResponse = "";
		ObjectMapper mapper = new ObjectMapper();
		
		String userId= request.getParameter("userId");
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		
		List<User> userList = userService.searchUsersByUserIdUsernameName(userId, username, name);
		
		try {
			ajaxResponse = mapper.writeValueAsString(userList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ajaxResponse;
	}
}
