package com.example.demo.Controller;

import com.example.demo.Graph.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/home/addUser")
	public ModelAndView postDetails(@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		userService.saveDetails(user);
		mv.setViewName("homee");
		return mv;
	}

	@GetMapping("/getUser")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	@RequestMapping("/home")
	public ModelAndView homee(User user) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj",user);
		mv.setViewName("homee");
		return mv;
	}

	@GetMapping("/home/signup")
	public ModelAndView signup(User user){
		ModelAndView mv = new ModelAndView();
		mv.addObject("user",user);
		mv.setViewName("signup");
		return mv;
	}
	@GetMapping("/home/login")
	public ModelAndView login(User user){
		ModelAndView mv = new ModelAndView();
		mv.addObject("user",user);
		mv.setViewName("login");
		return mv;
	}

	@PostMapping("/home/loginCheck")
	public ModelAndView loginCheck(@ModelAttribute("user") User user){
		ModelAndView mv = new ModelAndView();
		if(userService.login(user))
			mv.setViewName("redirect:/user/home/login/home");
		else
			mv.setViewName("homee");
		return mv;
	}
	@GetMapping("/home/login/home")
	public ModelAndView home(Input input){
		ModelAndView mv = new ModelAndView();
		mv.addObject("input",input);
		mv.setViewName("home");
		return mv;
	}

	@PostMapping("/home/login/home/route")
	public ModelAndView route(@ModelAttribute("input") Input input){
		ModelAndView mv = new ModelAndView();
		ArrayList<String> route = userService.shortestPathBetween(input.getCity(),input.getSourceVertex(input.getSource()),input.getDestinationVertex(input.getDestination()));
		mv.addObject("route",route);
		mv.setViewName("route");
		return mv;
	}
}