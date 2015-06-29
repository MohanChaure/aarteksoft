package com.aartek.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Vivek, 15/04/2015, LoginController with welcomePage, loginPage and
 *         errorPage
 *
 */
@Controller
public class LoginController {
	/**
	 * show welcome page and redirect according to roles
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("welcome");
		return model;
	}

	/**
	 * Show login page
	 * 
	 * @return
	 */
	@RequestMapping(value = "loginPage", method = RequestMethod.GET)
	public ModelAndView openLoginPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}

	/**
	 * Login method
	 * 
	 * @param error
	 * @param logout
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
					@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
		return model;
	}

	/**
	 * Error message while login
	 * 
	 * @param request
	 * @param key
	 * @return
	 */
	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {
		Exception exception = (Exception) request.getSession().getAttribute(key);
		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}
		return error;
	}

	/**
	 * for access denied page
	 * 
	 * @return
	 */
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
		ModelAndView model = new ModelAndView();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) authentication.getPrincipal();
			model.addObject("userName", userDetail.getUsername());
		}
		model.setViewName("error");
		return model;
	}
}
