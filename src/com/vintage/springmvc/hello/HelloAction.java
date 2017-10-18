package com.vintage.springmvc.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloAction implements Controller {

	public HelloAction() {
		System.out.println("HelloAction.HelloAction()");
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("HelloAction.handleRequest()");
		ModelAndView modelAndView = new ModelAndView();
		// Model
		modelAndView.addObject("message", "com.vintage.springmvc.hello.HelloAction");
		// View
		// modelAndView.setViewName("/jsp/index.jsp");
		modelAndView.setViewName("index");
		return modelAndView;
	}

}
