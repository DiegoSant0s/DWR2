package br.com.dwr2.seguroAutomotivo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SeguradoController {

	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
}
