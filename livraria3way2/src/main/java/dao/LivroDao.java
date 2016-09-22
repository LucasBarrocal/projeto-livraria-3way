package dao;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import model.Livro;

public class LivroDao implements Dao<Livro,Integer>{
	Logger LOG = Logger.getGlobal();
	
	@Inject
	private EntityManager em;
		
	@Override
	public Livro consultar(Integer codigo){
		return em.find(Livro.class, codigo);
	}
	
	public List<Livro> consultar(String titulo){
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Livro> q = cb.createQuery(Livro.class);
		Root<Livro> root = q.from(Livro.class);
		q.select(root).where(cb.like(root.get("titulo"),"%"+titulo.toUpperCase()+"%"));
		TypedQuery<Livro> query = em.createQuery(q);
		return query.getResultList();

	}
	
	@Override
	public void alterar(Livro Serializable) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Collection<Livro> listar() {
		return null;
	}
	
	@Override
	public void remover(Livro Serializable) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	@Transactional
	public void salvar(Livro livro) {
		
		em.persist(livro);
		
	}
}
