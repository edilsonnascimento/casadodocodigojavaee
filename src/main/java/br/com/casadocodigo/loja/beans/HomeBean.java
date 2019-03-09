package br.com.casadocodigo.loja.beans;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.daos.LivroDAO;
import br.com.casadocodigo.loja.models.Livro;

@Model
public class HomeBean {

	@Inject
	private LivroDAO livroDAO;
	
	public List<Livro> ultimosLancamentos() {
		return livroDAO.cincoUltimosPublicados();
	}
	
	public List<Livro> demaisLivros(){
		return livroDAO.demaisLivros();
	}
}
