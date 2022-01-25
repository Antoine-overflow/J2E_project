package com.example.servingwebcontent;

import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/manageParticipant")
	public String getUser(Model model) {
		
		return "manageParticipant";
	}

	@GetMapping("/addParticipant")
	public String addparticipant() {
		return "addParticipant";
	}
}
