package com.booking.app.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.booking.app.config.Constants;
import com.booking.app.dto.User;
import com.booking.app.service.UserService;
import com.booking.app.util.AuthenticationRequest;

@Controller
public class AuthenticationController
{
	@Autowired
	 private UserService userService;
	
	//there will be two methods for sign operation
	//one method will display
	//sign page
	//other method will get the authentication data

	//this method will display the signIn

	@RequestMapping("/displaySignInPage")
	String signInPageMethod()
	{
		return "signInPage";
	}
     
	@RequestMapping("/search")
	String searchTrains()
	{
		return "searchTrain";
	}
	//this will recieved data
	//@RequestParam
	//@PathVariables
	//objects
	

	@RequestMapping(value ="/signIn" ,method=RequestMethod.POST)
	String signIn(AuthenticationRequest request ,HttpServletResponse resp ,HttpSession httpSession )
	{
		System.out.println("login info :"+request);
		
		User userFromDB =userService
				.findUserByEmailOrMobileNoOrUserName(request.getLoginCredentials());
		
		System.out.println("userFromDB ->"+userFromDB);
		//logic for Authentication
		if(userFromDB !=null
				&& !request.getPassword().equals(userFromDB.getPassword())){
			return "signInPage";
		}
		
	    //adding cookies after verified
		Cookie userNameCookie =new Cookie("user",request.getLoginCredentials());
		userNameCookie.setMaxAge(24*60*60);
		resp.addCookie(userNameCookie);
		
		//before adding password into cookie hash the password
		Cookie passwordCookie =new Cookie("password",request.getPassword());
		passwordCookie.setMaxAge(24*60*60);
		resp.addCookie(passwordCookie);

		httpSession.setAttribute("userData", userFromDB);
		
		//logic for Authorization
		if(userFromDB !=null && userFromDB.getRole().equals(Constants.ROLE_ADMIN))
		{ 
			return "adminDashboardPage";
		}
		if(userFromDB !=null && userFromDB.getRole().equals(Constants.ROLE_USER))
		{
			return "userDashboardPage";
		}
		return "signInPage";
	}
	
	
	@RequestMapping("/logoutPage")
	public String logoutPage()
	{
		return "logoutPage";
	}
	
	
	
	@RequestMapping("/logout/{value}")
	public String logoutPage(@PathVariable String value, HttpServletRequest request,
			HttpServletResponse resp,HttpSession httpSession)
	{
		if("yes".equalsIgnoreCase(value))
		{
			System.out.println("-------into logout yes--------");
			//delete httpSession object
			httpSession.removeAttribute("userData");
			
			//delete cookies 
			Cookie userNameCookie =new Cookie("user","");
			userNameCookie.setMaxAge(0);
			userNameCookie.setPath("/TrainBooking");
			resp.addCookie(userNameCookie);
			
			Cookie passwordCookie =new Cookie("password","");
			passwordCookie.setMaxAge(0);
			passwordCookie.setPath("/TrainBooking");
			resp.addCookie(passwordCookie);
			
		}else{
			return "redirect: /TrainBooking";
		}
		return "redirect: /TrainBooking";
	}
}  
