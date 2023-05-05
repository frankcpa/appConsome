package consome.appConsome.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import consome.appConsome.model.Endereco;
import consome.appConsome.util.*;

import com.google.gson.Gson;

@Controller
public class PrincipalController {
	static String webService = "http://viacep.com.br/ws/";
	static int codigoSucesso = 200;

	@GetMapping("/consomeCEP")
	public ModelAndView buscarCep() throws Exception {
	ModelAndView modelAndView = new ModelAndView("Index");
	String urlParaChamada = webService + "79321052" + "/json";

	try
	{
		URL url = new URL(urlParaChamada);
		HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

		if (conexao.getResponseCode() != codigoSucesso)
			throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

		BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
		String jsonEmString = Util.converteJsonEmString(resposta);

		Gson gson = new Gson();
		Endereco endereco = gson.fromJson(jsonEmString, Endereco.class);
		
		modelAndView.addObject("endereco", endereco);
		return modelAndView;
	}catch(
	Exception e)
	{
		throw new Exception("ERRO: " + e);
	}
	}
}
