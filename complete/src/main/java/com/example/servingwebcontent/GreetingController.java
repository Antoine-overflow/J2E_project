package com.example.servingwebcontent;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping("/saveParticipant")
	public String saveParticipant(@Validated Participant participant, BindingResult result, Model model) {
		System.out.println(result);
		participant.displayParticipant();
		return"redirect:/listPersonne";
	}
}
