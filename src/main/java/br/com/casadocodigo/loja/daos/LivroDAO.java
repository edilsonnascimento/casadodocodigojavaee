package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.casadocodigo.loja.models.Livro;

@Stateful
public class LivroDAO {
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager manager;
	
	public void salvar(Livro livro) {
		manager.persist(livro);
	}

	public List<Livro> todosLivros() {
		return manager.createQuery("SELECT DISTINCT(l) "
				                 + "FROM Livro l JOIN FETCH l.autores", Livro.class)
				      .getResultList();
	}

	public List<Livro> cincoUltimosPublicados() {
		return manager.createQuery("SELECT l FROM Livro l ORDER BY l.dataPublicacao DESC", Livro.class)
				      .setMaxResults(5)
				      .getResultList();
	}

	public List<Livro> demaisLivros() {
		return manager.createQuery("SELECT l FROM Livro l", Livro.class)
				      .setFirstResult(5)
				      .getResultList();
	}

	public Livro buscaPorId(Integer id) {
//		return manager.createQuery("SELECT l FROM Livro l JOIN FETCH l.autores"
	//			                 + " WHERE l.id = :id", Livro.class)
		//		      .setParameter("id", id)
		//		      .getSingleResult();
		return manager.find(Livro.class, id);
	}

}
