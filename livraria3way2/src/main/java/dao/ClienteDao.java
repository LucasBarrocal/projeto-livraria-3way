package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import model.Cliente;

public class ClienteDao implements Dao<Cliente, String> {
	
	@Inject
	private EntityManager em;


	@Override
	public void salvar(Cliente cliente) {

	}
	
	@Override
	public Cliente consultar(String nome) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> q = cb.createQuery(Cliente.class);
		Root<Cliente> root = q.from(Cliente.class);
		q.select(root).where(cb.like(root.get("nome"),"%"+nome+"%"));
		TypedQuery<Cliente> query = em.createQuery(q);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public void alterar(Cliente cliente) {
		em.merge(cliente);	
	}
		

	@Override
	public void remover(Cliente cliente) {
		
	}

	@Override
	public List<Cliente> listar() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> q = cb.createQuery(Cliente.class);
		Root<Cliente> root = q.from(Cliente.class);
		q.select(root);
		TypedQuery<Cliente> query = em.createQuery(q);
		return query.getResultList();
	}

}
