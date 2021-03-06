package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;

import javax.validation.Valid;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private SpitterRepository spitterRepository;
	
	@Autowired
	public SpitterController(SpitterRepository spitterRepository) {
		// TODO Auto-generated constructor stub
		this.spitterRepository = spitterRepository;
	}

	public SpitterController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value="/register", method=GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute(new Spitter());
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=POST)
	public String processRegistration(
			//@RequestPart("profilePicture") MultipartFile profilePicture,
			@Valid Spitter spitter, Errors errors, Model model) throws IllegalStateException, IOException {
		if (errors.hasErrors())
			return "registerForm";
		
		//profilePicture.transferTo(new File("/data/spittr/" + profilePicture.getOriginalFilename()));
		spitterRepository.addSpitter(spitter);
		/*return "redirect:/spitter/" + spitter.getUsername();*/
		model.addAttribute("username", spitter.getUsername());
		return "redirect:/spitter/{username}";
	}
	
	@RequestMapping(value="/{username}", method=GET)
	public String showSpitterProfile(
			@PathVariable String username, Model model) {
		Spitter spitter = spitterRepository.findByUsername(username);
		model.addAttribute(spitter);
		return "profile";
	}
}
