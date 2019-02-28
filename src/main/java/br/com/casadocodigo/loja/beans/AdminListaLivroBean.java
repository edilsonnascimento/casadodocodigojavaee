package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.daos.LivroDAO;
import br.com.casadocodigo.loja.models.Livro;

@Model
public class AdminListaLivroBean {
	
	@Inject
	private LivroDAO livroDao;
	
	private List<Livro> livros = new ArrayList<Livro>();
	
	public List<Livro> getLivros(){
		return livroDao.todosLivros();
		
	}

}