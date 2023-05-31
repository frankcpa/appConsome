package consome.appConsome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import consome.appConsome.model.AlunoModel;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	@GetMapping("/cadastro")
	public ModelAndView cadastroDeAluno() {
		ModelAndView modelAndView = new ModelAndView("aluno/cadastrarAluno");
		AlunoModel aluno = new AlunoModel();
		modelAndView.addObject("aluno", aluno);
		return modelAndView;
	}

	@PostMapping("/insere")
	public String cadastroAluno(AlunoModel aluno){
		System.out.println(aluno.getNome());
		return "redirect:/";
	}
}
