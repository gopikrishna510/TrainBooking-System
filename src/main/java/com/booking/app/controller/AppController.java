package com.booking.app.controller;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.booking.app.config.Constants;
import com.booking.app.dto.User;
import com.booking.app.service.UserService;

@Controller
public class AppController 
{
	@Autowired
	private UserService userService;
	@RequestMapping("/")
	String entryPoint(HttpServletRequest request,HttpServletResponse response)
	{
		String userCred= "";
		String password= ""; 

		HttpSession httpSession = request.getSession();
		User userFromSession =(User)httpSession.getAttribute("userData");
		System.out.println(userFromSession);



		if(userFromSession!=null)
		{
			if(userFromSession !=null && userFromSession.getRole().equals(Constants.ROLE_ADMIN))
			{
				return "adminDashboardPage";
			}
			else if(userFromSession !=null && userFromSession.getRole().equals(Constants.ROLE_USER))
			{
				return "userDashboardPage";
			}
		}
		else
		{
			Cookie[] cookies=request.getCookies();
			if(cookies !=null)
			{
				for(Cookie cookie : cookies)
				{
					if(cookie.getName().equals("user")){
						userCred = cookie.getValue();
					}else if(cookie.getName().equals("password")){
						password = cookie.getValue();
					}
				}
			}
				
			System.out.println(userCred+"-----"+password);
			if(userCred.length() > 0 && password.length() > 0)
			{
				System.out.println("inside the if of for db");
				
				//get the object from db and check for authentication and authorization
				User userFromDB =userService.findUserByEmailOrMobileNoOrUserName(userCred);
				
				httpSession.setAttribute("userData", userFromDB);
				if(userFromDB !=null && userFromDB.getRole().equals(Constants.ROLE_ADMIN))
				{
					return "adminDashboardPage";
				}
				else if(userFromDB !=null && userFromDB.getRole().equals(Constants.ROLE_USER))
				{
					return "userDashboardPage";
				}
			}
			
			return "index1";
			
		}
		
		//		Cookie[] cookies = request.getCookies();
		//		for(Cookie cookie : cookies)
		//		{
		//			System.out.println(cookie.getName()+" "+cookie.getValue());
		//		}
		//		
		//		String name=cookies[0].getName();
		//		System.out.println(name);

		//get object from db and check for authentication and authorization
		/*if(userCred.length() > 0 && password.length() > 0)
		{
			User userFromDB =userService.findUserByEmailOrMobileNoOrUserName(userCred);
			if(userFromDB !=null && userFromDB.getRole().equals(Constants.ROLE_ADMIN))
			{
				return "adminDashboardPage";
			}
			else if(userFromDB !=null && userFromDB.getRole().equals(Constants.ROLE_USER))
			{
				return "userDashboardPage";
			}
		}*/
		System.out.println("Entry point ");
		return "index1";
	}
}	
