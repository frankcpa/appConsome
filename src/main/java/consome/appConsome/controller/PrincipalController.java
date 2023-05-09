package consome.appConsome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrincipalController {
	static String webService = "http://viacep.com.br/ws/";
	static int codigoSucesso = 200;

	@GetMapping("/")
	public ModelAndView informacep() {
		ModelAndView modelAndView = new ModelAndView("Index");
		return modelAndView;
	}
	
}
