package spittr.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")

public class SpittleController {

	private SpittleRepository spittleRepository;
	
	@Autowired
	public SpittleController (SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}
	

/*	@RequestMapping(method=RequestMethod.GET)
	public String spittles(Model model) {
		model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
		return "spittles";
	}*/
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Spittle> spittles (
			@RequestParam(value="max") long max, 
			@RequestParam(value="count", defaultValue="20") int count) {
		return spittleRepository.findSpittles(max, count);
	}
	
	@RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
	public String showSpittle(
			@PathVariable("spittleId") long spittleId,
			Model model) throws SpittleNotFoundException {
		Spittle spittle = spittleRepository.findOne(spittleId);
		if (spittle == null)
			throw new SpittleNotFoundException();
		model.addAttribute(spittle);
		return "spittle";
	}
	
	@RequestMapping(value="save", method=RequestMethod.GET)
	public String saveSpittle (Spittle spittle, Model model) {
			spittleRepository.save(spittle);
			return "redirect:/spittles";
	}
	
	@ExceptionHandler(DuplicateSpittleException.class)
	public String handleDuplicateSpittle() {
		return "error/duplicate";
	}
}
