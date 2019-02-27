package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.casadocodigo.loja.daos.AutorDAO;
import br.com.casadocodigo.loja.daos.LivroDAO;
import br.com.casadocodigo.loja.models.Autor;
import br.com.casadocodigo.loja.models.Livro;

//CDI
@Named
@RequestScoped
public class AdminLivrosBean {
	
	private Livro livro = new Livro();
	
	@Inject
	private LivroDAO livroDao;
	
	@Inject
	private AutorDAO autorDao;
	
	private List<Integer> autoresId = new ArrayList<Integer>();
	
	public void adiciona() {
		
		for (Integer autorId : autoresId) {
			livro.getAutores().add(new Autor(autorId));
		}
		
		livroDao.salvar(livro);
		System.out.println("Livro" + getLivro() + " salvo com sucesso!!");
		this.livro = new Livro();
		this.autoresId = new ArrayList<Integer>();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public List<Autor> getAutores(){
		return autorDao.todosAutores();
	}

	public List<Integer> getAutoresId() {
		return autoresId;
	}

	public void setAutoresId(List<Integer> autoresId) {
		this.autoresId = autoresId;
	}

}
