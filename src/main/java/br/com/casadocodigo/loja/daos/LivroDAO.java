package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.models.Livro;

@Stateless
public class LivroDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Livro livro) {
		manager.persist(livro);
	}

	public List<Livro> todosLivros() {
		return manager.createQuery("SELECT DISTINCT(l) FROM Livro l JOIN FETCH l.autores",Livro.class).getResultList();
	}

}
