package br.com.casadocodigo.loja.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.daos.LivroDAO;
import br.com.casadocodigo.loja.models.Livro;

@Model
public class LivroDetalheBean {
	
	@Inject
	LivroDAO livroDAO;
	
	private Integer id;
	
	private Livro livro;

	public void carregaDetalhe() {
		this.livro = livroDAO.buscaPorId(id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
}
