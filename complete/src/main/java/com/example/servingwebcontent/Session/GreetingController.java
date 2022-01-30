package com.example.servingwebcontent.Session;


import java.util.List;

import javax.servlet.http.Part;

import com.example.servingwebcontent.Metier.Event;
import com.example.servingwebcontent.Metier.Participant;
import com.example.servingwebcontent.Service.EventService;
import com.example.servingwebcontent.Service.ParticipantService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.bytebuddy.build.Plugin.Engine.Source.Element;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/manageParticipant")
	public String getUser(Model model) {
		ParticipantService service = new ParticipantService();
		List<Participant> participants = service.getAllParticipant();
		model.addAttribute("participants", participants);
		return "manageParticipant";
	}

	@GetMapping("/addParticipant")
	public String addparticipant() {
		return "addParticipant";
	}

	@PostMapping("/saveParticipant")
	public String saveParticipant(@Validated Participant participant, BindingResult result, Model model) {
		participant.displayParticipant();
		ParticipantService service = new ParticipantService();
		long id = service.create(participant);
		System.out.println(id);
		return"redirect:/manageParticipant";
	}

	@GetMapping("/editParticipant")
	public String editParticipant(@RequestParam(name="id", required = true, defaultValue = "0") int id, Model model) {
		ParticipantService service = new ParticipantService();
		Participant participant = service.getParticipantById(id);
		model.addAttribute("participant", participant);
		return "editParticipant";
	}

	@PostMapping("/modifyParticipant")
	public String modifyParticipant(@Validated Participant participant, BindingResult result, Model model) {
		participant.displayParticipant();
		ParticipantService service = new ParticipantService();
		long r = service.update(participant);
		return"redirect:/manageParticipant";
	}

	@GetMapping("/deleteParticipant")
	public String deleteParticipant(@RequestParam(name="id", required = true, defaultValue = "0") int id, Model model) {
		ParticipantService service = new ParticipantService();
		service.deleteParticipant(id);
		return "redirect:/manageParticipant";
	}

	@GetMapping("/manageEvent")
	public String manageEvent(Model model){
		EventService service = new EventService();
		List<Event> events = service.getAllEvent();
		model.addAttribute("events", events);
		return "/manageEvent";
	}

	@GetMapping("/addEvent")
	public String addEvent(Model model){
		return "/addEvent";
	}

	@PostMapping("/saveEvent")
	public String saveEvent (@Validated Event event, BindingResult rsult, Model model) {
		EventService service = new EventService();
		service.create(event);
		return "redirect:/manageEvent";
	}

	@GetMapping("editEvent")
	public String editEvent (@RequestParam(name = "id", required = true, defaultValue = "0") int id, Model model) {
		EventService service = new EventService();
		Event event = service.get(id);
		model.addAttribute("event", event);
		return "/editEvent";
	}

	@GetMapping("deleteEvent")
	public String deleteEvent (@RequestParam(name = "id", required = true, defaultValue = "0") int id, Model model) {
		EventService service = new EventService();
		service.delete(id);
		return "redirect:/manageEvent";
	}

}
