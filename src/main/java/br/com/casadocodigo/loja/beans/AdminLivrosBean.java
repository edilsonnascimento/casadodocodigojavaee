package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

	@Inject
	private FacesContext context;
	
	public String adiciona() {

		livroDao.salvar(livro);
		
		context.getCurrentInstance().getExternalContext()
		.getFlash().setKeepMessages(true);
		
		context.getCurrentInstance()
		.addMessage(null, new FacesMessage("LIVRO CADASTRADO COM SUCESSO !!!"));
		
		this.livro = new Livro();
		
		return "/livro/lista?faces-redirect=true";
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

}
